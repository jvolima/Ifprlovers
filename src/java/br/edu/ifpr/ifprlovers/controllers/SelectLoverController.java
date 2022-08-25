/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.ifprlovers.controllers;

import br.edu.ifpr.ifprlovers.entities.User;
import br.edu.ifpr.ifprlovers.models.UserModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jvolima
 */
@WebServlet(name = "SelectLoverController", urlPatterns = {"/SelectLoverController"})
public class SelectLoverController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("loverEmail");
        request.setAttribute("loverEmail", email);
        request.getRequestDispatcher("FindLoverController").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String loverEmail = request.getParameter("emailLoverSelected");
        String userEmail = request.getParameter("emailUser");
        
        UserModel model = new UserModel();
        
        int percentageToBeAMatch = 0;
        
        try {
            User loverSelected = model.findUserByEmail(loverEmail);
            User user = model.findUserByEmail(userEmail);
            
            if (user.getGender().equals(loverSelected.getGender())) {
                if (user.getSexualOrientation().equals("Homossexual") && loverSelected.getSexualOrientation().equals("Homossexual")) {
                    percentageToBeAMatch += 60;
                } else if (user.getSexualOrientation().equals("Bissexual") && loverSelected.getSexualOrientation().equals("Bissexual")) {
                    percentageToBeAMatch += 40;
                }
            } else {
                if (user.getSexualOrientation().equals("Heterossexual") && loverSelected.getSexualOrientation().equals("Heterossexual")) {
                    percentageToBeAMatch += 60;
                } else if (user.getSexualOrientation().equals("Bissexual") && loverSelected.getSexualOrientation().equals("Bissexual")) {
                    percentageToBeAMatch += 40;
                }
            }
            
            Random r = new Random();
            IntStream stream = r.ints(0, 40);
            int random = stream.findAny().getAsInt();
            percentageToBeAMatch += random;
            
            /*double random = (Math.random() * (40 - 0)) + 0;
            BigDecimal bd = new BigDecimal(String.valueOf(random));
            BigDecimal rounded = bd.setScale(2,RoundingMode.FLOOR);
            double formatted = Double.parseDouble(String.valueOf(rounded));

            percentageToBeAMatch += formatted;*/
            
        } catch (SQLException ex) {
            Logger.getLogger(SelectLoverController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        response.sendRedirect("FindLoverController?loverEmail=" + loverEmail + "&percentage=" + percentageToBeAMatch);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
