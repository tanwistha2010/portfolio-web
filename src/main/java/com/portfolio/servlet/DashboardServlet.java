package com.portfolio.servlet;

import com.portfolio.util.PortfolioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DashboardServlet", urlPatterns = {"/dashboard"})
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("projects", PortfolioDAO.getProjects());
            request.setAttribute("skills", PortfolioDAO.getSkills());
        } catch (SQLException ex) {
            request.setAttribute("error", "Dashboard load failed: " + ex.getMessage());
        }
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
