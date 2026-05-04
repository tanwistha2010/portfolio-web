<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<main>
    <section class="card grid-2">
        <div>
            <h2 class="section-title">About Me</h2>
            <p>${about.description}</p>
        </div>

        <div>
            <img src="${pageContext.request.contextPath}/assets/images/profile.jpg"
                 alt="Profile"
                 class="profile-img">
        </div>
    </section>
</main>

<%@ include file="footer.jsp" %>
