pipeline {
    agent any
    tools {
        maven 'MAVEN_PATH'
        jdk 'jdk8'
    }
    stages {
        stage("Tools initialization") {
            steps {
                sh "mvn --version"
                sh "java -version"
            }
        }
        stage("Checkout Code") {
            steps {
                checkout scm
            }
        }
        stage("Check Code Health") {
           steps {
               sh "mvn clean compile"
            }
        }
        stage("Run Test cases") {
           steps {
               sh "mvn clean test"
            }
        }
        stage("Build & Deploy Code") {
            steps {
                sh "mvn clean install"
            	sh "docker stop \$(docker ps --filter status=running -q)"
            	sh "docker rm \$(docker ps --filter status=exited -q)"
            	sh "docker build -t plnc/petclinic ."
            	sh "docker run -d -p 8081:8081 -t plnc/petclinic"
            }
        }
    }
 }
