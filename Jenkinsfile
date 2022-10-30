String branchName = "taha-dev"
String gitCredentials = "GITHUB"
String repoUrl ="https://github.com/ons-11/devops"

node {
    echo 'Make build directory'
    sh 'mkdir -p build'

    stage('Clone'){
        echo 'Cloning files from (branch: "' + branchName +'" )'
        dir('build') {
            git branch : branchName, credentialsId: gitCredentials, url: repoUrl 
        }
    }
    stage('build'){
        sh "/usr/local/apache-maven/bin/mvn clean package"
    }
}