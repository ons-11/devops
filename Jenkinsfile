String branchName = env.BRANCH_NAME
String gitCredentials = "CREDENTIAL_ID"
String repoUrl ="https://github.com/ons-11/devops"

node {
    stage('Clone'){
        echo 'Cloning files from (branch: "' + branchName +'" )'
        dir('build') {
            git branch : branchName, credentialsId: gitCredentials, url :repoUrl 
        }
    }
}