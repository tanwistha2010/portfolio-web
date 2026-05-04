<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Skill Form</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css?v=3">
</head>
<body>
<main>
    <section class="card" style="max-width: 600px; margin: 2rem auto;">
        <h2 class="section-title"><c:choose><c:when test="${not empty skill}">Edit Skill</c:when><c:otherwise>Add Skill</c:otherwise></c:choose></h2>
        <c:if test="${not empty error}">
            <div class="alert error"><c:out value="${error}"/></div>
        </c:if>
        <form action="${pageContext.request.contextPath}/skill" method="post">
            <c:choose>
                <c:when test="${not empty skill}">
                    <input type="hidden" name="action" value="edit" />
                    <input type="hidden" name="id" value="${skill.id}"/>
                </c:when>
                <c:otherwise>
                    <input type="hidden" name="action" value="add" />
                </c:otherwise>
            </c:choose>
            <label for="name">Skill Name</label>
            <input id="name" name="name" type="text" value="${skill.name}" required>
            <label for="level">Level</label>
            <input id="level" name="level" type="text" value="${skill.level}" required>
            <button type="submit">Save Skill</button>
        </form>
    </section>
</main>
<script src="${pageContext.request.contextPath}/assets/js/scripts.js"></script>
</body>
</html>
