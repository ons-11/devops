pipeline {
  agent any
  tools {
     jdk 'JAVA_HOME'
     maven 'M2_HOME'    
  }
  

  stages {
       
    stage ('Artifact construction') {
            steps {
                sh 'echo "Artifact construction is processing ...."'
                sh 'mvn -DskipTests package'
            }
            
        }

     
    stage("SonarQube ") {
            steps {
              withSonarQubeEnv('SonarQube') {
                sh 'mvn clean -DskipTests package sonar:sonar'
              }
            }
          }
    stage("NEXUS") {
			steps {
						sh 'mvn clean deploy -DskipTests'
      }
    }
	  stage('Docker build image') {
      steps {
         sh 'echo "Docker build image is processing ...."'
        sh 'docker build -t sirinerbesprit/achat:1.0 .'

      }
    }
     stage('Docker login') {
      steps {
         sh 'echo "Docker login is processing ...."'
        sh 'docker login --username sirinerbesprit --password 204JFT1273'

      }
    }
    stage('Docker push') {
      steps {
         sh 'echo "Docker push is processing ...."'
        sh 'docker push sirinerbesprit/achat:1.0'

      }
    }
    stage('Running Back') {
      		steps {
         		sh 'docker-compose up -d'
      }
    }
  }
	  post {
    success { mail to: "sirine.rbei@esprit.tn",
                    subject: "Build sucess",
                    body: "sucess"
             echo 'successful'}
    failure { mail to: "sirine.rbei@esprit.tn",
                    subject: "Build failed",
                    body: "failed"
             echo 'failed'}
  }
}
