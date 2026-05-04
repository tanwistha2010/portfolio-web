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

@WebServlet(name = "SkillServlet", urlPatterns = {"/skill"})
public class SkillServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String idParam = request.getParameter("id");
        try {
            if ("add".equals(action)) {
                request.getRequestDispatcher("skill-form.jsp").forward(request, response);
                return;
            }
            if ("edit".equals(action) && idParam != null) {
                Map<String, String> skill = PortfolioDAO.getSkillById(Integer.parseInt(idParam));
                request.setAttribute("skill", skill);
                request.getRequestDispatcher("skill-form.jsp").forward(request, response);
                return;
            }
            if ("delete".equals(action) && idParam != null) {
                PortfolioDAO.deleteSkill(Integer.parseInt(idParam));
            }
        } catch (SQLException ex) {
            request.setAttribute("error", "Skill operation failed: " + ex.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/dashboard");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String name = request.getParameter("name");
        String level = request.getParameter("level");
        String idParam = request.getParameter("id");
        String error = null;

        if (name == null || name.trim().isEmpty() || level == null || level.trim().isEmpty()) {
            error = "Skill name and level are required.";
        }

        try {
            if (error == null) {
                if ("edit".equals(action) && idParam != null) {
                    PortfolioDAO.updateSkill(Integer.parseInt(idParam), name, level);
                } else {
                    PortfolioDAO.saveSkill(name, level);
                }
            }
        } catch (SQLException ex) {
            error = "Unable to save skill: " + ex.getMessage();
        }

        if (error != null) {
            request.setAttribute("error", error);
            request.getRequestDispatcher("skill-form.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/dashboard");
        }
    }
}
