<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css?v=3">

<header>
    <div class="container">
        <h1>Personal Portfolio</h1>

        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/about">About</a></li>
                <li><a href="${pageContext.request.contextPath}/skills">Skills</a></li>
                <li><a href="${pageContext.request.contextPath}/projects">Projects</a></li>
                <li><a href="${pageContext.request.contextPath}/education">Education</a></li>
                <li><a href="${pageContext.request.contextPath}/contact">Contact</a></li>
                <li><a href="${pageContext.request.contextPath}/login.jsp">Admin</a></li>
            </ul>
        </nav>

        <button
            id="theme-button"
            class="theme-toggle"
            onclick="toggleTheme()">
            Dark Mode
        </button>
    </div>
</header>
