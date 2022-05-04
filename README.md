# Revature Traning Project #1

 ## **Project Title : Automatic Exam Seating Arrangement**
**This is my foundational project on my revature training.**

This gives you the output only in console.

- This project consist with two types of login functionality (Admin and Student) which has 15 types of query implementation with 20 variations of function call to access the querry.

- Total of 9 modules within 7 pakages contains 1100+ lines of code.

### Technologies used :
-- Java  -- SQL -- RDBMS -- Maven -- JUnit

- **in MySQL server :**
-- Required databases (Student, LoginData)
-- Required Tables in Student (Studentdata, StudentSeating)
-- Required Tables in LoginData (AdminLogin, StudentLogin)

- **Packages :** ( has overall 9 modules )
-- main -- loginFiles -- adminFiles -- studentFiles -- redirectFiles -- reusableDataFunctions

### Tools used :
-- IntelliJ ( with Amazon Corretto 11 JDK, Maven Dependencies [ MySQL connector, JUnit ] )
-- MySQL Server
-- MySQL Work Bench

When executed it begins with main package and calls the modules available in the loginFiles, then the process moves to all different types of modules according to the user input the console. The redirectFiles and reusableDataFunctions are often called to implement any same method repeatedly and also for recurrsive call.
Implemented OOP concepts and dynamic updation to the queries for code reusablity and avoid error if any name need to be modified in future.

### Functionalities : ( Access will differ acccording to the login )
- Automatic Seating Arrangement (requires no. of available rooms, room numbers, benches in each room as a user input) **--Primary**
- C.R.U.D operations ( for all possible areas )
- Create new login ID
- View table
- View login activities
