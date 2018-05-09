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
import model.TurmaGenerica;

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
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(int id){
        try {
            String delete = "DELETE FROM turma WHERE ";
                   delete+= "idTURMA=?";
            PreparedStatement stmt = this.con.prepareStatement(delete);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
            this.con.close();
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
    
    public ArrayList<TurmaGenerica> listaGen(){
        ArrayList<Turma> turmaList = lista();
        ArrayList<TurmaGenerica> turmaGenericaList = new ArrayList();
        for(Turma t: turmaList){
                turmaGenericaList.add(new TurmaGenerica(t));
            }
        return turmaGenericaList;
    }
    
    public void edit(Turma turma){
        try {
            String update = "UPDATE turma SET descricao=?, SEMESTRE_idSEMESTRE=?, CURSO_idCURSO=? ";
                update+="WHERE idTURMA=?";
            PreparedStatement stmt = this.con.prepareStatement(update);
            stmt.setString(1, turma.getDescricao());
            stmt.setInt(2, turma.getSemestre());
            stmt.setInt(3, turma.getCurso());
            stmt.setInt(4, turma.getIdTurma());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FaculdadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Turma> search(String dado){
        ArrayList<Turma> array = new ArrayList();
        try {
            String pesq = "SELECT * FROM "
                    + "turma WHERE descricao LIKE '%?%'";
            PreparedStatement stmt = this.con.prepareStatement(pesq);
            stmt.setString(1, dado);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Turma turma= new Turma();
                turma.setIdTurma(rs.getInt("idTURMA"));
                turma.setDescricao(rs.getString("descricao"));
                turma.setSemestre(rs.getInt("SEMESTRE_idSEMESTRE"));
                turma.setCurso(rs.getInt("CURSO_idCURSO"));
                array.add(turma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }         
        return array;
    }
    
    public ArrayList<Turma> filtro(int id_curso){
        ArrayList<Turma> array = new ArrayList();
        try {
            String pesq = "SELECT * FROM "
                    + "turma WHERE CURSO_idCURSO = ?";
            PreparedStatement stmt = this.con.prepareStatement(pesq);
            stmt.setInt(1, id_curso);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Turma turma = new Turma();
                turma.setIdTurma(rs.getInt("idTURMA"));
                turma.setDescricao(rs.getString("descricao"));
                turma.setSemestre(rs.getInt("SEMESTRE_idSEMESTRE"));
                turma.setCurso(rs.getInt("CURSO_idCURSO"));
                array.add(turma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }         
        return array;
    }
    
    public ArrayList<TurmaGenerica> filtroGen(int id_curso){
        ArrayList<Turma> turmaList = filtro(id_curso);
        ArrayList<TurmaGenerica> turmaGenericaList = new ArrayList();
        for(Turma t: turmaList){
                turmaGenericaList.add(new TurmaGenerica(t));
            }
        return turmaGenericaList;                
    }
}
