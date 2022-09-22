
pipeline {
    agent any
    stages{
        stage('Build'){
            steps{
                bat 'mvn clean install -DskipTests=true'
            }
        }
        stage('Regressao'){
            steps{
              bat 'mvn test -DTest="RelizarLogin,RealizarLoginAlternativos"'
            }
        }
    }
    post{
        always{
            junit allowEmptyResults: true, testResults: 'target/sufire-reports/*.xml'
        }
    }
}
