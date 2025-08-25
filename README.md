# Job Application Tracker API

A RESTful API built with Spring Boot to simulate the backend for a job application tracking system. This project was developed to practice and solidify core Spring Boot concepts, including REST API design, data persistence, and application architecture.

## 🚀 Tech Stack

- **Framework:** Spring Boot 3.x
- **Language:** Java 17
- **Build Tool:** Maven
- **Database:** H2 Database (Embedded)
- **Persistence:** Spring Data JPA
- **Test:** Postman

## ✨ Features

- **CRUD Operations:** Full Create, Read, Update, and Delete functionality for job applications
- **Status Tracking:** Update and track application status (e.g., `APPLIED`, `INTERVIEW`, `REJECTED`, `OFFER_ACCEPTED`)
- **Embedded Database:** H2 in-memory database for easy testing
- **RESTful Design:** Clean endpoint structure following REST conventions

## 📌 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/applications` | Get all job applications |
| `GET` | `/api/applications/{id}` | Get application by ID |
| ``POST`` | `/api/applications` | Create new application |
| `PUT` | `/api/applications/{id}` | Update application |
| `DELETE` | `/api/applications/{id}` | Delete application |


## 🔨 Installation & Setup

**Prerequisites**
*Java (>= 17)
*Maven (>= 3.6.3) 

**Running the application**

1.Clone and navigate to project:
  - git clone https://github.com/Eo9ine/job-application-api.git
  - cd job-application-api

2.Run with Maven:
  - ./mvnw spring-boot:run

## 🌐 Access Point


