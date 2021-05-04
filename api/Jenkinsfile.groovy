node {
 
    def buildNum = env.BUILD_NUMBER 
    def branchName= env.BRANCH_NAME
    
    print buildNum
    print branchName

    def registryProjet='registry.gitlab.com/remiliance/registrydockerimage'
    def IMAGE="${registryProjet}:version-${env.BUILD_ID}"
   
   stage('Clone') {
        git 'https://github.com/remiliance/projetAPI_EmployeeController.git'
    }
 

    /* déterminer l'extension */
    if (branchName == "dev" ){
      extension = "-SNAPSHOT"
    }
    if (branchName == "stage" ){
      extension = "-RC"
    }
    if (branchName == "master" ){
      extension = ""
    }


   dir('api') {
     /* Récupération du commitID long */
    def commitIdLong = sh returnStdout: true, script: 'git rev-parse HEAD'

    /* Récupération du commitID court */
    def commitId = commitIdLong.take(7)

    /* Modification de la version dans le pom.xml */
    sh "sed -i s/'-XXX'/${extension}/g pom.xml"

    
    /* Récupération de la version du pom.xml après modification */
    def version = sh returnStdout: true, script: "cat pom.xml | grep -A1 '<artifactId>myapp1' | tail -1 |perl -nle 'm{.*<version>(.*)</version>.*};print \$1' | tr -d '\n'"

     print """
     #################################################
        BanchName: $branchName
        CommitID: $commitId
        AppVersion: $version
        JobNumber: $buildNum
     #################################################
        """

    
    stage('Build Maven') {
        echo 'debut du build'
        sh 'mvn package -Dmaven.test.skip=true' 
        docker.build("$IMAGE", '.')
    }
   
   def imageName='192.168.5.5:5000/api'
   
   stage('Push') {
      docker.withRegistry('http://192.168.5.5:5000', 'my_registry_login') {
         def customImage = docker.build("$imageName:${version}-${commitId}")
         customImage.push()
      }
    sh "docker rmi $imageName:${version}-${commitId}"
   }
   }
}
