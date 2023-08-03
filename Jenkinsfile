

pipeline {
    agent any
    tools{
        maven "maven 3.5.0"
    }
    
    stages{   
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
	   
          stage('docker-compose-microservices') {
           	steps {
              	   sh "docker-compose up -d"
           }
       	   }

}
}
