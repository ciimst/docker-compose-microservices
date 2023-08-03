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
          stage('docker-compose-microservices') {
           steps {
              sh "docker-compose up -d"
           }
       }
}
}
