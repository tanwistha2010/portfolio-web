---

# 🚀 Portfolio Web Application

A **dynamic full-stack portfolio website** built using **Java, JSP, Servlets, JDBC, MySQL, HTML, CSS, and JavaScript**.

Unlike static portfolio sites, this application stores and retrieves data dynamically from a **MySQL database**, allowing real-time updates without modifying source code.

---

## 📌 Project Overview

This project is a **database-driven portfolio system** where all content is managed dynamically.

### ✨ Key Features

* 🏠 Home Page
* 👤 About Section (Dynamic)
* 🛠️ Skills Section (Database-driven)
* 📂 Projects Section (Dynamic CRUD)
* 🎓 Education Section
* 📩 Contact Form (Stores messages in DB)
* 🔐 User Registration & Login
* 📊 Admin Dashboard
* ✏️ Add / Update Portfolio Content
* ☁️ Railway Deployment with Online MySQL
* 🐳 Dockerized Deployment

---

## 🧰 Tech Stack

### 🎨 Frontend

* HTML
* CSS
* JavaScript
* JSP

### ⚙️ Backend

* Java
* Servlets
* JDBC

### 🗄️ Database

* MySQL

### 📦 Build Tool

* Maven

### 🌐 Server

* Apache Tomcat 9

### 🚀 Deployment

* Railway
* Docker
* Railway MySQL

---

## 🧩 Application Modules

### 🏠 1. Home Page

* Displays introduction
* Navigation to all sections

---

### 👤 2. About Section

Dynamic personal info from database:

* Name
* Title
* Description

**Example:**

> Tanwistha Guha
> Engineering student passionate about web development, databases, drawing, and music.

---

### 📂 3. Projects Section

Each project includes:

* Title
* Description
* Technology stack
* Link
* Year

**Example:**

* **Heart Disease Predictor using AIML**
* Tech: Python
* Year: 2026

---

### 🛠️ 4. Skills Section

Each skill contains:

* Skill name
* Skill level

**Example:**

* Java – Intermediate
* HTML – Advanced
* CSS – Intermediate
* MySQL – Beginner

---

### 🎓 5. Education Section

Each record contains:

* Degree
* Institution
* Year
* Description

---

### 📩 6. Contact Form

Collects:

* Name
* Email
* Message

➡️ Stored in `messages` table

---

### 🔐 7. Authentication System

#### Register

* Name
* Email
* Password (hashed using utility class)

#### Login

* Email
* Password
* Session handling implemented

---

### 📊 8. Dashboard

Accessible after login:

* Manage Projects
* Manage Skills
* Manage Education

---

## 📁 Full Project Structure

```id="proj001"
portfolio-web/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/portfolio/
│       │       ├── servlet/
│       │       │   ├── LoginServlet.java
│       │       │   ├── RegisterServlet.java
│       │       │   ├── LogoutServlet.java
│       │       │   ├── DashboardServlet.java
│       │       │   ├── ProjectServlet.java
│       │       │   ├── SkillServlet.java
│       │       │   ├── ContactServlet.java
│       │       │   └── PublicServlet.java
│       │       │
│       │       └── util/
│       │           ├── DBConnection.java
│       │           ├── PortfolioDAO.java
│       │           └── HashUtil.java
│       │
│       └── webapp/
│           ├── index.jsp
│           ├── login.jsp
│           ├── register.jsp
│           ├── dashboard.jsp
│           ├── projects.jsp
│           ├── education.jsp
│           ├── projectform.jsp
│           ├── skillform.jsp
│           ├── header.jsp
│           ├── footer.jsp
│           └── assets/
│               ├── css/styles.css
│               └── js/scripts.js
│
├── pom.xml
├── Dockerfile
└── README.md
```

---

## 🗃️ Database Schema

### Users

```sql id="sql001"
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password_hash VARCHAR(255)
);
```

### About

```sql id="sql002"
CREATE TABLE about (
    id INT PRIMARY KEY,
    title VARCHAR(200),
    description TEXT
);
```

### Skills

```sql id="sql003"
CREATE TABLE skills (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    level VARCHAR(50)
);
```

### Projects

```sql id="sql004"
CREATE TABLE projects (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200),
    description TEXT,
    tech VARCHAR(200),
    link VARCHAR(200),
    year VARCHAR(10)
);
```

### Education

```sql id="sql005"
CREATE TABLE education (
    id INT AUTO_INCREMENT PRIMARY KEY,
    degree VARCHAR(200),
    institution VARCHAR(200),
    year VARCHAR(50),
    description TEXT
);
```

### Messages

```sql id="sql006"
CREATE TABLE messages (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    message TEXT
);
```

---

## 🧪 Sample Data

### About

```sql id="sample001"
INSERT INTO about VALUES (
1,
'Tanwistha Guha',
'I am an engineering student passionate about learning and building skills in HTML, CSS, and database systems...'
);
```

### Project

```sql id="sample002"
INSERT INTO projects (title, description, tech, link, year)
VALUES (
'Heart Disease Predictor using AIML',
'AIML Concepts',
'Python and its libraries',
'',
'2026'
);
```

### Education

```sql id="sample003"
INSERT INTO education (degree, institution, year, description)
VALUES (
'B.Tech in Computer Science and Engineering',
'Your College Name',
'2026',
'Engineering student learning web development and databases.'
);
```

---

## ⚙️ Local Setup Guide

### 1️⃣ Clone Repository

```bash id="setup001"
git clone https://github.com/tanwistha2010/portfolio-web.git
cd portfolio-web
```

---

### 2️⃣ Setup Database

```sql id="setup002"
CREATE DATABASE portfolio_db;
USE portfolio_db;
```

---

### 3️⃣ Configure DBConnection.java

```java id="setup003"
private static final String URL =
"jdbc:mysql://localhost:3306/portfolio_db?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

private static final String USER = "root";
private static final String PASSWORD = "Tanwistha";
```

---

### 4️⃣ Build Project

```bash id="setup004"
mvn clean package
```

---

### 5️⃣ Run on Tomcat

* Copy WAR file:

```id="setup005"
target/portfolio-web.war
```

* Paste into:

```id="setup006"
apache-tomcat/webapps/
```

* Run:

```id="setup007"
http://localhost:8081/portfolio-web/
```

---

## ☁️ Railway Deployment (Detailed)

### Step 1: Push to GitHub

```bash id="rail001"
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin https://github.com/tanwistha2010/portfolio-web.git
git push -u origin main
```

---

### Step 2: Create Railway Project

* Login to Railway
* Click **New Project**
* Deploy from GitHub

---

### Step 3: Add MySQL Service

Railway generates:

* MYSQL_URL
* MYSQLHOST
* MYSQLPORT
* MYSQLUSER
* MYSQLPASSWORD
* MYSQLDATABASE

---

### Step 4: Add Environment Variable

```id="rail002"
DATABASE_URL = ${{MySQL.MYSQL_URL}}
```

---

### Step 5: Railway DBConnection.java

```java id="rail003"
String dbUrl = System.getenv("DATABASE_URL");
dbUrl = dbUrl.replace("mysql://", "jdbc:mysql://");
```

---

### Step 6: Dockerfile

```dockerfile id="rail004"
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM tomcat:9.0-jdk17-temurin
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=build /app/target/portfolio-web.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
```

---

### Step 7: Generate Public Domain

* Railway → Settings → Networking → Generate Domain

---

## 🌍 Important URLs

* 🔗 Live: [https://portfolio-web-production-4110.up.railway.app/](https://portfolio-web-production-4110.up.railway.app/)
* 💻 Local: [http://localhost:8081/portfolio-web/](http://localhost:8081/portfolio-web/)

### Direct Pages

* `/login.jsp`
* `/register.jsp`
* `/projects.jsp`
* `/education.jsp`

---

## ⚠️ Common Errors & Fixes

| Error                | Solution                           |
| -------------------- | ---------------------------------- |
| Public key retrieval | Add `allowPublicKeyRetrieval=true` |
| Access denied        | Check DB credentials               |
| Unknown DB           | Create database                    |
| DATABASE_URL missing | Add env variable                   |
| mysql:// error       | Convert to `jdbc:mysql://`         |
| HTTP 502             | Check logs & DB                    |
| HTTP 404             | Check JSP paths                    |

---

## 🔮 Future Improvements

* Admin edit/delete UI
* Profile image upload
* Better UI/UX
* Responsive design
* REST APIs
* Spring Boot migration
* Secure authentication
* Custom domain

---

## 👩‍💻 Author

**Tanwistha Guha**

---

## 📌 Project Status

✅ Fully functional
✅ Dynamic database integration
✅ Deployed on Railway
✅ Dockerized
✅ Supports CRUD operations

