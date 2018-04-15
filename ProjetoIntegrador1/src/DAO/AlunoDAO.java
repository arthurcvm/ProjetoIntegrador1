/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Aluno;
import conexao.ConnectionFacotory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author csarp
 */
public class AlunoDAO {
    private Connection con;
    public AlunoDAO(){
        this.con = new ConnectionFacotory().getConnection();
    }
    public void insert(Aluno Aluno) throws SQLException{
        String insert = "INSERT INTO aluno (nome, cpf,rg,fkTurma)";
                insert += " VALUES(?,?,?,?)";
                
        PreparedStatement stmt = this.con.prepareStatement(insert);
        stmt.setString(1, Aluno.getNome());
        stmt.setString(2, Aluno.getCpf());
        stmt.setString(3, Aluno.getRG());
        
        try {
            stmt.execute();
            System.out.println("Gravado");
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            stmt.close();
            this.con.close();
        }
    }
    public void delete(int id) throws SQLException{
        String delete = "DELETE FROM aluno WHERE ";
        delete+="id=?";
        
       try {
            PreparedStatement stmt = this.con.prepareStatement(delete);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
            this.con.close();
            System.out.println("Deletado");
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void lista() throws SQLException{
        String select = "SELECT * FROM aluno";
        PreparedStatement stmt = this.con.prepareStatement(select);
        try {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String rg = rs.getString("rg");
                System.out.println("Nome: " + nome +" | CPF: " + cpf + " | RG: " + rg  + " | ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            stmt.close();
            this.con.close();
        }  
    }
    public void buscadado(String dado) throws SQLException{
        String pesq = "SELECT nome, cpf, rg FROM aluno WHERE nome LIKE '%"+dado+"%'";
        PreparedStatement stmt = this.con.prepareStatement(pesq);
        
        try {    
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String rg = rs.getString("rg");
                System.out.println("| Nome: " + nome +" | CPF: " + cpf + " | RG: " + rg  + " | ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            stmt.close();
            this.con.close();
        }           
    }
}
