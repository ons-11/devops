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

    stage('Maven Env-variable'){
        sh 'export M2_HOME=/usr/local/apache-maven && export M2=$M2_HOME/bin  && export PATH=$M2:$PATH'
    }

    stage('Build - Maven package'){
        sh 'mvn package'
    }

}