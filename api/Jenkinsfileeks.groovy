node {
 
    def buildNum = env.BUILD_NUMBER 
    def branchName= env.BRANCH_NAME
    
    print buildNum
    print branchName
    def registryCredentialSet = 'dockerhub'
    def registryProjet = 'https://hub.docker.com/repository/docker/rliance/mondockerrepo'
    def IMAGE="${registryProjet}:version-${env.BUILD_ID}"
    	
   stage('Clone') {
        git 'https://github.com/remiliance/projetAPI_EmployeeController.git'
   }

   dir('api') {
   stage('Build Maven') {
        echo 'debut du build'
        sh 'mvn package -Dmaven.test.skip=true' 
    
    }
	   
   def img = stage('Build Docker Image') {
          docker.build("$IMAGE",  '.')
    }

    stage('Push') {
	    docker.withRegistry('',registryCredentialSet){
	   	img.push 'latest'
  		img.push()
      }   
      sh "docker rmi $imageName:${buildNum}"
    }
   }
}
