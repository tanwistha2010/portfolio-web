<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project Form</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css?v=3">
</head>

<body>

<main>
    <section class="card" style="max-width: 700px; margin: 2rem auto;">

        <!-- Title -->
        <h2 class="section-title">
            <c:choose>
                <c:when test="${not empty project}">
                    Edit Project
                </c:when>
                <c:otherwise>
                    Add Project
                </c:otherwise>
            </c:choose>
        </h2>

        <!-- Error Message -->
        <c:if test="${not empty error}">
            <div class="alert error">
                <c:out value="${error}" />
            </div>
        </c:if>

        <!-- FORM -->
        <form action="${pageContext.request.contextPath}/project" method="post">

            <!-- ADD / EDIT MODE -->
            <c:choose>
                <c:when test="${not empty project}">
                    <input type="hidden" name="action" value="edit" />
                    <input type="hidden" name="id" value="${project.id}" />
                </c:when>
                <c:otherwise>
                    <input type="hidden" name="action" value="add" />
                </c:otherwise>
            </c:choose>

            <!-- TITLE -->
            <label for="title">Title</label>
            <input id="title"
                   name="title"
                   type="text"
                   required
                   placeholder="Enter project title"
                   value="${not empty project ? project.title : ''}" />

            <!-- DESCRIPTION -->
            <label for="description">Description</label>
            <textarea id="description"
                      name="description"
                      rows="5"
                      required
                      placeholder="Enter project description">${not empty project ? project.description : ''}</textarea>

            <!-- TECHNOLOGY -->
            <label for="tech">Technology</label>
            <input id="tech"
                   name="tech"
                   type="text"
                   placeholder="e.g. Java, JSP, MySQL"
                   value="${not empty project ? project.tech : ''}" />

            <!-- LINK -->
            <label for="link">Project Link</label>
            <input id="link"
                   name="link"
                   type="url"
                   placeholder="https://github.com/..."
                   value="${not empty project ? project.link : ''}" />

            <!-- YEAR -->
            <label for="year">Year</label>
            <input id="year"
                   name="year"
                   type="number"
                   min="2000"
                   max="2100"
                   required
                   placeholder="2026"
                   value="${not empty project ? project.year : ''}" />

            <!-- BUTTON -->
            <button type="submit">
                Save Project
            </button>

        </form>

    </section>
</main>

<script src="${pageContext.request.contextPath}/assets/js/scripts.js"></script>

</body>
</html>
