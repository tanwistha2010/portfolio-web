package com.portfolio.servlet;

import com.portfolio.util.PortfolioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "PublicServlet", urlPatterns = {"/home", "/about", "/skills", "/projects", "/education", "/contact"})
public class PublicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("about", PortfolioDAO.getAbout());
            request.setAttribute("skills", PortfolioDAO.getSkills());
            request.setAttribute("projects", PortfolioDAO.getProjects());
            request.setAttribute("education", PortfolioDAO.getEducation());
        } catch (SQLException ex) {
            request.setAttribute("error", "Unable to load content: " + ex.getMessage());
        }

        String path = request.getServletPath();
        switch (path) {
            case "/about":
                request.getRequestDispatcher("about.jsp").forward(request, response);
                break;
            case "/skills":
                request.getRequestDispatcher("skills.jsp").forward(request, response);
                break;
            case "/projects":
                request.getRequestDispatcher("projects.jsp").forward(request, response);
                break;
            case "/education":
                request.getRequestDispatcher("education.jsp").forward(request, response);
                break;
            case "/contact":
                request.getRequestDispatcher("contact.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
        }
    }
}
