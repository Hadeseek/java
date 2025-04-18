
# Student Data Entry with MySQL

## Description
A simple CLI-based Java application to manage student data using MySQL and JDBC.

## Features
- Add Student
- View All Students
- View Student by PRN
- Update Student
- Delete Student

## Files
- `Student.java`: Model class
- `DBConnection.java`: Establishes database connection
- `StudentDAO.java`: Performs CRUD operations
- `StudentApp.java`: Main user interface

## Setup
1. Create a MySQL database: `student_db`
2. Create `students` table:
```sql
CREATE TABLE students (
    prn VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    batch VARCHAR(50)
);
