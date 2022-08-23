/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.ifprlovers.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
            request.getRequestDispatcher("WEB-INF/findLover.jsp").forward(request, response);
        } else {
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie: cookies) {
                    if ("keepLogged".equals(cookie.getName())) {
                        String email = cookie.getValue();
                            
                        session = request.getSession(true);
                        session.setAttribute("authenticated", email);
                         
                        request.getRequestDispatcher("WEB-INF/findLover.jsp").forward(request, response);
                        break;
                    }
                }
            }
            
            response.sendRedirect("WEB-INF/login.jsp");
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
