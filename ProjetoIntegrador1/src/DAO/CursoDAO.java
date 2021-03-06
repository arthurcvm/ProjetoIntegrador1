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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Curso;
import model.CursoGenerico;

/**
 *
 * @author Mateus
 */
public class CursoDAO {
    private Connection con;
    public CursoDAO(){
        this.con = new ConnectionFacotory().getConnection();
    }
    
    public void insert(Curso curso){
        try {
            String insert = "INSERT INTO curso (nomeCurso, qtdSemestres, FACULDADE_idFACULDADE)";
                    insert += " VALUES(?,?,?)";
            PreparedStatement stmt = this.con.prepareStatement(insert);
            stmt.setString(1, curso.getNomeCurso());
            stmt.setInt(2, curso.getQtdSemestres());
            stmt.setInt(3, curso.getFaculdade());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(int id){
       try {
            String delete = "DELETE FROM curso WHERE ";
            delete+="idCURSO=?";
            PreparedStatement stmt = this.con.prepareStatement(delete);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public ArrayList<Curso> lista(){
        ArrayList<Curso> array = new ArrayList();
        try {
            String select = "SELECT * FROM curso";
            PreparedStatement stmt = this.con.prepareStatement(select);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Curso curso= new Curso();
                curso.setIdCurso(rs.getInt("idCURSO"));
                curso.setNomeCurso(rs.getString("nomeCurso"));
                curso.setQtdSemestres(rs.getInt("qtdSemestres"));
                curso.setFaculdade(rs.getInt("FACULDADE_idFACULDADE"));
                array.add(curso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }
   
   public ArrayList<CursoGenerico> listaGen(){
        ArrayList<Curso> cursoList = lista();
        ArrayList<CursoGenerico> cursoGenericoList = new ArrayList();
        for(Curso c: cursoList){
                cursoGenericoList.add(new CursoGenerico(c));
            }
        return cursoGenericoList;
    }
   
   public Curso get(int id){
       ArrayList<Curso> cursoList = lista();
       for(Curso c: cursoList){
           if(c.getIdCurso() == id){
               return c;
           }
       }
       return null;
   }
   
    public void edit(Curso curso){
        try {
            String update = "UPDATE curso SET nomeCurso=?, qtdSemestres=?, FACULDADE_idFACULDADE=? ";
                update+="WHERE idCURSO=?";
            PreparedStatement stmt = this.con.prepareStatement(update);
            stmt.setString(1, curso.getNomeCurso());
            stmt.setInt(2, curso.getQtdSemestres());
            stmt.setInt(3, curso.getFaculdade());
            stmt.setInt(4, curso.getIdCurso());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Curso> search(String dado){
        ArrayList<Curso> array = new ArrayList();
        try {
            String pesq = "SELECT * FROM "
                    + "curso WHERE nomeCurso LIKE '%?%'";
            PreparedStatement stmt = this.con.prepareStatement(pesq);
            stmt.setString(1, dado);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Curso curso= new Curso();
                curso.setIdCurso(rs.getInt("idCURSO"));
                curso.setNomeCurso(rs.getString("nomeCurso"));
                curso.setQtdSemestres(rs.getInt("qtdSemestres"));
                curso.setFaculdade(rs.getInt("FACULDADE_idFACULDADE"));
                array.add(curso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }         
        return array;
    }
    
    public ArrayList<Curso> filtro(int id){
        ArrayList<Curso> array = new ArrayList();
        try {
            String pesq = "SELECT * FROM "
                    + "curso WHERE FACULDADE_idFACULDADE = ?";
            PreparedStatement stmt = this.con.prepareStatement(pesq);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Curso curso= new Curso();
                curso.setIdCurso(rs.getInt("idCURSO"));
                curso.setNomeCurso(rs.getString("nomeCurso"));
                curso.setQtdSemestres(rs.getInt("qtdSemestres"));
                curso.setFaculdade(rs.getInt("FACULDADE_idFACULDADE"));
                array.add(curso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }         
        return array;
    }
}
