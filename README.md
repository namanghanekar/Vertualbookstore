📘 Virtual Bookstore – Spring Boot (JWT Secured)
🚀 Project Overview

Virtual Bookstore is a secure RESTful web application built using Spring Boot, Spring Security (JWT), and MySQL.
It simulates a real-world online bookstore where users can:

Register & Login

Browse Books

Add Books to Cart

Role-based Access Control (Admin/User)

Secure APIs using JWT Authentication

This project follows industry-standard architecture and clean code principles.

🛠️ Tech Stack
Layer	Technology
Backend	Spring Boot 4
Security	Spring Security + JWT
Database	MySQL
ORM	Spring Data JPA (Hibernate)
Build Tool	Maven
Validation	Hibernate Validator
Logging	SLF4J + Logback
API Testing	Postman
🔐 Authentication & Authorization

JWT-based stateless authentication

Password encrypted using BCrypt

Role-based access control:

ROLE_USER

ROLE_ADMIN

🔑 Auth Flow
Register → Save User (No Token Generated)
Login → JWT Generated
Client stores token
Protected APIs require:
Authorization: Bearer <token>

📦 Features
👤 User Module

Register User

Login User (JWT Generated)

Password Encryption

Duplicate Email Validation

📚 Book Module

Add Book (Admin Only)

View All Books (Public)

Update / Delete Book (Admin Only)

🛒 Cart Module

Add Book to Cart (Authenticated User)

Increase Quantity if already exists

# Order place
after the payment

# payment 
succsess

👨‍💻 Author

Naman Ghanekar

Backend Developer (Spring Boot | JWT | REST APIs | MySQL)

⭐ If you like this project

Give it a ⭐ on GitHub!
