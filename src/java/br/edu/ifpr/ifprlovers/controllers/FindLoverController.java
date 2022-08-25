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
import java.util.ArrayList;
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
@WebServlet(name = "FindLoverController", urlPatterns = {"/FindLoverController"})
public class FindLoverController extends HttpServlet {
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
                
                String loverEmail = request.getParameter("loverEmail");
                
                String stringPercentage = request.getParameter("percentage");
                
                if (stringPercentage != null) {
                    float percentage = Float.parseFloat(stringPercentage);
                    request.setAttribute("percentage", percentage);
                }
                
                if (loverEmail != null) {
                    User lover = model.findUserByEmail(loverEmail);
                    request.setAttribute("lover", lover);
                }
                
                ArrayList<User> lovers = model.listAll();
                
                int index = 0;
                
                for(User u: lovers) {
                    if (u.getEmail().equals(user.getEmail())) {
                        index = lovers.indexOf(u);
                    }
                }
                
                lovers.remove(index);
                
                request.setAttribute("lovers", lovers);
            } catch (SQLException ex) {
                Logger.getLogger(FindLoverController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            request.getRequestDispatcher("WEB-INF/findLover.jsp").forward(request, response);
        } else {
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie: cookies) {
                    if ("keepLogged".equals(cookie.getName())) {
                        String email = cookie.getValue();
                        UserModel model = new UserModel();
                        
                        User user;
                        try {
                            user = model.findUserByEmail(email);
                            request.setAttribute("user", user);
                            
                            String loverEmail = request.getParameter("loverEmail");
                            if (loverEmail != null) {
                                User lover = model.findUserByEmail(loverEmail);
                                request.setAttribute("lover", lover);
                            }
                            
                            session = request.getSession(true);
                            session.setAttribute("authenticated", email);
                        } catch (SQLException ex) {
                            Logger.getLogger(FindLoverController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                                  
                        request.getRequestDispatcher("WEB-INF/findLover.jsp").forward(request, response);
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
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
