<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>

<main>

    <section class="card grid-2">
        <div>
            <h2 class="section-title">Welcome to My Portfolio</h2>

            <p>
                Hi! I'm a passionate developer building dynamic websites
                with Java, JSP, Servlets, and MySQL.
            </p>

            <p>
                This portfolio demonstrates responsive design,
                secure authentication, and database-driven content rendering.
            </p>
        </div>

        
    </section>

    <section class="card">
        <h2 class="section-title">Featured Projects</h2>

        <c:choose>
            <c:when test="${not empty projects}">
                <ul class="project-list">
                    <c:forEach items="${projects}" var="project">
                        <li class="project-item">
                            <h3>
                                <c:out value="${project.title}" />
                                <span>(<c:out value="${project.year}" />)</span>
                            </h3>

                            <p>
                                <c:out value="${project.description}" />
                            </p>
                        </li>
                    </c:forEach>
                </ul>
            </c:when>

            <c:otherwise>
                <p>No projects available.</p>
            </c:otherwise>
        </c:choose>

    </section>

</main>

<%@ include file="footer.jsp" %>
