<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<main>
    <section class="card" style="max-width: 480px; margin: 3rem auto;">
        <h2 class="section-title">Register</h2>
        <c:if test="${not empty error}">
            <div class="alert error"><c:out value="${error}"/></div>
        </c:if>
        <form action="${pageContext.request.contextPath}/register" method="post">
            <label for="name">Name</label>
            <input id="name" name="name" type="text" required>
            <label for="email">Email</label>
            <input id="email" name="email" type="email" required>
            <label for="password">Password</label>
            <input id="password" name="password" type="password" required>
            <button type="submit">Register</button>
        </form>
        <p>Already registered? <a href="${pageContext.request.contextPath}/login.jsp">Login</a></p>
    </section>
</main>
<script src="${pageContext.request.contextPath}/assets/js/scripts.js"></script>
</body>
</html>
