package com.portfolio.util;

import java.sql.*;
import java.util.*;

public class PortfolioDAO {

    // ---------------- ABOUT ----------------
    public static Map<String, String> getAbout() throws SQLException {
        String sql = "SELECT title, description, profile_image FROM about WHERE id=1";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                Map<String, String> about = new HashMap<>();
                about.put("title", rs.getString("title"));
                about.put("description", rs.getString("description"));
                about.put("image", rs.getString("profile_image"));
                return about;
            }
        }
        return new HashMap<>();
    }

    // ---------------- SKILLS ----------------
    public static List<Map<String, String>> getSkills() throws SQLException {
        String sql = "SELECT id, name, level FROM skills ORDER BY id";

        List<Map<String, String>> skills = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Map<String, String> skill = new HashMap<>();
                skill.put("id", String.valueOf(rs.getInt("id")));
                skill.put("name", rs.getString("name"));
                skill.put("level", rs.getString("level"));
                skills.add(skill);
            }
        }
        return skills;
    }

    // ---------------- PROJECTS ----------------
    public static List<Map<String, String>> getProjects() throws SQLException {
        String sql = "SELECT id, title, description, tech, link, year FROM projects ORDER BY year DESC, id DESC";

        List<Map<String, String>> projects = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Map<String, String> p = new HashMap<>();
                p.put("id", String.valueOf(rs.getInt("id")));
                p.put("title", rs.getString("title"));
                p.put("description", rs.getString("description"));
                p.put("tech", rs.getString("tech"));
                p.put("link", rs.getString("link"));
                p.put("year", rs.getString("year"));
                projects.add(p);
            }
        }
        return projects;
    }

    // ---------------- EDUCATION ----------------
    public static List<Map<String, String>> getEducation() throws SQLException {
        String sql = "SELECT id, degree, institution, year, description FROM education ORDER BY id";

        List<Map<String, String>> edu = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Map<String, String> e = new HashMap<>();
                e.put("id", String.valueOf(rs.getInt("id")));
                e.put("degree", rs.getString("degree"));
                e.put("institution", rs.getString("institution"));
                e.put("year", rs.getString("year"));
                e.put("description", rs.getString("description"));
                edu.add(e);
            }
        }
        return edu;
    }

    // ---------------- CONTACT ----------------
    public static boolean saveMessage(String name, String email, String message) throws SQLException {
        String sql = "INSERT INTO messages(name, email, message) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, message);

            return stmt.executeUpdate() == 1;
        }
    }

    // ---------------- USERS ----------------
    public static boolean registerUser(String name, String email, String passwordHash) throws SQLException {
        String sql = "INSERT INTO users(name, email, password_hash) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, passwordHash);

            return stmt.executeUpdate() == 1;
        }
    }

    public static Map<String, String> findUserByEmail(String email) throws SQLException {
        String sql = "SELECT id, name, email, password_hash FROM users WHERE email = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Map<String, String> user = new HashMap<>();
                    user.put("id", String.valueOf(rs.getInt("id")));
                    user.put("name", rs.getString("name"));
                    user.put("email", rs.getString("email"));
                    user.put("password_hash", rs.getString("password_hash"));
                    return user;
                }
            }
        }
        return null;
    }

    // ---------------- PROJECT CRUD ----------------
    public static Map<String, String> getProjectById(int id) throws SQLException {
        String sql = "SELECT * FROM projects WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Map<String, String> p = new HashMap<>();
                    p.put("id", String.valueOf(rs.getInt("id")));
                    p.put("title", rs.getString("title"));
                    p.put("description", rs.getString("description"));
                    p.put("tech", rs.getString("tech"));
                    p.put("link", rs.getString("link"));
                    p.put("year", rs.getString("year"));
                    return p;
                }
            }
        }
        return null;
    }

    public static boolean saveProject(String title, String desc, String tech, String link, String year) throws SQLException {
        String sql = "INSERT INTO projects(title, description, tech, link, year) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, title);
            stmt.setString(2, desc);
            stmt.setString(3, tech);
            stmt.setString(4, link);
            stmt.setString(5, year);

            return stmt.executeUpdate() == 1;
        }
    }

    public static boolean updateProject(int id, String title, String desc, String tech, String link, String year) throws SQLException {
        String sql = "UPDATE projects SET title=?, description=?, tech=?, link=?, year=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, title);
            stmt.setString(2, desc);
            stmt.setString(3, tech);
            stmt.setString(4, link);
            stmt.setString(5, year);
            stmt.setInt(6, id);

            return stmt.executeUpdate() == 1;
        }
    }

    public static boolean deleteProject(int id) throws SQLException {
        String sql = "DELETE FROM projects WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() == 1;
        }
    }

    // ---------------- SKILL CRUD ----------------
    public static Map<String, String> getSkillById(int id) throws SQLException {
        String sql = "SELECT * FROM skills WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Map<String, String> s = new HashMap<>();
                    s.put("id", String.valueOf(rs.getInt("id")));
                    s.put("name", rs.getString("name"));
                    s.put("level", rs.getString("level"));
                    return s;
                }
            }
        }
        return null;
    }

    public static boolean saveSkill(String name, String level) throws SQLException {
        String sql = "INSERT INTO skills(name, level) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, level);

            return stmt.executeUpdate() == 1;
        }
    }

    public static boolean updateSkill(int id, String name, String level) throws SQLException {
        String sql = "UPDATE skills SET name=?, level=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, level);
            stmt.setInt(3, id);

            return stmt.executeUpdate() == 1;
        }
    }

    public static boolean deleteSkill(int id) throws SQLException {
        String sql = "DELETE FROM skills WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() == 1;
        }
    }
}
