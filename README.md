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
    
### NOTE
  Since the database is empty at the start, add an employee first using the api.

## API
  ### GET | Get all employees currently in database.
    localhost:8080/api/employee/
  ### GET | Get employee by id.
    localhost:8080/api/employee/{id}
  ### POST | Add employee
    localhost:8080/api/employee/
    
    Add DTO - Example
    {
      "firstName": "Prabuddha",
      "lastName": "Alahakoon",
      "departmentId": 1,
      "nic": "123456789V",
      "address": "emp address 123",
      "phoneNumber": "0712345678"
    }
    
  ### PUT | Update employee
    localhost:8080/api/employee
    
    Update DTO - Example
    {
      "id":1
      "firstName": "Prabuddha",
      "lastName": "Alahakoon",
      "departmentId": 1,
      "nic": "123456789V",
      "address": "emp address 123",
      "phoneNumber": "0712345678"
    }
    
  ### DELETE | Delete employee by id.
     localhost:8080/api/employee/{id}
    
  
   
