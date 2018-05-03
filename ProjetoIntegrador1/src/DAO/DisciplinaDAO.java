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
import model.Disciplina;
import model.Turma;

/**
 *
 * @author Mateus
 */
public class DisciplinaDAO {
    private Connection con;
    public DisciplinaDAO(){
       this.con = new ConnectionFacotory().getConnection();
    }
    
    public void insert(Disciplina dis){
        try {
            String insert = "INSERT INTO disciplina (nome, abreviacao, ch, SEMESTRE_idSEMESTRE, PROFESSOR_idPROFESSOR)";
                    insert += " VALUES(?,?,?,?,?)";

            PreparedStatement stmt = this.con.prepareStatement(insert);
            stmt.setString(1, dis.getNome());
            stmt.setString(2, dis.getAbreviacao());
            stmt.setInt(3, dis.getCH());
            stmt.setInt(4, dis.getSemestre());
            stmt.setInt(5, dis.getProfessor());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void delete(int id){
        try {
            String delete = "DELETE FROM disciplina WHERE ";
                   delete+= "idDISCIPLINA=?";
            PreparedStatement stmt = this.con.prepareStatement(delete);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Disciplina> lista(){
        ArrayList<Disciplina> disciplina = new ArrayList();
        try {
            String select = "SELECT * FROM disciplina";
            PreparedStatement stmt = this.con.prepareStatement(select);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Disciplina disc = new Disciplina();
                disc.setIdDisciplina(rs.getInt("idDISCIPLINA"));
                disc.setNome(rs.getString("nome"));
                disc.setAbreviacao(rs.getString("abreviacao"));
                disc.setCH(rs.getInt("ch"));
                disc.setSemestre(rs.getInt("SEMESTRE_idSEMESTRE"));
                disc.setProfessor(rs.getInt("PROFESSOR_idPROFESSOR"));
                disciplina.add(disc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return disciplina;
    }
    
    public void buscadado(String dado){
        try { 
            String pesq = "SELECT nome, abreviacao, CH, semestre, professor FROM disciplina WHERE nome LIKE '%"+dado+"%'";
            PreparedStatement stmt = this.con.prepareStatement(pesq);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome");
                String abreviacao = rs.getString("abreviacao");
                int CH = rs.getInt("CH");
                int semestre = rs.getInt("semestre");
                int professor = rs.getInt("professor");
                System.out.println("Nome: " + nome +" | Abreviação: " + abreviacao + " | CH: " + CH  + " | Semestre: " + semestre  + " | Professor: " + professor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }           
    }
    
    public void edit(Disciplina disc){
        try {
            String update = "UPDATE disciplina SET nome=?, abreviacao=?, ch=?, SEMESTRE_idSEMESTRE=?, ";
                update+="PROFESSOR_idPROFESSOR=? WHERE idDISCIPLINA=?";
            PreparedStatement stmt = this.con.prepareStatement(update);
            stmt.setString(1, disc.getNome());
            stmt.setString(2, disc.getAbreviacao());
            stmt.setInt(3, disc.getCH());
            stmt.setInt(4, disc.getSemestre());
            stmt.setInt(5, disc.getProfessor());
            stmt.setInt(6, disc.getIdDisciplina());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FaculdadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
