pipeline {
    agent any
    environment {
        SONAR_HOME = tool "Sonar"
    }
    stages {
        stage("Clone Code from Github") {
            steps {
                git url: "https://github.com/hardiklokwani/wanderlust", branch: "devops"
            }
        }
        stage("Sonarqube quality analysis") {
            steps {
                script {
                    withSonarQubeEnv("Sonar") {
                        sh "${SONAR_HOME}/bin/sonar-scanner -Dsonar.projectName=wanderlust -Dsonar.projectKey=wanderlust"
                    }
                }
            }
        }
        stage("OWASP Dependency Check") {
            steps {
                dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'owasp'
                dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
            }
        }
        stage("Sonar Quality Gate Scan"){
            steps{
                timeout(time: 2, unit: "MINUTES"){
                    waitForQualityGate abortPipeline: false
                }
            }
        }
        stage("Trivy File System Scan") {
            steps {
                sh "trivy fs --format table -o trivy-fs-report.html ."
            }
        }
        stage("Deploy using docker compose"){ 
            steps{
                sh "docker-compose up -d"
            }
        }
    }
}
