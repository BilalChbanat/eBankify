# Online Banking Management Application (eBankify)

## Project Overview
This project aims to develop an online banking management application with a RESTful, modular architecture using **Spring Boot**, **Spring Data JPA**, and **Liquibase** for database management. The application provides role-based access for different user roles (Admin, User, and Employee) with specific permissions. It supports centralized exception handling, robust data validation, and transaction management with comprehensive auditing and quality control.

## Key Concepts

1. **RESTful Architecture**: A design pattern for creating APIs that allow client-server communication. It uses HTTP methods (GET, POST, PUT, DELETE) for interacting with resources, represented as URLs, making APIs stateless and scalable.

2. **Role-Based Access Control (RBAC)**: A security approach where users are assigned specific roles that dictate their permissions within the application. Here, **Admin**, **User**, and **Employee** roles have distinct access levels:
   - **Admin**: Full access to manage users, accounts, transactions, and application-wide settings.
   - **User**: Access to personal accounts and transaction management.
   - **Employee**: Access to view and approve transactions but not manage accounts.

3. **Entity-Relationship Management**: Management of database entities (like Users, Accounts, and Transactions) with **Spring Data JPA** for automatic query generation and ORM (Object-Relational Mapping). ORM allows the application to interact with the database in an object-oriented manner.

4. **Centralized Exception Handling**: An approach to handle all exceptions in a single, centralized place in the application, returning consistent error messages in JSON format. This makes error handling more efficient and user-friendly.

5. **Liquibase for Database Versioning**: Liquibase is used for managing database migrations (schema changes over time). It keeps track of each change made to the database schema in a structured changelog file, allowing for controlled and versioned database updates across different environments.

6. **Data Validation**: Ensuring that user inputs meet specified criteria to maintain data integrity. This project uses validation annotations (e.g., `@NotNull`, `@Size`) to enforce rules on data input.

7. **Lombok and MapStruct**:
   - **Lombok**: Reduces boilerplate code by automatically generating getters, setters, builders, and more.
   - **MapStruct**: A mapper that converts entities to DTOs (Data Transfer Objects) and vice versa, used here to separate API models from database models.

8. **Testing and Quality Assurance**:
   - **JUnit**: A testing framework for unit testing. This ensures that individual parts of the application work as expected.
   - **SonarQube**: A tool for code quality control (optional). It analyzes code for bugs, vulnerabilities, and code smells, ensuring that the project meets high-quality standards.

9. **Encryption**:
   - **Bcrypt**: Used for secure password hashing to ensure that passwords stored in the database are protected against unauthorized access.

## Technologies Used
- **Spring Boot**: Framework for building Java-based RESTful APIs quickly and efficiently.
- **Spring Data JPA**: Simplifies data access, especially in applications with complex data requirements, by providing repositories that auto-generate SQL queries.
- **Liquibase**: Manages database migrations with changelog files for version control.
- **JUnit**: For testing individual units of the application code.
- **Lombok**: Reduces boilerplate code in Java by generating common methods.
- **MapStruct**: Efficiently maps between entity models and data transfer objects (DTOs).
- **SonarQube**: Monitors and improves code quality.
- **Bcrypt**: Encrypts passwords for enhanced security.

## Key Features
1. **Role-Based Access Control**
2. **Account Management**
3. **Transaction Management**
4. **Invoice and Loan Management**
5. **Centralized Exception Handling**
6. **Database Versioning**
7. **Unit Testing and Quality Control**

## Getting Started

### Prerequisites
- **Java 11 or higher**
- **Maven**
- **PostgreSQL**

### Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/BilalChbanat/eBankify.git
