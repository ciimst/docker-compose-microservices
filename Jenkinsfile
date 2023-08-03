stage('Email Notification'){
    mail bcc: '', body: '''Build successful!!!!
    Thanks,
    Ayse''', cc: '', from: '', replyTo: '', subject: 'Build successfull', to: 'aysayparcasi@gmail.com'
    echo 'e-mail OK!'
}

pipeline {
    agent any
    tools{
        maven "maven 3.5.0"
    }
    
    stages{   
	  stage('Build Maven'){
		 steps{
			checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '13daaff0-994d-486d-8d1b-0f050daeeb26', url: 'https://github.com/ciimst/docker-compose-microservices.git']])
			sh 'mvn clean install'
	   }
	   }
          stage('docker-compose-microservices') {
           	steps {
              	   sh "docker-compose up -d"
           }
       	   }

}
