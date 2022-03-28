pipeline {
    agent any
	
	environment {
		registry = "peterktastanow/nlp-notepad-project"
		registryCredential = 'dockerhub'
		dockerImage = ''
	}
	
    tools {
        // Configure maven
        maven "MAVEN3"
    }

    stages {
        stage('Build maven project') {
            steps {
                // Clone github repository
                git 'https://github.com/peterKRU/nlp-notepad-project.git'

                // Trigger maven build
                bat "mvn -Dmaven.test.failure.ignore=true install"
            }

            post {
            	//Run JUnit tests and archive new .jar artifact
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    //archiveArtifacts 'target/*.jar'
                    //test
                    archiveArtifacts 'C:/Users/Peter/Desktop/TESTS/Artifacts/*.jar'
                }
            }
        }
        
        stage('Clone updated git repository') {
        	steps {
        		git 'https://github.com/peterKRU/nlp-notepad-project.git'
        	}
        }
        
        stage('Build docker image') {
        	steps {
        		script{
        			dockerImage = docker.build registry + ":$BUILD_NUMBER"
        		}
        	
        	}
        }
        
        stage('Deploy docker image') {
        	steps {
        		script {
        			docker.withRegistry( '', registryCredential ) {
					dockerImage.push()
					}
        		}
        	}
        }
        
    }
}
