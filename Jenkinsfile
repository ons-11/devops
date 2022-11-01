String branchName = "taha-dev"
String gitCredentials = "GITHUB"
String repoUrl ="https://github.com/ons-11/devops"
String dockerCredentials = "DOCKER"
String dockerRepoUrl = ""
String dockerImageName = "tahahamraoui/springboot-app"
String dockerImageTag = "${dockerImageName}:${env.BUILD_NUMBER}"
node {
    echo 'Make build directory'
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