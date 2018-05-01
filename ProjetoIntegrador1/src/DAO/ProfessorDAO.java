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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ProfessorGenerico;

/**
 *
 * @author csarp
 */
public class ProfessorDAO {
   private Connection con;
    public ProfessorDAO(){
        this.con = new ConnectionFacotory().getConnection();
    }
  
    public void insert(Professor professor){
        try {
            String insert = "INSERT INTO professor (nome, cpf)";
                    insert += " VALUES(?,?)";

            PreparedStatement stmt = this.con.prepareStatement(insert);
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getCpf());       
        
            stmt.execute();
            System.out.println("Gravado");
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(int id){
        try {
            String delete = "DELETE FROM professor WHERE ";
            delete+="id=?";
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
    
    public void lista(){
        try {
            String select = "SELECT * FROM professor";
            PreparedStatement stmt = this.con.prepareStatement(select);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                
                System.out.println("| Nome: " + nome +" | CPF: " + cpf + " | ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public ArrayList<ProfessorGenerico> listaGen(){
        ArrayList<Professor> professorList = lista();
        ArrayList<ProfessorGenerico> professorGenericoList = new ArrayList();
        for(Professor p: professorList){
                professorGenericoList.add(new ProfessorGenerico(p));
            }
        
        return professorGenericoList;
    }
    
    public void buscadado(String dado){
        try {
            String pesq = "SELECT nome, cpf FROM professor WHERE nome LIKE '%"+dado+"%'";
            PreparedStatement stmt = this.con.prepareStatement(pesq);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                
                System.out.println("| Nome: " + nome +" | CPF: " + cpf + " | ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
