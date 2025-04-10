# 🎬 MovieApp Backend

This is the backend service for the MovieApp, a movie management and browsing platform. It provides RESTful APIs for authentication, movie listing, and admin operations. The backend is built using **Spring Boot** and uses **MySQL** as the database.

---

## 🚀 API Endpoints

| Method | Endpoint                         | Description                          |
|--------|----------------------------------|--------------------------------------|
| POST   | `/auth/register`                | Register a new user                  |
| POST   | `/auth/login`                   | Authenticate and return JWT token    |
| GET    | `/movies/`                      | Get all movies                       |
| GET    | `/movies/{id}`                  | Get details of a single movie by ID  |
| POST   | `/movies/add`                   | Add a new movie (admin only)         |
| DELETE | `/movies/delete/{id}`          | Delete a movie by ID (admin only)    |

> 📌 All secured endpoints require a valid JWT token.

---

## 🗃️ Database

- **Type**: MySQL
- **Default Port**: `3306`
- **Schema Name**: `movie_app` (or as defined in `application.properties`)
- **Tables**:
  - `users`
  - `movies`

Ensure MySQL is running and the schema is created before starting the application.

---

## ⚙️ Tech Stack

- Java 8+
- Spring Boot
- Spring Security (JWT Auth)
- Spring Data JPA
- MySQL

---

## 🛠️ Setup Instructions

1. **Clone the project**

   ```bash
   git clone <your-repo-url>
   cd MovieApp
## Test in Postman

Use the following base URL:
http://localhost:8083/auth/register
 http://localhost:8083/auth/login
 http://localhost:8083/movies/ 
http://localhost:8083/movies/add 
http://localhost:8083/movies/delete/{id}
 http://localhost:8083/movies/{id} 
