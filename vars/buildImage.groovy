#!/usr/bin/env/ groovy

def call(){
    echo 'build the docker image...'
    withCredentials([usernamePassword(credentialsId:'dockerhub-repo', usernameVariable:'DOCKER_USER', passwordVariable:'DOCKER_PASS')]) {
        sh 'docker build -t salman14/mydevfirst:2.0 .'
        sh "echo $DOCKER_PASS| docker login -u $DOCKER_USER --password-stdin  "
        sh 'docker push salman14/mydevfirst:2.0'
    }
}