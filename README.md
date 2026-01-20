# Student Information Management System (Console-Based Java Application)

## 📌 Project Overview
The Student Information Management System is a console-based Java application developed using Core Java, JDBC, MySQL, and Maven.
It allows users to perform CRUD (Create, Read, Update, Delete) operations on student records stored in a relational database.

This project follows clean code principles, layered architecture, and modern JDBC practices, making it suitable for academic evaluation and entry-level backend logic development.

## 🛠️ Technologies Used
- Language: Java (Core Java)
- Database: MySQL
- Database Access: JDBC (Modern – auto driver loading)
- Build Tool: Maven
- IDE: Eclipse IDE
- Architecture: DAO Pattern (Separation of Concerns)

## 📂 Project Structure
com.sarthak.app
├── main
│   └── App.java                 // Application entry point (menu-driven)
├── model
│   └── Student.java             // POJO / Entity class
├── dao
│   ├── StudentDao.java          // DAO interface
│   └── StudentDaoImpl.java      // JDBC implementation
├── jdbc
│   └── DBConnection.java        // Database connection utility
└── util (future scope)
    └── InputUtil.java           // Safe input handling

## 🗄️ Database Design

```sql
CREATE TABLE student (
  id SMALLINT UNSIGNED NOT NULL,
  name VARCHAR(45) NOT NULL,
  age INT DEFAULT NULL,
  email VARCHAR(45) DEFAULT NULL,
  course VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY (id)
);
```

## ⚙️ Features Implemented
- Add new student
- View all students
- View student by ID
- Update student details
- Delete student by ID
- Graceful handling of non-existing records

## ▶️ Application Flow
1. User interacts with a menu-driven console interface.
2. Input is captured in the main layer.
3. DAO layer handles database operations.
4. JDBC communicates with MySQL using PreparedStatements.
5. Results are displayed back to the user.

## 🔐 Database Connection Handling
Database connectivity is centralized in a DBConnection utility class using modern JDBC practices. 
The class prevents object creation by using a private constructor and exposes a static method to obtain database connections.

## 🧠 Key Concepts Demonstrated
- Core Java and OOP principles
- JDBC with PreparedStatements
- DAO design pattern
- Exception handling
- Utility classes
- Console-based application design
- MySQL constraints and validation

## 🚧 Limitations
- Console-based UI
- Database credentials currently hardcoded
- No connection pooling
- Basic input validation

## 🚀 Future Enhancements
- External configuration using properties file
- Service layer introduction
- Input validation utility
- Pagination for large datasets
- Logging framework integration
- Migration to Spring Boot
- Unit testing with JUnit

## 👨‍💻 Author
Sarthak Tambe  
Final Year – Electronics & Telecommunication Engineering  
Aspiring Java Backend Developer

## 📄 License
This project is developed for learning purposes.

