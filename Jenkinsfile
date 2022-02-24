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
            when {
                not {
                    anyOf {
                        branch 'master';
                        branch 'develop'
                    }
                }
           }
           steps {
               sh "mvn clean compile"
            }
        }
        stage("Run Test cases") {
            when {
                branch 'develop';
            }
           steps {
               sh "mvn clean test"
            }
        }
        stage("Build & Deploy Code") {
            when {
                branch 'master'
            }
            steps {
                sh "mvn clean install"
            	sh "docker stop $(docker ps --filter status=running -q)"
            	sh "docker rm $(docker ps --filter status=exited -q)"
            	sh "docker rmi $(docker images)"
            	sh "docker build -t plnc/petclinic ."
            	sh "docker run -d -p 8081:8081 -t plnc/petclinic"
            }
        }
    }
 }
