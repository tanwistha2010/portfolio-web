<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>

<main>
    <section class="card">
        <h2 class="section-title">Contact</h2>

        <c:if test="${not empty error}">
            <div class="alert error">
                <c:out value="${error}"/>
            </div>
        </c:if>

        <c:if test="${not empty success}">
            <div class="alert success">
                <c:out value="${success}"/>
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/contact-submit"
              method="post"
              onsubmit="return validateContactForm()">

            <div id="contact-error"
                 class="alert error"
                 style="display:none;">
            </div>

            <label for="contact-name">Name</label>
            <input id="contact-name"
                   name="name"
                   type="text"
                   required>

            <label for="contact-email">Email</label>
            <input id="contact-email"
                   name="email"
                   type="email"
                   required>

            <label for="contact-message">Message</label>
            <textarea id="contact-message"
                      name="message"
                      rows="5"
                      required></textarea>

            <button type="submit">
                Send Message
            </button>
        </form>
    </section>
</main>

<%@ include file="footer.jsp" %>
