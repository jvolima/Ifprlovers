/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.ifprlovers.controllers;

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
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        if (session != null && session.getAttribute("authenticated") != null
            && (boolean)session.getAttribute("authenticated") == true) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            Cookie[] cookies = request.getCookies();
            
            if (cookies != null) {
                for (Cookie cookie: cookies) {
                    if ("keepLogged".equals(cookie.getName())) {
                        session = request.getSession(true);
                        session.setAttribute("authenticated", true);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                        break;
                    }
                }
            }
            
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        UserModel model = new UserModel();
        try {
            User u = model.findUserByEmail(email);
            
            if (u != null && u.getPassword().equals(password)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("authenticated", true);
                
                Cookie cookie = new Cookie("keepLogged", "keep");
                cookie.setMaxAge(60 * 60 * 24 * 30); //calculo referente a 30 dias
                response.addCookie(cookie);
                
                response.sendRedirect("index.jsp");
            } else {
                // Mostrar erro na tela
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
