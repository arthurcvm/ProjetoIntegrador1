/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Professor;
import conexao.ConnectionFacotory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Faculdade;

/**
 *
 * @author csarp
 */
public class ProfessorDAO {
   private Connection con;
    public ProfessorDAO(){
        this.con = new ConnectionFacotory().getConnection();
    }
    public void insert(Professor professor) throws SQLException{
        String insert = "INSERT INTO professor (nome, cpf, fkFaculdade)";
                insert += " VALUES(?,?,?)";
                
        PreparedStatement stmt = this.con.prepareStatement(insert);
        stmt.setString(1, professor.getNome());
        stmt.setString(2, professor.getCpf());
        //stmt.setInt(3, Faculdade.;
        try {
            stmt.execute();
            System.out.println("Gravado");
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            stmt.close();
            this.con.close();
        }
    }
    public void delete(int id) throws SQLException{
        String delete = "DELETE FROM professor WHERE ";
        delete+="id=?";
        
       try {
            PreparedStatement stmt = this.con.prepareStatement(delete);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
            this.con.close();
            System.out.println("Deletado");
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void lista() throws SQLException{
        String select = "SELECT * FROM professor";
        PreparedStatement stmt = this.con.prepareStatement(select);
        try {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                
                System.out.println("| Nome: " + nome +" | CPF: " + cpf + " | ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            stmt.close();
            this.con.close();
        }  
    }
    public void buscadado(String dado) throws SQLException{
        String pesq = "SELECT nome, cpf FROM professor WHERE nome LIKE '%"+dado+"%'";
        PreparedStatement stmt = this.con.prepareStatement(pesq);
        
        try {    
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                
                System.out.println("| Nome: " + nome +" | CPF: " + cpf + " | ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            stmt.close();
            this.con.close();
        }           
    } 
}
