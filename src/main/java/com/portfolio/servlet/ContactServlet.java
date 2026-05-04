package com.portfolio.servlet;

import com.portfolio.util.PortfolioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ContactServlet", urlPatterns = {"/contact-submit"})
public class ContactServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        String error = null;

        if (name == null || email == null || message == null || name.trim().isEmpty() || email.trim().isEmpty() || message.trim().isEmpty()) {
            error = "Please fill in all fields.";
        }

        if (error == null) {
            try {
                boolean saved = PortfolioDAO.saveMessage(name, email, message);
                if (!saved) {
                    error = "Could not submit your message. Please try again.";
                }
            } catch (SQLException ex) {
                error = "Unable to save message: " + ex.getMessage();
            }
        }

        if (error != null) {
            request.setAttribute("error", error);
        } else {
            request.setAttribute("success", "Message sent successfully.");
        }
        request.getRequestDispatcher("contact.jsp").forward(request, response);
    }
}
