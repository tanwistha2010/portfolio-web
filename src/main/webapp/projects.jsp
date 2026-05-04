<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>

<main>

    <section class="card">

        <h2 class="section-title">Projects</h2>

        <!-- EMPTY STATE HANDLING -->
        <c:if test="${empty projects}">
            <p>No projects found.</p>
        </c:if>

        <ul class="project-list">

            <c:forEach items="${projects}" var="project">

                <li class="project-item">

                    <h3>
                        <c:out value="${project.title}" />
                    </h3>

                    <p>
                        <c:out value="${project.description}" />
                    </p>

                    <p>
                        <strong>Technology:</strong>
                        <c:out value="${project.tech}" />
                    </p>

                    <p>
                        <strong>Year:</strong>
                        <c:out value="${project.year}" />
                    </p>

                    <!-- SAFE LINK HANDLING -->
                    <c:if test="${not empty project.link}">
                        <p>
                            <a href="${project.link}" target="_blank">
                                View Project
                            </a>
                        </p>
                    </c:if>

                </li>

            </c:forEach>

        </ul>

    </section>

</main>

<%@ include file="footer.jsp" %>
