/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.ifprlovers.controllers;

import br.edu.ifpr.ifprlovers.daos.UserDAO;
import br.edu.ifpr.ifprlovers.entities.User;
import br.edu.ifpr.ifprlovers.models.UserModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jvolima
 */
@WebServlet(name = "ProfileController", urlPatterns = {"/ProfileController"})
public class ProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        if (session != null && session.getAttribute("authenticated") != null) {
            String email = (String) session.getAttribute("authenticated");
            
            UserModel model = new UserModel();
            try {
                User user = model.findUserByEmail(email);
                request.setAttribute("user", user);
            } catch (SQLException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            request.getRequestDispatcher("WEB-INF/profile.jsp").forward(request, response);
        } else {
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie: cookies) {
                    if ("keepLogged".equals(cookie.getName())) {
                        String email = cookie.getValue();
                        UserModel model = new UserModel();
                        
                        try {
                            User user = model.findUserByEmail(email);
                            request.setAttribute("user", user);
                            
                            session = request.getSession(true);
                            session.setAttribute("authenticated", user.getEmail());
                        } catch (SQLException ex) {
                            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         
                        request.getRequestDispatcher("WEB-INF/profile.jsp").forward(request, response);
                        break;
                    }
                }
            }
            
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String sexual_orientation = request.getParameter("sexual_orientation");
        String gender = request.getParameter("gender");
        
        System.out.println(email);
        
        UserModel model = new UserModel();
        try {
            User u = model.findUserByEmail(email);
            u.setName(name);
            u.setAge(age);
            u.setSexualOrientation(sexual_orientation);
            u.setGender(gender);
            
            UserDAO dao = new UserDAO();
            dao.updateUser(u);
            
            response.sendRedirect("HomeController");
        } catch (SQLException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
