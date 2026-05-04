<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>

<main>

    <section class="card">
        <h2 class="section-title">Education</h2>

        <c:choose>
            <c:when test="${not empty education}">
                <ul class="edu-list">
                    <c:forEach items="${education}" var="edu">
                        <li class="edu-item">
                            <h3>
                                <c:out value="${edu.degree}" />
                            </h3>

                            <p>
                                <strong>Institution:</strong>
                                <c:out value="${edu.institution}" />
                            </p>

                            <p>
                                <strong>Year:</strong>
                                <c:out value="${edu.year}" />
                            </p>

                            <p>
                                <c:out value="${edu.description}" />
                            </p>
                        </li>
                    </c:forEach>
                </ul>
            </c:when>

            <c:otherwise>
                <p>No education details found.</p>
            </c:otherwise>
        </c:choose>

    </section>

</main>

<%@ include file="footer.jsp" %>
