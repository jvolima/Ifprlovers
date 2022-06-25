/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.ifprlovers.factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jvolima
 */
public class ConnectionFactory {
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:derby://localhost:1527/ifprlovers");
    }
}
