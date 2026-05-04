package com.portfolio.servlet;

import com.portfolio.util.HashUtil;
import com.portfolio.util.PortfolioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String error = null;

        if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            error = "Please enter email and password.";
        }

        if (error == null) {
            try {
                Map<String, String> user = PortfolioDAO.findUserByEmail(email);
                if (user == null || !user.get("password_hash").equals(HashUtil.sha256(password))) {
                    error = "Invalid email or password.";
                } else {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("userId", user.get("id"));
                    session.setAttribute("userName", user.get("name"));
                    response.sendRedirect(request.getContextPath() + "/dashboard");
                    return;
                }
            } catch (SQLException ex) {
                error = "Login error: " + ex.getMessage();
            }
        }

        request.setAttribute("error", error);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
