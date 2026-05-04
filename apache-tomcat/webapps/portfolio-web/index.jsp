<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portfolio Website</title>

    <link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>

<header>
    <div class="container">
        <h1>My Portfolio</h1>

        <nav>
            <ul>
                <li><a href="#home">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#skills">Skills</a></li>
                <li><a href="#projects">Projects</a></li>
                <li><a href="#education">Education</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </nav>

        <button id="theme-button" onclick="toggleTheme()">🌙 Dark Mode</button>
    </div>
</header>

<main>

<section id="home">
    <div class="card">
        <h2>Welcome</h2>
        <p>Dynamic Portfolio Website using JSP + Servlets + MySQL</p>
    </div>
</section>

</main>

<script src="assets/js/scripts.js"></script>
</body>
</html>
