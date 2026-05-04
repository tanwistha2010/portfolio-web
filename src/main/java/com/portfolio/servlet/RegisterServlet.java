package com.portfolio.servlet;

import com.portfolio.util.HashUtil;
import com.portfolio.util.PortfolioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String error = null;
        if (name == null || name.trim().isEmpty() || email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            error = "All fields are required.";
        }

        if (error == null) {
            String passwordHash = HashUtil.sha256(password);
            try {
                boolean registered = PortfolioDAO.registerUser(name, email, passwordHash);
                if (!registered) {
                    error = "Registration failed. Try another email.";
                }
            } catch (SQLException ex) {
                error = "Could not register user: " + ex.getMessage();
            }
        }

        if (error != null) {
            request.setAttribute("error", error);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            request.setAttribute("success", "Registration successful. Please login.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
