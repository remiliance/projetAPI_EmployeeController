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

   dir('api') {
   stage('Build Maven') {

        echo 'debut du build'
        sh 'mvn package -Dmaven.test.skip=true' 
        docker.build("$IMAGE", '.')
    }
   
   def imageName='192.168.5.5:5000/api'
   
   stage('Push') {
      docker.withRegistry('http://192.168.5.5:5000', 'my_registry_login') {
         def customImage = docker.build("$imageName:${buildNum}")
         customImage.push()
      }
     /*permet de supprimer l'image de jenkins*/
    sh "docker rmi $imageName:${buildNum}"
   }
     /* Docker - test */
    stage('DOCKER - check registry'){
      withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'my_registry_login',usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
      sh 'curl -sk --user $USERNAME:$PASSWORD https://192.168.5.5:5000/v2/api/tags/list'
      }
    }

   }
}
