# docker-demo

This project was created in order for me to learn how to dockerize an spring boot api application with mysql.

## Instructions

To run the application excecute the folowing commands in order.

### 1. make build 
  Excecute this command to build the jar file.
  
### 2. make push
  Excecute this command to build the docker image, tag the image and push to docker public registry.

### 3. docker-compose up
  Excecute this command to run the dockerized application.
  
### Ports
  Spring application: 
    Docker Host: 8080
    Container Port: 8080
  
  Mysql: 
    Docker Host: 3307
    Container Port: 3306

