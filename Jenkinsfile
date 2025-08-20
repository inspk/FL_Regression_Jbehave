pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        gitLabConnection('myGitlab')
    }
    
    tools {
        jdk 'JDK10.0.1'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'sh mvnw clean install -DskipTests=true -q -U'
            }
        }
        stage('Deploy to Maven') {
            environment {
                ARTIFACTORY = credentials('artifactory.hhstechgroup.com')
            }
            when {
                branch 'develop'
            }
            steps {
                retry(3) {
                    timeout(2) {
                        echo 'Deploy to Artifactory'
                        sh 'sh mvnw deploy -DskipTests=true -s settings.xml -q'
                    }
                }
            }
        }
    }
    post {
        success {
            updateGitlabCommitStatus(name: 'jenkins', state: 'success')
            script {
               if (currentBuild.getPreviousBuild() &&
                   currentBuild.getPreviousBuild().getResult().toString() != "SUCCESS") {
                   emailext (
                              subject: "Build is back to normal!: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                              body: '${SCRIPT, template="groovy-html.template"}',
                              to: "DevOps@HHSTechGroup.com",
                              recipientProviders: [[$class: 'CulpritsRecipientProvider']]
                    )
               }
            }
        }
        failure {
            script {
                USEREMAIL = sh (script: 'git show -s --format=%ae',returnStdout: true)
            }
            emailext (
                      subject: "Build failed: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                      body: '${SCRIPT, template="groovy-html.template"}',
                      to: "DevOps@HHSTechGroup.com, ${USEREMAIL}",
                      recipientProviders: [[$class: 'DevelopersRecipientProvider']]
            )
            updateGitlabCommitStatus(name: 'jenkins', state: 'failed')
        }
    }
}
