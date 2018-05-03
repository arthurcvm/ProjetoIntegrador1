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
    
    public void insert(Turma turma){
        try {
            String insert = "INSERT INTO turma (descricao, SEMESTRE_idSEMESTRE, CURSO_idCURSO)";
                    insert += " VALUES(?,?,?)";

            PreparedStatement stmt = this.con.prepareStatement(insert);
            stmt.setString(1, turma.getDescricao());
            stmt.setInt(2, turma.getSemestre());
            stmt.setInt(3, turma.getCurso());
        
            stmt.execute();
            System.out.println("Gravado");
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(int id){
        try {
            String delete = "DELETE FROM turma WHERE ";
                   delete+= "id=?";
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
    
    public ArrayList<Turma> lista(){
        ArrayList<Turma> turma = new ArrayList();
        try {
            String select = "SELECT * FROM turma";
            PreparedStatement stmt = this.con.prepareStatement(select);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
               Turma t = new Turma();
               t.setIdTurma(rs.getInt("idTURMA"));
               t.setDescricao(rs.getString("descricao"));
               t.setSemestre(rs.getInt("SEMESTRE_idSEMESTRE"));
               t.setCurso(rs.getInt("CURSO_idCURSO"));
               turma.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return turma;
    }
    
    public void buscadado(String dado){
        try {
            String pesq = "SELECT nome, abreviacao, CH, semestre, professor FROM disciplina WHERE nome LIKE '%"+dado+"%'";
            PreparedStatement stmt = this.con.prepareStatement(pesq);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String descricao = rs.getString("descricao");
                String semestre = rs.getString("semestre");
                int curso = rs.getInt("curso");
                System.out.println("Nome: " + descricao +" | Abreviação: " + semestre + " | CH: " + curso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }
}
