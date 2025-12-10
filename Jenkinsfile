pipeline {
    agent any

    stages {
        stage('Build Backend') {
            steps {
                dir('backend') {
                    script {
                        echo 'Building the Spring Boot backend...'
                        sh './gradlew clean build'
                    }
                }
            }
        }
        stage('Build Frontend') {
            steps {
                dir('frontend') {
                    script {
                        echo 'Building the React frontend...'
                        sh 'npm install'
                        sh 'npm run build'
                    }
                }
            }
        }
        stage('Run Tests') {
            parallel {
                stage('Backend Tests') {
                    steps {
                        dir('backend') {
                            script {
                                echo 'Running backend tests...'
                                sh './gradlew test'
                            }
                        }
                    }
                }
                stage('Frontend Tests') {
                    steps {
                        dir('frontend') {
                            script {
                                echo 'Running frontend tests...'
                                sh 'npm test -- --watchAll=false'
                            }
                        }
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    echo 'Deploying the application...'
                    // Add deployment steps here (e.g., building Docker images, pushing to a registry, etc.)
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished.'
            cleanWs()
        }
    }
}
