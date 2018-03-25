/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author csarp
 */
public class ConnectionFacotory {
    public Connection getConnection(){
        try {
            return (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Teste", "root", "1234");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}