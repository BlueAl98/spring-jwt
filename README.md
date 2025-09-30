# 🛡️ Spring Boot JWT Authentication BaseProyect

A robust and secure boilerplate project demonstrating **JSON Web Token (JWT)** based authentication and authorization using **Spring Boot** and **Spring Security** with kotlin.
This repository provides a clear, production-ready foundation for securing your RESTful APIs.

***

## 🌟 Features

* **Token-Based Authentication:** Full implementation of **JWT** for stateless authentication.
* **Role-Based Authorization:** Secure endpoints based on user roles (e.g., `ROLE_USER`, `ROLE_ADMIN`).
* **Sign Up & Sign In:** Dedicated API endpoints for user registration and login.
* **Custom JWT Filter:** A filter to validate tokens for every secured request.
* **Password Encoding:** Uses **BCrypt** for secure password storage.
* **Clean Architecture:** Separation of concerns (Controllers, Services, Repositories, Security).

***

## 🛠️ Tech Stack

| Technology | Description |
| :--- | :--- |
| **Framework** | Spring Boot 3+ |
| **Security** | Spring Security 6+ |
| **Auth Mechanism**| JSON Web Token (JWT) |
| **Build Tool** |  Gradle kotlin |
| **Database** | H2 (default in-memory) / PostgreSQL / MySQL |
| **Java** | Java 17+ |

***

## 🚀 Getting Started

Follow these steps to set up and run the project locally.

### Prerequisites

Ensure you have the following installed on your machine:

* **Java Development Kit (JDK) 17 or newer**
* **Maven** (or Gradle if the project uses it)
* **Git**

### Installation and Setup

1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/BlueAl98/spring-jwt.git](https://github.com/BlueAl98/spring-jwt.git)
    cd spring-jwt
    ```

2.  **Configure Application (Optional):**
    For persistence, configure your database in `src/main/resources/application.properties` (or `.yml`). By default, it uses an in-memory **H2 database**.

    ```properties
    # Example: Customizing JWT Secret and Expiration
    jwt.secret=YourSuperSecretKeyThatIsAtLeast256BitsLong
    jwt.expiration.ms=86400000 # 24 hours
    ```

3.  **Build the Project:**
    Use your preferred build tool.

    * **With Maven:**
        ```bash
        ./mvnw clean install
        ```
    * **With Gradle (if applicable):**
        ```bash
        ./gradlew build
        ```

4.  **Run the Application:**

    * **Using the built JAR file:**
        ```bash
        java -jar target/spring-jwt-0.0.1-SNAPSHOT.jar
        ```
    * **Directly via Maven:**
        ```bash
        ./mvnw spring-boot:run
        ```

The application will be running on `http://localhost:8080`.

***

## 🔗 API Endpoints

All endpoints are prefixed with `/api`.

| Category | HTTP Method | Endpoint | Description | Access |
| :--- | :--- | :--- | :--- | :--- |
| **Authentication** | `POST` | `/api/auth/signup` | Register a new user. | Public |
| **Authentication** | `POST` | `/api/auth/signin` | Authenticate and receive a JWT. | Public |
| **Testing** | `GET` | `/api/test/public` | Accessible to all users (public). | Public |
| **Testing** | `GET` | `/api/test/user` | Requires a valid JWT (any role). | Authenticated |
| **Testing** | `GET` | `/api/test/admin` | Requires `ROLE_ADMIN` role. | Admin Only |

### Example: Sign In Request

To get a token, send a POST request:

```http
POST /api/auth/signin
Content-Type: application/json

{
    "username": "testuser",
    "password": "password123"
}
