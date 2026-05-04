-- Create portfolio database and tables
CREATE DATABASE IF NOT EXISTS portfolio_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE portfolio_db;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS about (
    id INT PRIMARY KEY,
    title VARCHAR(150),
    description TEXT,
    profile_image VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS skills (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    level VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS projects (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    description TEXT NOT NULL,
    tech VARCHAR(100),
    link VARCHAR(255),
    year VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS education (
    id INT AUTO_INCREMENT PRIMARY KEY,
    degree VARCHAR(150) NOT NULL,
    institution VARCHAR(150) NOT NULL,
    year VARCHAR(20) NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS messages (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    message TEXT NOT NULL,
    sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Sample records
INSERT INTO about (id, title, description, profile_image) VALUES
(1, 'Web Developer', 'I build dynamic, responsive portfolio websites using JSP, Servlets, HTML, CSS, JavaScript, and MySQL.', 'https://via.placeholder.com/320x320.png?text=Profile');

INSERT INTO skills (name, level) VALUES
('Java', 'Advanced'),
('HTML & CSS', 'Advanced'),
('JavaScript', 'Intermediate'),
('MySQL', 'Intermediate');

INSERT INTO projects (title, description, tech, link, year) VALUES
('Portfolio Website', 'A dynamic personal portfolio website with login-protected admin dashboard.', 'Java, JSP, MySQL', 'https://example.com', '2026'),
('Task Tracker', 'A responsive task manager application with CRUD features.', 'JavaScript, HTML, CSS', 'https://example.com', '2025');

INSERT INTO education (degree, institution, year, description) VALUES
('Bachelor of Computer Science', 'Techno India University', '2023', 'Studied web development, database systems, and software engineering.');

INSERT INTO users (name, email, password_hash) VALUES
('Admin User', 'admin@example.com', 'ef92b778bae2f3bc6a8f7d78d7e0d4c2d49e44a50198895b1fcd5dcf1f4fb88b');
