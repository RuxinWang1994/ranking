# Assignment: ranking

## Description

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

## Mandatory Requirements

This application creates REST APIs to solve these requirements:

1. Delete
2. Update
3. GetById
4. GetAll

## Technologies

- Java 8
- Spring Boot 2.1.3.RELEASE
- REST API

## How to compile and run the application with an example for each call

Build: mvn package

Deploy: mvn spring-boot:run

## Examples for each call

{{URL}}/employees
{{URL}}/employees/employee/1
{{URL}}/employee
{{URL}}/erase

To facilitate the execution of the calls:

All the others requests are in the file "SpringBoot.postman_collection.json" in the "src/main/resources/postman/" folder with its configuration ("Spring Boot.postman_environment.json").
The file must be imported into the Postman (https://www.getpostman.com/) application.
How-to: https://support.smartbear.com/readyapi/docs/testing/integrations/postman.html#importing-a-postman-collection
