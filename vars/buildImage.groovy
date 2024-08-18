#!/usr/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'DockerHubUserPass', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t ahmedasifcs/javaapp-maven .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push ahmedasifcs/javaapp-maven'
    }
}