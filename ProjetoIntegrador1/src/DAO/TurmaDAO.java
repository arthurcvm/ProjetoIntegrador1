/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexao.ConnectionFacotory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Turma;

/**
 *
 * @author Mateus
 */
public class TurmaDAO {
    private Connection con;
    public TurmaDAO(){
       this.con = new ConnectionFacotory().getConnection();
    }
    
    public void insert(Turma turma) throws SQLException {
        String insert = "INSERT INTO turma (descricao, semestre, curso)";
                insert += " VALUES(?,?,?)";
                
        PreparedStatement stmt = this.con.prepareStatement(insert);
        stmt.setString(1, turma.getDescricao());
        stmt.setInt(2, turma.getSemestre());
        stmt.setInt(3, turma.getCurso());

        try {
            stmt.execute();
            System.out.println("Gravado");
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            stmt.close();
            this.con.close();
        }      
    }
    
    public void delete(int id) throws SQLException{
        String delete = "DELETE FROM turma WHERE ";
               delete+= "id=?";

        try {
            PreparedStatement stmt = this.con.prepareStatement(delete);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
            this.con.close();
            System.out.println("Deletado");
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void lista() throws SQLException{
        String select = "SELECT * FROM turma";
        PreparedStatement stmt = this.con.prepareStatement(select);
        try {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String descricao = rs.getString("descricao");
                String semestre = rs.getString("semestre");
                int curso = rs.getInt("curso");
                System.out.println("Nome: " + descricao +" | Abreviação: " + semestre + " | CH: " + curso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            stmt.close();
            this.con.close();
        }        
    }
    
    public void buscadado(String dado) throws SQLException{
        String pesq = "SELECT nome, abreviacao, CH, semestre, professor FROM disciplina WHERE nome LIKE '%"+dado+"%'";
        PreparedStatement stmt = this.con.prepareStatement(pesq);
        
        try {    
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String descricao = rs.getString("descricao");
                String semestre = rs.getString("semestre");
                int curso = rs.getInt("curso");
                System.out.println("Nome: " + descricao +" | Abreviação: " + semestre + " | CH: " + curso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            stmt.close();
            this.con.close();
        }           
    }
}
