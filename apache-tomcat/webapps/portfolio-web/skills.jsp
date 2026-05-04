<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<main>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css?v=3">
<script src="${pageContext.request.contextPath}/js/script.js"></script>

    <section class="card">
        <h2 class="section-title">Skills</h2>
        <ul class="skill-list">
            <c:forEach items="${skills}" var="skill">
                <li class="skill-item">
                    <strong><c:out value="${skill.name}"/></strong>
                    <p>Level: <c:out value="${skill.level}"/></p>
                </li>
            </c:forEach>
        </ul>
    </section>
</main>
<%@ include file="footer.jsp" %>
