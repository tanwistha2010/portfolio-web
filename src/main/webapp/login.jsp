<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<main>
    <section class="card" style="max-width: 480px; margin: 3rem auto;">
        <h2 class="section-title">Admin Login</h2>
        <c:if test="${not empty error}">
            <div class="alert error"><c:out value="${error}"/></div>
        </c:if>
        <c:if test="${not empty success}">
            <div class="alert success"><c:out value="${success}"/></div>
        </c:if>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <label for="email">Email</label>
            <input id="email" name="email" type="email" required>
            <label for="password">Password</label>
            <input id="password" name="password" type="password" required>
            <button type="submit">Login</button>
        </form>
        <p>Don't have an account? <a href="${pageContext.request.contextPath}/register.jsp">Register</a></p>
    </section>
</main>
<script src="${pageContext.request.contextPath}/assets/js/scripts.js"></script>
</body>
</html>
