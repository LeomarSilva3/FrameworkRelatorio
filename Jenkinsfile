
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
              bat 'mvn test -Dsurefire.suiteXmlFiles="suites/regressao.xml"'
            }
        }
    }
    post{
        always{
            junit allowEmptyResults: true, testResults: 'target/sufire-reports/*.xml'
        }
    }
}
