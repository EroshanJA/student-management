# Student Management Application

A simple Student Management application built with Spring Boot, using an in-memory collection to store student data. The application provides RESTful endpoints to manage students and a frontend with Bootstrap to interact with the backend.

## Features

- Add new students with their names and average grades.
- Display a list of all students with color-coded average grades:
  - **Green:** Average grade > 80%
  - **Orange:** Average grade between 50% and 80%
  - **Red:** Average grade < 50%
- Delete students from the list.
- Simple, responsive frontend using Bootstrap.

## Technologies Used

- **Backend:** Spring Boot, Java
- **Frontend:** HTML, JavaScript, jQuery, Bootstrap
- **Testing:** JUnit 5, Spring Boot Test

## Prerequisites

- **Java**: 11 or higher
- **Maven**: 3.6.0 or higher

## Build the project
mvn clean install

## Run the Application
mvn spring-boot:run

## Run unit test
mvn test

### Clone the Repository
git clone https://github.com/your-username/student-management.git
cd student-management

### Future Enhancements
Implement user authentication.
Integrate a real database (e.g., MongoDB, MySQL, PostgreSQL).
Enhance the frontend with additional features and more advanced styling.
