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
📂 Project Structure
com.example.vertualbookstore
│
├── config
│   └── JwtUtil.java
│
├── controller
│   ├── AuthController.java
│   ├── BookController.java
│   └── CartController.java
│
├── service
│   ├── AuthService.java
│   ├── AuthServiceImpl.java
│   ├── BookService.java
│   └── CartService.java
│
├── repository
│   ├── UserRepository.java
│   ├── BookRepository.java
│   └── CartRepository.java
│
├── entity
│   ├── User.java
│   ├── Book.java
│   ├── CartItem.java
│   └── Role.java
│
├── dto
│   ├── RegisterRequest.java
│   ├── LoginRequest.java
│   ├── AuthResponse.java
│   ├── RegisterResponse.java
│   └── CartRequestDto.java
│
├── exception
│   ├── GlobalExceptionHandler.java
│   └── Custom Exceptions
│
└── constant
    └── MessageConstants.java
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

View User Cart

🧪 API Endpoints
🔹 Auth APIs
Register
POST /api/auth/register

Response:

{
  "message": "User Registered Successfully"
}
Login
POST /api/auth/login

Response:

{
  "token": "eyJhbGciOiJIUzI1NiIs...",
  "message": "Login Successful"
}
🔹 Book APIs
Method	Endpoint	Access
GET	/api/books	Public
POST	/api/books	Admin
PUT	/api/books/{id}	Admin
DELETE	/api/books/{id}	Admin
🔹 Cart APIs
Method	Endpoint	Access
POST	/api/cart	Authenticated
GET	/api/cart	Authenticated

Header Required:

Authorization: Bearer <JWT_TOKEN>
🗄️ Database Configuration

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/virtual_bookstore
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
▶️ How To Run

Clone Repository

git clone https://github.com/yourusername/virtual-bookstore.git

Open in IntelliJ / Eclipse

Configure MySQL

Run Application

mvn spring-boot:run

Test APIs using Postman

🧠 Industry Standards Followed

DTO Pattern (No Entity Exposure)

Global Exception Handling (@RestControllerAdvice)

Clean Architecture (Controller → Service → Repository)

Logger instead of System.out

Validation Annotations (@Valid, @NotNull)

No Hardcoded Messages (Constants Used)

Proper HTTP Status Codes

JWT Stateless Security

Role-Based Access Control

📌 Future Enhancements

Payment Gateway Integration (Stripe / Razorpay)

Order Management Module

Recommendation System

Pagination & Sorting

Refresh Token Implementation

Swagger API Documentation

Unit Testing (JUnit + Mockito)

Docker Deployment

👨‍💻 Author

Naman Ghanekar

Backend Developer (Spring Boot | JWT | REST APIs | MySQL)

⭐ If you like this project

Give it a ⭐ on GitHub!
