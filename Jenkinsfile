pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
post {
        always  {
           emailext body: 'UBS PipeLine Status Mail', subject: 'UBS PipeLine Status', to: 'ranjan.kumar8953@gmail.com'
        }
    }
}
