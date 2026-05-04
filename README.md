# Portfolio Web Application

A dynamic portfolio website built using Java, JSP, Servlets, JDBC, MySQL, HTML, CSS, and JavaScript.  
The project allows portfolio content such as projects, skills, education details, about information, login/register, and contact messages to be managed dynamically using a database.

## Project Overview

This is a full-stack Java web application developed as a dynamic portfolio system.  
Unlike a static portfolio website, this project stores data in a MySQL database and displays it dynamically on JSP pages.

The application includes:

- Home page
- About section
- Skills section
- Projects section
- Education section
- Contact form
- User registration
- User login
- Admin dashboard
- Add/update portfolio content
- Railway deployment with online MySQL database

---

## Technologies Used

### Frontend

- HTML
- CSS
- JavaScript
- JSP

### Backend

- Java
- Servlets
- JDBC

### Database

- MySQL

### Build Tool

- Maven

### Server

- Apache Tomcat 9

### Deployment

- Railway
- Docker
- Railway MySQL

---

## Main Functionalities

### 1. Home Page

The home page displays the main portfolio introduction and navigation links.

Users can visit different sections such as:

- Home
- About
- Skills
- Projects
- Education
- Contact

---

### 2. About Section

The about section displays personal information from the database.

Current information includes:

- Name
- Short description
- Personal introduction

Example:

```text
Tanwistha Guha
Engineering student passionate about learning HTML, CSS, database systems, drawing, and music.
3. Projects Section

The projects section displays projects stored in the database.

Each project contains:

Project title
Description
Technology stack
Project link
Year

Example project:

Heart Disease Predictor using AIML
Description: AIML Concepts
Technology: Python and its libraries
Year: 2026
4. Skills Section

The skills section displays technical skills from the database.

Each skill contains:

Skill name
Skill level

Example:

Java - Intermediate
HTML - Advanced
CSS - Intermediate
MySQL - Beginner
5. Education Section

The education section displays education details from the database.

Each education record contains:

Degree
Institution
Year
Description

Example:

B.Tech in Computer Science and Engineering
Institution: Your College Name
Year: 2026
Description: Engineering student learning web development, databases, JSP, Servlets, and MySQL.
6. Contact Form

The contact form allows visitors to submit a message.

The form collects:

Name
Email
Message

Submitted messages are saved in the messages table in MySQL.

7. Register Functionality

Users can register using:

Name
Email
Password

The password is hashed before being stored in the database.

The registration data is stored in the users table.

8. Login Functionality

Registered users can log in using:

Email
Password

After successful login, the user is redirected to the dashboard.

Session handling is used to keep the user logged in.

9. Dashboard

The dashboard allows managing portfolio content such as:

Projects
Skills
Education details

It is available after login.

Project Structure
portfolio-web/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── portfolio/
│       │           ├── servlet/
│       │           │   ├── LoginServlet.java
│       │           │   ├── RegisterServlet.java
│       │           │   ├── LogoutServlet.java
│       │           │   ├── DashboardServlet.java
│       │           │   ├── ProjectServlet.java
│       │           │   ├── SkillServlet.java
│       │           │   ├── ContactServlet.java
│       │           │   └── PublicServlet.java
│       │           │
│       │           └── util/
│       │               ├── DBConnection.java
│       │               ├── PortfolioDAO.java
│       │               └── HashUtil.java
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
│               ├── css/
│               │   └── styles.css
│               └── js/
│                   └── scripts.js
│
├── pom.xml
├── Dockerfile
└── README.md
Database Tables

The project uses the following MySQL tables:

users

Stores registered user details.

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password_hash VARCHAR(255)
);
about

Stores portfolio owner details.

CREATE TABLE about (
    id INT PRIMARY KEY,
    title VARCHAR(200),
    description TEXT
);
skills

Stores technical skills.

CREATE TABLE skills (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    level VARCHAR(50)
);
projects

Stores project details.

CREATE TABLE projects (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200),
    description TEXT,
    tech VARCHAR(200),
    link VARCHAR(200),
    year VARCHAR(10)
);
education

Stores education details.

CREATE TABLE education (
    id INT AUTO_INCREMENT PRIMARY KEY,
    degree VARCHAR(200),
    institution VARCHAR(200),
    year VARCHAR(50),
    description TEXT
);
messages

Stores contact form messages.

CREATE TABLE messages (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    message TEXT
);
Sample Database Data
About
INSERT INTO about VALUES (
1,
'Tanwistha Guha',
'I am an engineering student passionate about learning and building skills in HTML, CSS, and database systems. I enjoy coding, exploring new technologies, and improving through practice. Alongside my technical interests, I love to draw and listen to music, which keeps me creative, focused, and motivated.'
);
Project
INSERT INTO projects (title, description, tech, link, year)
VALUES (
'Heart Disease Predictor using AIML',
'AIML Concepts',
'Python and its libraries',
'',
'2026'
);
Education
INSERT INTO education (degree, institution, year, description)
VALUES (
'B.Tech in Computer Science and Engineering',
'Your College Name',
'2026',
'Engineering student learning HTML, CSS, database systems, JSP, Servlets and MySQL.'
);
Local Setup Instructions
Step 1: Clone the Repository
git clone https://github.com/tanwistha2010/portfolio-web.git
cd portfolio-web
Step 2: Open Project in VS Code

Open the folder in VS Code:

File → Open Folder → portfolio-web
Step 3: Configure MySQL Database

Create the local database:

CREATE DATABASE portfolio_db;
USE portfolio_db;

Then create all required tables.

Step 4: Configure DBConnection.java

For local setup, use:

private static final String URL =
    "jdbc:mysql://localhost:3306/portfolio_db?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

private static final String USER = "root";
private static final String PASSWORD = "Tanwistha";

For Railway deployment, environment variables are used instead.

Step 5: Build the Project

Run:

mvn clean package

This creates a WAR file inside:

target/portfolio-web.war
Step 6: Run Locally on Tomcat

Copy the WAR file:

target/portfolio-web.war

Paste it inside:

apache-tomcat/webapps/

Start Tomcat.

If Tomcat runs on port 8081, open:

http://localhost:8081/portfolio-web/
Railway Deployment Steps
Step 1: Push Project to GitHub
git init
git add .
git commit -m "Initial portfolio project"
git branch -M main
git remote add origin https://github.com/tanwistha2010/portfolio-web.git
git push -u origin main
Step 2: Create Railway Project
Open Railway
Login using GitHub
Click New Project
Select Deploy from GitHub Repo
Choose portfolio-web
Step 3: Add MySQL Service

In Railway:

Add Service → Database → MySQL

Railway generates database variables such as:

MYSQL_URL
MYSQLHOST
MYSQLPORT
MYSQLUSER
MYSQLPASSWORD
MYSQLDATABASE
Step 4: Add DATABASE_URL Variable

In Railway app service variables:

DATABASE_URL = ${{MySQL.MYSQL_URL}}

This allows Java to read the database URL using:

System.getenv("DATABASE_URL")
Step 5: DBConnection.java for Railway
package com.portfolio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String dbUrl = System.getenv("DATABASE_URL");

        if (dbUrl == null || dbUrl.isEmpty()) {
            throw new SQLException("DATABASE_URL environment variable is not set");
        }

        dbUrl = dbUrl.replace("mysql://", "jdbc:mysql://");

        String[] parts = dbUrl.split("@");

        String credentials = parts[0].replace("jdbc:mysql://", "");
        String hostPart = parts[1];

        String username = credentials.split(":")[0];
        String password = credentials.split(":")[1];

        String finalUrl = "jdbc:mysql://" + hostPart +
                "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        return DriverManager.getConnection(finalUrl, username, password);
    }
}
Step 6: Dockerfile

The project uses Docker to run Tomcat on Railway.

FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM tomcat:9.0-jdk17-temurin

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=build /app/target/portfolio-web.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]

Railway uses port 8080 internally inside Docker.

The local Tomcat port may be 8081, but Railway handles the public routing automatically.

Step 7: Generate Public Domain

In Railway:

Settings → Networking → Generate Domain

Live website:

https://portfolio-web-production-4110.up.railway.app/
Important URLs
Live Website
https://portfolio-web-production-4110.up.railway.app/
Local Website
http://localhost:8081/portfolio-web/
Direct JSP Pages
/login.jsp
/register.jsp
/education.jsp
/projects.jsp
Common Errors and Fixes
1. Public Key Retrieval is not allowed

Fix JDBC URL:

allowPublicKeyRetrieval=true
2. Access denied for user

This means MySQL username or password is incorrect.

Fix credentials in:

DBConnection.java

or Railway variables.

3. Unknown database

The database does not exist.

Create it using:

CREATE DATABASE portfolio_db;
4. DATABASE_URL environment variable is not set

Add this variable in Railway app service:

DATABASE_URL = ${{MySQL.MYSQL_URL}}
5. No suitable driver found for mysql://

Java JDBC needs:

jdbc:mysql://

not:

mysql://

The DBConnection class converts Railway’s URL automatically.

6. HTTP 502 on Railway

Possible reasons:

App crashed
Database not connected
Tables missing
Wrong environment variables
Tomcat not running

Check Railway logs.

7. HTTP 404

Possible reasons:

Wrong URL
JSP missing from src/main/webapp
Servlet mapping missing

Example:
/register.jsp
works only if register.jsp exists in src/main/webapp.
Future Improvements
Possible future upgrades:
Add admin edit/delete buttons
Add education form
Add profile image upload
Improve UI design
Add responsive project cards
Add custom domain
Add proper admin authentication
Convert project to Spring Boot
Add REST APIs
Add image upload support

Author
Tanwistha Guha

Project Status
The project is successfully:
Built using Maven
Connected to MySQL
Deployed using Railway
Running live online
Able to add projects and skills dynamically
