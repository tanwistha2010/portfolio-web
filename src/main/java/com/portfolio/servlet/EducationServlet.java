package com.portfolio.servlet;

import com.portfolio.util.PortfolioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/education")
public class EducationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            request.setAttribute("education", PortfolioDAO.getEducation());
        } catch (SQLException e) {
            request.setAttribute("error", "Unable to load education: " + e.getMessage());
        }

        request.getRequestDispatcher("education.jsp").forward(request, response);
    }
}