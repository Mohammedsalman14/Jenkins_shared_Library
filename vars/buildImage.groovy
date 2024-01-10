#!/usr/bin/env/ groovy

def call(String imageName){
    echo 'build the docker image...'
    withCredentials([usernamePassword(credentialsId:'dockerhub-repo', usernameVariable:'DOCKER_USER', passwordVariable:'DOCKER_PAS')]) {
        sh "docker build -t ${imageName} ."
        sh "echo ${DOCKER_PAS}| docker login -u ${DOCKER_USER} --password-stdin  "
        sh "docker push ${imageName}"
    }
}


// salman14/mydevfirst:2.0