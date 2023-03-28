def call() {
	pipeline {
		agent any
		environment {
			IMAGE_REPO_NAME="demo-repository"
			REPOSITORY_URI = "dhruv-garg/${IMAGE_REPO_NAME}"
			DOCKERHUB_CREDENTIALS=credentials('dockerhub')
		}
		stages {
			stage('Building image') {
				steps {
					sh 'docker build -t $REPOSITORY_URI .'
				}
			}
			stage('Loggin to Dockerhub') {
				steps {
					sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
				}
			}
			stage('pushing to docker hub') {
				steps {
					sh 'docker push $REPOSITORY_URI'
				}
			}
		post {
			always {
				sh 'docker logout'
			}
		}
	}
}
