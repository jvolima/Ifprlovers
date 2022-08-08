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
@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {
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
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
