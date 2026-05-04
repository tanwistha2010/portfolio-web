package com.portfolio.servlet;

import com.portfolio.util.PortfolioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "ProjectServlet", urlPatterns = {"/project"})
public class ProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String idParam = request.getParameter("id");
        try {
            if ("add".equals(action)) {
                request.getRequestDispatcher("project-form.jsp").forward(request, response);
                return;
            }
            if ("edit".equals(action) && idParam != null) {
                Map<String, String> project = PortfolioDAO.getProjectById(Integer.parseInt(idParam));
                request.setAttribute("project", project);
                request.getRequestDispatcher("project-form.jsp").forward(request, response);
                return;
            }
            if ("delete".equals(action) && idParam != null) {
                PortfolioDAO.deleteProject( Integer.parseInt(idParam));
            }
        } catch (SQLException ex) {
            request.setAttribute("error", "Project operation failed: " + ex.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/dashboard");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String tech = request.getParameter("tech");
        String link = request.getParameter("link");
        String year = request.getParameter("year");
        String idParam = request.getParameter("id");
        String error = null;

        if (title == null || title.trim().isEmpty() || description == null || description.trim().isEmpty()) {
            error = "Project title and description are required.";
        }

        try {
            if (error == null) {
                if ("edit".equals(action) && idParam != null) {
                    PortfolioDAO.updateProject( Integer.parseInt(idParam), title, description, tech, link, year);
                } else {
                    PortfolioDAO.saveProject( title, description, tech, link, year);
                }
            }
        } catch (SQLException ex) {
            error = "Unable to save project: " + ex.getMessage();
        }

        if (error != null) {
            request.setAttribute("error", error);
            request.getRequestDispatcher("project-form.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/dashboard");
        }
    }
}
