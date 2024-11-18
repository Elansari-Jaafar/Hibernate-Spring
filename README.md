# Hibernate-Spring Project

## Overview
This project demonstrates a basic integration of **Hibernate** with **Spring Framework** to perform CRUD operations on a MySQL database. The project uses Hibernate as the ORM tool and Spring for dependency injection and transaction management.

## Project Structure
```
 ├── pom.xml # Maven configuration
 ├── src
 │ ├── main
 │ │ ├── java
 │ │ │ ├── dao
 │ │ │ │ └── IDao.java # Generic DAO interface
 │ │ │ ├── entities
 │ │ │ │ └── Product.java # Product entity
 │ │ │ ├── metier
 │ │ │ │ └── ProductDaoImpl.java # DAO implementation
 │ │ │ ├── util
 │ │ │ │ └── HibernateConfig.java # Hibernate configuration
 │ │ │ └── Presentation.java # Main application entry point
 │ │ └── resources
 │ │ └── application.properties # Spring configuration properties
 │ └── test
 │ └── java # Test directory
 └── .env # Environment variables for sensitive data
```

## Prerequisites

- Java 17
- Maven 3.x
- MySQL Server

## Dependencies

The project uses the following dependencies:
- Spring Context
- Spring ORM
- Spring Transaction
- Hibernate Core
- MySQL Connector
- dotenv-java (for environment variable management)

## Setup and Configuration

### 1. Database Setup
Create a MySQL database named `hibernate-tp` (or adjust the name in `application.properties` if needed).

```sql
CREATE DATABASE hibernate_tp;
```
### 2. Environment Variables
Create a *.env* file in the project root to store sensitive information:
```
DB_USERNAME=your_username_here
DB_PASSWORD=your_password_here
```
### 
3. Maven Dependencies
The required dependencies are specified in the *pom.xml*. Run the following command to download them:
```
mvn clean install
```
### 4. Application Properties
The *application.properties* file contains the database and Hibernate configuration:
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/hibernate-tp?serverTimezone=UTC
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

# Hibernate properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
### 5. Running the Application
To run the application, execute the **Presentation.java** file. This will:

  1. Create a new product.
  2. Save it to the database.
  3. Print confirmation to the console.
### 6. Verify Database Changes
Check the **hibernate-tp** database to verify that the product has been saved in the corresponding table.
```
SELECT * FROM Product;
```
## Key Classes
### 1. IDao.java
A generic interface defining CRUD operations.

### 2. Product.java
An entity class mapped to the **Product** table in the database.

### 3. ProductDaoImpl.java
Implements the **IDao** interface for **Product** objects using Hibernate.

### 4. HibernateConfig.java
Configures Hibernate and Spring integration, including:

  - DataSource setup
  - SessionFactory configuration
  - Transaction management
### 5. Presentation.java
Entry point of the application where a sample product is created and saved.

## Technologies Used
  - Spring Framework: Dependency injection and transaction management.
  - Hibernate ORM: For database operations.
  - MySQL: Database management.
  - dotenv-java: Managing environment variables.
## How to Extend
  - Add more entities following the **Product.java** example.
  - Extend **ProductDaoImpl.java** to include custom queries.
  - Add unit tests in the **src/test/java** directory.
## Troubleshooting
  - Ensure the **.env** file is in the root of the project and contains valid credentials.
  - Verify the MySQL server is running and accessible.
  - Check **application.properties** for correct database connection settings.
## Author
### Elansari Jaafar
[GitHub Profile](https://github.com/Elansari-Jaafar)
## License
This project is open-source and available under the **MIT License**.
