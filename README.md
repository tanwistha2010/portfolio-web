# Dynamic Personal Portfolio Website

This project is a dynamic portfolio website built with JSP, Servlets, JDBC, and MySQL.

## Features
- Responsive public portfolio pages: Home, About, Skills, Projects, Education, Contact
- Client-side validation for contact form
- Dark/Light theme toggle saved in browser storage
- MySQL database design with tables for users, about, skills, projects, education, and messages
- JDBC connectivity using `PreparedStatement`
- Register, login, and logout with session-based authentication
- Admin dashboard with CRUD for Projects and Skills
- Dynamic portfolio rendering using JSP and servlet-supplied data
- Password hashing with SHA-256 and output escaping for basic security

## Setup
1. Install JDK 8 or later and Maven.
2. Install MySQL and create the database by running `portfolio_db.sql`.
   - Default connection is configured in `src/main/webapp/WEB-INF/web.xml`.
   - Adjust `jdbc.url`, `jdbc.user`, and `jdbc.password` to match your MySQL settings.
3. Import or open this folder as a Maven project.
4. Build the WAR with:
   ```bash
   mvn clean package
   ```
5. Deploy the generated `target/portfolio-web.war` to a servlet container such as Apache Tomcat.
6. Access the site at `http://localhost:8080/portfolio-web`.

## Admin Login
- Email: `admin@example.com`
- Password: `password123`

## Database Notes
- `portfolio_db.sql` includes table creation and sample records.
- The `messages` table stores incoming contact form submissions.

## Files of Interest
- `src/main/java/com/portfolio/util/DBConnection.java`
- `src/main/java/com/portfolio/util/PortfolioDAO.java`
- `src/main/java/com/portfolio/servlet/RegisterServlet.java`
- `src/main/java/com/portfolio/servlet/LoginServlet.java`
- `src/main/java/com/portfolio/servlet/LogoutServlet.java`
- `src/main/java/com/portfolio/servlet/DashboardServlet.java`
- `src/main/webapp/*.jsp`
- `src/main/webapp/assets/css/styles.css`
- `src/main/webapp/assets/js/scripts.js`

## Notes
- For production deployment, update database credentials and enable HTTPS.
- If you want to change the admin password, update the hash in the `users` table with a new SHA-256 value.
