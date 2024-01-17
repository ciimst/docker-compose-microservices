

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
	stage('Sonarqube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn clean package sonar:sonar' 
                }
            }
        }

	stage("Quality Gate"){
            steps {
                script{
                  sleep(5)
                  timeout(time: 1, unit: 'HOURS') {
                      def qg = waitForQualityGate()
                      if (qg.status != 'OK') {
                          error "Pipeline aborted due to quality gate failure: ${qg.status}"
			  mail bcc: '', body: '''SonarQube Quality Gate Test Failure!!!!
			  Thanks,
			  Ceylan''', cc: '', from: '', replyTo: '', subject: 'SONARQUBE QUALITY GATE IS FAILED!!', to: 'aysayparcasi@gmail.com'
			  echo 'SonarQube Quality Gate Test Failure!'  
                      }
                    }
                }
            }
        }       
	stage('docker-compose-microservices') {
	    steps {
		sh "docker-compose up -d"
	    }
	}

   }
}
