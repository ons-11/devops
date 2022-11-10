String branchName = "taha-dev"
String gitCredentials = "GITHUB"
String repoUrl ="https://github.com/ons-11/devops"
String dockerCredentials = "DOCKER"
String dockerRepoUrl = ""
String dockerImageName = "tahahamraoui/springboot-app"
String dockerImageTag = "${dockerImageName}:${env.BUILD_NUMBER}"

node {
    echo 'Create build directory'
    sh 'mkdir -p build'

    stage('Git - Clone'){
        echo 'Cloning files from (branch: "' + branchName +'" )'
        dir('build') {
            sh 'rm -rf ./*'
            git branch : branchName, credentialsId: gitCredentials, url: repoUrl 
        }
    }

    stage('Maven - Build'){
        dir('build'){
        sh "/usr/local/apache-maven/bin/mvn clean package"
        }
    }

         // stage ('Maven Test Sonar') { 
           // dir('build') {
             //   sh 'mvn sonar:sonar -Dsonar.host.url=http://172.20.10.6:9000 -Dsonar.login=44455bf5678a0df3152e7b996af0b462ccff19c0'
            //}

        //}


        
    stage('Maven - Deploy'){
        dir('build'){
            sh "/usr/local/apache-maven/bin/mvn deploy"
        }
    }

    def dockerImage = stage('Docker - Build image'){
        dir('build'){
        docker.build(dockerImageTag , '.')
        }
    }

     stage('Docker - Push image') {
       withDockerRegistry([ credentialsId: dockerCredentials , url: dockerRepoUrl ]) {
        dockerImage.push()
        }
    }   
}