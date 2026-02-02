# Work Application

**Description:**  
Spring Boot 3 application to fetch product prices based on date, product, and brand. Uses H2 in-memory database and Flyway migrations for schema management.

---

## Table of Contents

1. [Features](#features)
2. [Prerequisites](#prerequisites)
3. [Project Structure](#project-structure)
4. [Running the Application](#running-the-application)

---

## Features

- Fetch product prices for a specific date, product, and brand.
- Uses **JPA/Hibernate** for persistence.
- **Flyway** for database schema and data migrations.
- **H2 console** for debugging and inspecting data.
- Integration tests with parameterized data scenarios.

---

## Prerequisites

- Java 21 SDK
- Maven 3.8+
- (Optional) IDE: IntelliJ, VSCode, Eclipse

---

## Project Structure

This application is based on Hexagonal Architecture, where the adapters handle the external parts (like REST controllers or database access) and the application folder contains the core business logic.
The domain classes are organized within each module (adapter and application) instead of a separate, independent folder. This way, if you work with a specific module, you have all the domain classes you need together. 


## Running the Application

This project runs with **Java 21 SDK** and Spring Boot 3.

### 1. Prerequisites

- Java 21 installed and set as `JAVA_HOME`
- Maven installed
- Optional: [H2 Database Console](http://localhost:8080/h2-console) for inspecting the in-memory database

Check your Java version:

```bash
java -version
```

2. Build the Project

Use Maven to build the project:
```mvn clean install```


This compiles the project, runs tests, and generates the JAR file in target/.

3. Run the Application
a) Using Maven:
  ``` mvn spring-boot:run```

b) Using the JAR:
```java -jar target/work-0.0.1-SNAPSHOT.jar```