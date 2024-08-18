# Overview
A RESTful API service built using Spring Boot to manage the exam enrollment process for a Learning Navigator. The application uses MySQL to persist user data.

# Features
* CRUD Operations: Perform Create, Read, Update and Delete operations for Students, Subjects and Exams.
* Enrollment Logic: Ensure students can  register for exams and enroll subjects.
* GlobalExceptionHandler: Centralized exception handling using @ControllerAdvice for improved code maintainability.

# Getting Started
## Prerequsites
* Java 17 or higher
* MySQL
* Postman for API testing

## Configuration
1. Open the application.properties file located in src/main/resources directory.
2. Configure the MySQL database connection settings:
   
   spring.datasource.url = jdbc:mysql://localhost:3306/learning_navigatorV2
   spring.datasource.username = root
   spring.datasource.password = password
   Replace localhost, 3306, root, and password with your MySQL host, port, username and password respectively.
4. Save the changes to the application.properties file.

## Running the Application
Run the application using Gradle:  
./gradlew bootrun

# API Endpoints
You can find the API endpoints and test them using the provided:  https://elements.getpostman.com/redirect?entityId=36793359-6dd45719-cb4f-4f32-81d7-f0b3ef02b9b3&entityType=collection
  
