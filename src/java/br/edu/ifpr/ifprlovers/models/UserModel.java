/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.ifprlovers.models;

import br.edu.ifpr.ifprlovers.daos.UserDAO;
import br.edu.ifpr.ifprlovers.entities.User;
import java.sql.SQLException;

/**
 *
 * @author jvolima
 */
public class UserModel {
    UserDAO dao = new UserDAO();
    
    public String registerUser(User u) throws SQLException {
        User userAlreadyExists = dao.findUserByEmail(u.getEmail());
        
        if(userAlreadyExists != null) {
            return "Erro ao cadastrar novo usuário, email já está sendo usado";
        }
        
        dao.register(u);
        return "Cadastro realizado";
    }
    
    public User findUserByEmail(String email) throws SQLException {
        User u = dao.findUserByEmail(email);
        
        return u;
    }
    
    public void updateUser(User u) throws SQLException {
        dao.updateUser(u);
    }
}
