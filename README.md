# Library Inventory Web Application

## Overview
This is a full-stack **Library Inventory Management Web Application** built with **Java**, **Spring Framework**, and **Jakarta EE** technologies.  
It allows managing library books and users through both a **JSF web interface** and **RESTful APIs**.

## Features
- **Book Management**: Add, update, delete, and list books.
- **User Authentication**: Login and session handling via JSF managed beans.
- **REST API**: Exposes `/api/books` endpoints to interact with the system.
- **DAO Layer**: Clean separation of persistence logic with `BookDAO` and `UserDAO`.
- **Service Layer**: Business logic handled by `BookService` and `AuthService`.
- **Database**: Configured with JPA/Hibernate and supports PostgreSQL/MySQL.

## Tech Stack
- **Java 17+**
- **Spring Framework (IoC/DI, JPA integration)**
- **Jakarta EE** (Servlets, JSF, JPA, JAX-RS)
- **Hibernate / JPA** for ORM
- **Maven** for build and dependency management
- **PostgreSQL / MySQL** as database
- **Apache Tomcat** for deployment

## Project Structure
src/main/java/org/eastnets/
├── bean/ # JSF Managed Beans
├── dao/ # Data Access Objects
├── model/ # Entities (Book, User)
├── rest/ # REST Resources (BookResource, ApplicationConfig)
└── service/ # Business Services


## Configuration
- **Persistence**: `src/main/resources/META-INF/persistence.xml`
- **Spring/JSF Configs**: `src/main/webapp/WEB-INF/`

## Running the Project
1. Clone the repository:
   ```bash
   git clone https://github.com/YourUsername/LibraryInventoryWeb.git
   
2.Navigate into the project:
  cd LibraryInventoryWeb

3.Build with Maven:
  mvn clean install

4.Deploy to Tomcat (or run in IntelliJ with Tomcat plugin).

REST Endpoints

GET /api/books → List all books
POST /api/books → Add new book
PUT /api/books/{id} → Update a book
DELETE /api/books/{id} → Delete a book

Future Improvements

Add JWT authentication for REST API.
Extend UI for advanced book search/filter.
Add user roles (Admin, Librarian, Member).
Dockerize the application for easier deployment.

Author

👤 Hazem Abdeen

LinkedIn: linkedin.com/in/hazem-abdeen-624374248
GitHub: https://github.com/YourUsername
