# Student Management System

## Description
The **Student Management System** is a console-based Java application that allows users to create, update, delete, retrieve, and manage student records efficiently. The application also supports reading student data from files and directories, sorting, and filtering records based on specified fields.

## Features
* Create a new student record
* Delete a student record by ID
* Update student details (name, age, email, grade)
* Retrieve a student's details by ID
* Read student data from a text file
* Read student records from a directory
* Display all student records
* Sort students based on different fields
* Filter students by grade or age
* Exit the application safely

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- A text editor or an Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse

## Installation
### 1. Clone the Repository
```sh
  git clone <https://github.com/Arun7333/Training_Java.git>
  cd src
  cd StudentManagementSystem
```

### 2. Compile the Project
```
Compile all the java files in that directory using javac
```

### 3. Run the Application
```sh
  java -cp "path for class files" StudentManagementSystem.main.Main
```

## Usage
Upon running the application, you will see a menu with available commands. Before performing operations, you need to specify the directory where student records will be stored.

### Menu Commands
- **Create a student**: `create`
- **Delete a student**: `delete`
- **Update student details**: `update`
- **Get a student by ID**: `get`
- **Read data from a text file**: `readFile`
- **Read data from a directory**: `readDir`
- **Show all students**: `showAll`
- **Sort students by a field**: `sort`
- **Filter students by grade or age**: `filter`
- **Exit the application**: `exit`

### Example Commands
#### Create a Student
```
Enter the command: create
Enter your Name: John Doe
Enter your Age: 22
Enter your Email: johndoe@example.com
Enter your Grade(A, B, C, D): A
~~Student successfully created~~
```

#### Retrieve a Student
```
Enter the command: get
Enter the id of the student to get: 1
Student{id=1, name='John Doe', age=22, email='johndoe@example.com', grade='A'}
```

#### Update a Student
```
Enter the command: update
Enter the id of the student to be updated: 1
Note ::: Syntax for update command is: (Field) (Value) e.g., "name Alice"
Enter your update command: name Alice
~~Name successfully changed~~
```

#### Delete a Student
```
Enter the command: delete
Enter the id of the student to be removed: 1
~~Student with id 1 is successfully deleted~~
```

#### Exit the Program
```
Enter the command: exit
Shutting down..........
```

## File Handling
The system allows reading from a text file or a directory containing multiple files with student data.

- **Read from a text file**: `readFile`
- **Read from a directory**: `readDir`


