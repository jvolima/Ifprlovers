/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.ifprlovers.daos;

import br.edu.ifpr.ifprlovers.entities.User;
import br.edu.ifpr.ifprlovers.factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jvolima
 */
public class UserDAO {
    public void register(User u) throws SQLException {
        String sql = "INSERT INTO USERS (NAME, EMAIL, PASSWORD, GENDER, "
                + "SEXUAL_ORIENTATION, AGE, IMAGE_CONTENT, CONTENT_TYPE) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, u.getName());
        stmt.setString(2, u.getEmail());
        stmt.setString(3, u.getPassword());
        stmt.setString(4, u.getGender());
        stmt.setString(5, u.getSexualOrientation());
        stmt.setInt(6, u.getAge());
        stmt.setBytes(7, u.getImage());
        stmt.setString(8, u.getImageType());

        stmt.execute();
        
        stmt.close();
        connection.close();
    }
    
    public User findUserByEmail(String email) throws SQLException {
        String sql = "SELECT ID, NAME, EMAIL, PASSWORD, GENDER, SEXUAL_ORIENTATION, AGE FROM USERS WHERE EMAIL = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        
        User u = null;
        
        if(rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("NAME");
            String password = rs.getString("PASSWORD");
            String gender = rs.getString("GENDER");
            String sexualOrientation = rs.getString("SEXUAL_ORIENTATION");
            int age = rs.getInt("AGE");
            u = new User(id, name, email, password, gender, sexualOrientation, age);
        }
        
        return u;
    }
    
    public void updateUser(User u) throws SQLException {
        String sql= "UPDATE USERS SET NAME = ?, AGE = ?, GENDER = ?, SEXUAL_ORIENTATION = ? WHERE ID = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, u.getName());
        stmt.setInt(2, u.getAge());
        stmt.setString(3, u.getGender());
        stmt.setString(4, u.getSexualOrientation());
        stmt.setInt(5, u.getId());
        
        stmt.execute();
        
        stmt.close();
        connection.close();
    }
    
    public ArrayList<User> listAll() throws SQLException {
        String sql = "SELECT ID, NAME, EMAIL, GENDER, SEXUAL_ORIENTATION, AGE FROM USERS";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<User> users = new ArrayList();
        
        while(rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("NAME");
            String email = rs.getString("EMAIL");
            String gender = rs.getString("GENDER");
            String sexualOrientation = rs.getString("SEXUAL_ORIENTATION");
            int age = rs.getInt("AGE");
            
            User u = new User(id, name, email, gender, sexualOrientation, age);
            users.add(u);
        }
        
        return users;
    }
}
