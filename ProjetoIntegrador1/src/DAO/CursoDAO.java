/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import model.Curso;

import conexao.ConnectionFacotory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Junior Soares
 */
public class CursoDAO {
    private Connection con;;

    
   public CursoDAO(){
        this.con = new ConnectionFacotory().getConnection();
    }
    public void adiciona(Curso curso) throws SQLException{ 
        String insert = "INSERT INTO curso(faculdade,nomeCurso,tempoCurso) VALUES(?,?,?)";
       
       PreparedStatement stmt = this.con.prepareStatement(insert);
            stmt.setInt(1, curso.getFaculdade());
            stmt.setString(2, curso.getNomeCurso());
            stmt.setInt(3, curso.getTempoCurso());
                
        try {
            stmt.execute();
            System.out.println("Gravado");
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            stmt.close();
            this.con.close();
        }    
    } 
    public void excluir (int id) throws SQLException{
        String sql = "DELETE FROM curso WHERE id = ?";
        try{
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            this.con.close();
            System.out.println("Deletado");
        }catch(SQLException ex){
           Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            this.con.close();
        }
    }
    public void update(Curso curso) throws SQLException{
        String sql = "UPDATE curso SET faculdade = ?, nomeCurso = ?, tempoCurso = ? WHERE id = ?";
        
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, curso.getFaculdade());
            stmt.setString(2, curso.getNomeCurso());
            stmt.setInt(3, curso.getTempoCurso());
            stmt.setInt(4, (int) curso.getIdCurso());
            System.out.println("Alterado com Sucesso");
        try {
            stmt.execute();
            System.out.println("Alterado");
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            stmt.close();
            this.con.close();
        }    
    }
        
    public void listar() throws SQLException{
        
        String sql = "SELECT * FROM curso";
        
                PreparedStatement stmt =  this.con.prepareStatement(sql);
                ResultSet resultado = stmt.executeQuery(); 
            while(resultado.next()){
                long id = resultado.getLong("id");
                String faculdade = resultado.getString("faculdade");
                String nomeCurso =  resultado.getString("nomeCurso");
                int tempoCurso = resultado.getInt("tempoCurso"); 
                System.out.println("----------------------------------------");
                System.out.println("ID: "+id);
                System.out.println("Faculdade: "+faculdade);
                System.out.println("Nome Curso: "+nomeCurso);
                System.out.println("Tempo de Curso: "+tempoCurso);
                System.out.println("----------------------------------------");
            try{    
                 resultado.close();
                 stmt.close();
            } catch (SQLException ex) {
               Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                con.close();
            }
        }
    }
    public void buscadado(String dado) throws SQLException{
        String pesq = "SELECT Faculdade, nomeCurso, tempoCurso FROM curso WHERE nomeCurso LIKE '%"+dado+"%'";
        PreparedStatement stmt = this.con.prepareStatement(pesq);
        
        try {    
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String Faculdade = rs.getString("Faculdade"); //Colocar Inteiro pq é chave estrageira.
                String nomeCurso = rs.getString("nomeCurso");
                String tempoCurso = rs.getString("tempoCurso");
                System.out.println("| Faculdade: " + Faculdade +" | nomeCurso: " + nomeCurso + " | tempoCurso: " + tempoCurso  + " | ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            stmt.close();
            this.con.close();
        }           
    }
}
