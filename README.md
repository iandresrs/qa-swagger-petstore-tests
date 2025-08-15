# PetSwagger API Automation

This project aims to automate testing of the PetSwagger API, starting with the **POST** method and extending to **GET**, **PUT**, and **DELETE**, using **Java**, **Serenity BDD**, and **REST Assured**.

## Project Status
**In Progress:** Currently, only the POST method has been implemented.

---

## Technologies Used
- Java 17
- Gradle
- Serenity BDD
- JUnit 5
- REST Assured

---

## Requirements
- Java 17
- Gradle 7.x or higher

---

## Project Structure

petswagger-automation/
│
├─ src/main/java/io/petstore/swagger/
│  ├─ enums          # Enumerations used in automation
│  ├─ exceptions     # Exception handling classes
│  ├─ models         # Data models for requests and responses
│  ├─ questions      # Questions used in Screenplay
│  ├─ tasks          # Screenplay tasks
│  └─ utils          # Utility classes
│
├─ src/main/resources   # General resources (if applicable)
│
├─ src/test/java/io/petstore/swagger/
│  ├─ runners          # Classes that run the tests
│  └─ stepDefinitions  # Step definitions for Cucumber
│
├─ src/test/resources/
│  ├─ data       # Test data files
│  ├─ features   # Cucumber feature files
│  └─ template   # JSON templates for requests
│
└─ build.gradle   # Gradle dependencies and configuration


---

