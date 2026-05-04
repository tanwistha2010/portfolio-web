<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>

<main>

    <section class="card">
        <h2 class="section-title">Admin Dashboard</h2>

        <c:if test="${not empty sessionScope.userName}">
            <p>
                Welcome back,
                <strong><c:out value="${sessionScope.userName}"/></strong>!
            </p>
        </c:if>

        <div class="dashboard-actions">
            <a class="action-btn" href="${pageContext.request.contextPath}/project?action=add">
                Add Project  <br>
            </a>

            <a class="action-btn" href="${pageContext.request.contextPath}/skill?action=add">
                Add Skill <br>
            </a> 

            <a class="action-btn logout-btn" href="${pageContext.request.contextPath}/logout">
                Logout
            </a>
        </div>
    </section>

    <!-- PROJECT SECTION -->
    <section class="card">
        <h3 class="section-title">Manage Projects</h3>

        <c:choose>
            <c:when test="${not empty projects}">
                <ul class="project-list">
                    <c:forEach items="${projects}" var="project">
                        <li class="project-item">
                            <h4><c:out value="${project.title}"/></h4>

                            <p>
                                <c:out value="${project.description}"/>
                            </p>

                            <div class="item-actions">
                                <a href="${pageContext.request.contextPath}/project?action=edit&id=${project.id}">
                                    Edit
                                </a>

                                <a href="${pageContext.request.contextPath}/project?action=delete&id=${project.id}"
                                   onclick="return confirm('Delete this project?');">
                                    Delete
                                </a>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </c:when>

            <c:otherwise>
                <p>No projects found.</p>
            </c:otherwise>
        </c:choose>
    </section>

    <!-- SKILL SECTION -->
    <section class="card">
        <h3 class="section-title">Manage Skills</h3>

        <c:choose>
            <c:when test="${not empty skills}">
                <ul class="skill-list">
                    <c:forEach items="${skills}" var="skill">
                        <li class="skill-item">
                            <h4><c:out value="${skill.name}"/></h4>

                            <p>
                                Level:
                                <strong><c:out value="${skill.level}"/></strong>
                            </p>

                            <div class="item-actions">
                                <a href="${pageContext.request.contextPath}/skill?action=edit&id=${skill.id}">
                                    Edit
                                </a>

                                <a href="${pageContext.request.contextPath}/skill?action=delete&id=${skill.id}"
                                   onclick="return confirm('Delete this skill?');">
                                    Delete
                                </a>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </c:when>

            <c:otherwise>
                <p>No skills found.</p>
            </c:otherwise>
        </c:choose>
    </section>

</main>

<%@ include file="footer.jsp" %>
