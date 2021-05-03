node {
 
    def buildNum = env.BUILD_NUMBER 
    def branchName= env.BRANCH_NAME
    
    print buildNum
    print branchName

    def registryProjet='registry.gitlab.com/remiliance/registrydockerimage'
    def IMAGE="${registryProjet}:version-${env.BUILD_ID}"
   
   stage('Clone') {
        git 'https://github.com/remiliance/projet_panier_produit.git'
    }
 
    stage('Build Maven') {
        echo 'debut du build'
        sh 'mvn -DskipTests=true package' 
        docker.build("$IMAGE", '.')
    }
   
   def imageName='192.168.5.5:5000/api'
   
   stage('Push') {
      docker.withRegistry('http://192.168.5.5:5000', 'my_registry_login') {
         def customImage = docker.build("$imageName")
         customImage.push()
      }
   }
}
