# Welcome to the Girls in Tech project 

This application aims to connect middle and high school students with women working in technology and to support them in pursuing studies in STEM fields.

This project uses : Java(SDK 21) Spring Boot(3.3.4), Angular(17) and PostgreSQL.

# Installation
Prerequisites

Make sure you have installed:
- Node.js
- Angular CLI
- Java 21
- Maven
- PostgreSQL

## DataBase
Two scripts are provided to set up the database: 

1 - `schema_ddl.sql`: Data Definition Language (DDL) script used to create the database structure.

2 - `data_dml.sql`: Data Manipulation Language (DML) script used to initialize sample data.

First, create the database for the project with the following command, then run the scripts below:

```sql
CREATE DATABASE girls_in_tech_database;
```

## Backend
This is a Spring Boot 3 project based on a layered architecture.

- Controller: contains the REST controllers.
- Service: contains the business logic.
- Repository: handles persistence and database access using JPA/Hibernate.

### Configure the application

1 - In the `girls-in-tech-business/src/main/resources/`, create your own local configuration file.

2 - Add the following properties and replace the placeholder values with your local settings:
 ```
spring.application.name=girls-in-tech-business

spring.datasource.url=jdbc:postgresql://localhost:<port>/<database-name>
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

co.simplon.girls_in_tech.cors=http://localhost:4200/
co.simplon.girls_in_tech.toursBCrypt=<bcrypt-strength>
co.simplon.girls_in_tech.secretJWT=<your-jwt-secret>
co.simplon.girls_in_tech.expirationMinutes=<token-expiration-in-minutes>
co.simplon.girls_in_tech.issuer=http://localhost:8080
 ```
 
Run as `Spring Boot App`

### Front-end

Install the dependencies:
```bash
npm install
```
Start the development server:
```bash
ng serve
```
