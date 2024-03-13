
# Spring Boot CRUD Operations with PostgreSQL

The project demonstrates basic CRUD (CREATE, READ, UPDATE, DELETE) operations using Spring Boot and PostgreSQL database.

### Requirements

- Java 21
- Maven
- PostgreSQL database
- IDE (Eclipse, IntelliJ IDEA, etc.)

### Getting Started

- Clone the repository: https://github.com/SaeedGooda/SPRING-BOOT-CRUD-OPERATIONS.git

- Import the project into your IDE.

- Update the application.properties file with your PostgreSQL database configurations.

- Run the application:

```shell
mvn spring-boot:run
```

### The application exposes the following API endpoints:

- ```GET /api/v1/student``` get all students
- ```GET /api/v1/student/{studentId}``` get student by id
- ```POST /api/v1/student``` add a new student
- ```PUT /api/v1/student/{studentId}``` update student by id
- ```DELETE /api/v1/student/{studentId}``` delete student by id
