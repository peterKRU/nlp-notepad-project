pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN3"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/peterKRU/nlp-notepad-project.git'

                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true install"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        
        stage ('Build docker-image') {
        	steps {
        		script {
        			sh 'docker build -t ololo .'
        		
        		}
        	
        	}
        
        }
        
    }
}
