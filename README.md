# Banking Project

## Overview

This project is a microservices-based banking application developed using Java Spring Boot for the backend, Thymeleaf for server-side templating in the frontend, and MySQL for the database. It focuses on implementing CRUD operations for branches and employees, utilizing JPA repositories for data persistence and incorporating exception handling for robust error management.

## Features

- **Backend**: Java Spring Boot
- **Frontend**: Thymeleaf
- **Database**: MySQL

### Microservices Architecture

The project is structured using microservices to ensure modularity and scalability. It includes entities and repositories for managing relationships such as "One Branch can have many Employees" (one-to-many) using JPA (Java Persistence API).

### Exception Handling

Exception handling is implemented throughout the application to gracefully manage errors and provide meaningful responses to users and developers.

### Thymeleaf Integration

Thymeleaf is used for server-side rendering of HTML templates, seamlessly integrating frontend views with backend logic. It connects to the Spring Boot backend and interacts with JPA repositories to perform CRUD operations on the MySQL database.

### User Interface (UI) and Navigation

- **Login**: Users authenticate to access the application.
- **Branch Service Page**:
  - `getAllBranches`: Retrieves all branches.
  - `deleteBranch`: Deletes a branch.
  - `addBranch`: Adds a new branch.
  - `editBranch`: Updates branch information.
  
- **Employee Service Page**:
  - `getAllEmployeesByBranchId`: Retrieves employees by branch ID.
  - `getEmployees`: Retrieves all employees.
  - `deleteEmployee`: Deletes an employee.
  - `addEmployee`: Adds a new employee.
  - `editEmployee`: Updates employee information.

## Project Structure

The project follows best practices in Spring Boot development, emphasizing separation of concerns and modular design. It showcases integration of frontend and backend technologies to deliver a cohesive banking management system.

## Usage

To run the project locally:

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/banking-project.git
   cd banking-project
