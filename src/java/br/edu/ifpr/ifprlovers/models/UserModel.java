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
    public String registerUser(User u) throws SQLException {
        UserDAO dao = new UserDAO();
        User userAlreadyExists = dao.findUserByEmail(u.getEmail());
        
        if(userAlreadyExists != null) {
            return "Erro ao cadastrar novo usuário, email já está sendo usado";
        }
        
        dao.register(u);
        return "Cadastro realizado";
    }
}
