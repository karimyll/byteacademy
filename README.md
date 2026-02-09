# Byte Academy

Byte Academy is a robust educational management platform designed to streamline operations for academies, schools, and training centers. The system provides a centralized backend for managing students, teachers, courses, enrollments, and certifications with a focus on security and scalability.

## 🚀 Technical Stack

- **Backend Framework**: Spring Boot 3.2.3
- **Security**: Spring Security with JWT (JSON Web Token) for stateless authentication.
- **Database**: PostgreSQL with Spring Data JPA.
- **Object Mapping**: MapStruct for efficient DTO-to-Entity conversions.
- **API Documentation**: Swagger/OpenAPI 3 for interactive API exploration.
- **Build Tool**: Gradle.
- **Utilities**: Lombok (to reduce boilerplate), Jakarta Validation (for data integrity).

## 🛠 Functional Modules

### 1. Authentication & Security

- **Role-Based Access Control (RBAC)**: Supports ADMIN, STAFF, TEACHER, and STUDENT roles.
- **JWT Integration**: Secure login and token-based request authorization.
- **User Management**: Ability to enable/disable users and manage roles across different entities (Staff, Teachers, Students).

### 2. Academic Management

- **Course Catalog**: Manage course details including titles, slugs, duration, and formats (Online/In-person).
- **Staff & Faculty**: Detailed profiles for staff members and teachers, including job descriptions and "About" sections.
- **Student Information System**: Comprehensive student records including personal data and academic history.

### 3. Lifecycle Management

- **Applications**: A public-facing module for potential students to apply for courses.
- **Groups**: Organize students into numbered cohorts.
- **Enrollments**: Connect students, teachers, and courses into specific timeframes.
- **Certificates**: Generate and verify academic certificates using unique verification numbers.

## 📡 API Overview

The platform exposes a RESTful API organized by version (`/api/v1/`). Key endpoints include:

### Category

| **Category**     | **Endpoint**             | **Primary Roles**                       |
|------------------|--------------------------|-----------------------------------------|
| **Auth**         | `/api/v1/auth/login`      | Public                                  |
| **Courses**      | `/api/v1/courses`         | Public (Read) / Staff (Write)           |
| **Students**     | `/api/v1/students`        | Staff / Admin                           |
| **Teachers**     | `/api/v1/teachers`        | Public (Read) / Staff (Write)           |
| **Enrollments**  | `/api/v1/enrollments`     | Staff / Admin                           |
| **Applications** | `/api/v1/applications`    | Public (Create) / Staff (Manage)        |
| **Certificates** | `/api/v1/certificates`    | Public (Verify) / Staff (Issue)         |
