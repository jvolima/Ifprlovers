/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.ifprlovers.controllers;

import br.edu.ifpr.ifprlovers.entities.User;
import br.edu.ifpr.ifprlovers.models.UserModel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author jvolima
 */
@WebServlet(name = "UserRegisterController", urlPatterns = {"/UserRegisterController"})
@MultipartConfig(maxFileSize = 8 * 1024 * 1024 * 5/*5MB*/)
public class UserRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("WEB-INF/userRegistration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String sexualOrientation = request.getParameter("sexual_orientation");
        int age = Integer.parseInt(request.getParameter("age"));
        
        Part part = request.getPart("image");
        String contentType = part.getContentType();
        
        byte[] image = new byte[part.getInputStream().available()];
        
        part.getInputStream().read(image);
        
        User u = new User(name, email, password, gender, 
                sexualOrientation, age, contentType, image);
        
        UserModel model = new UserModel();
        
        try {
            String message = model.registerUser(u);
            if(message.equals("Erro ao cadastrar novo usuário, email já está sendo usado")) {
                //informar erro ao usuário
                request.getRequestDispatcher("WEB-INF/userRegistration.jsp").forward(request, response);
            } else {
                response.sendRedirect("LoginController");
            }        
        } catch (SQLException ex) {
            Logger.getLogger(UserRegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
