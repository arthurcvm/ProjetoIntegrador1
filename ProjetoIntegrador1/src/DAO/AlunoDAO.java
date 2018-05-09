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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AlunoGenerico;

/**
 *
 * @author csarp
 */
public class AlunoDAO {
    private Connection con;
    public AlunoDAO(){
        this.con = new ConnectionFacotory().getConnection();
    }
    
    public void insert(Aluno Aluno){
        try {
            String insert = "INSERT INTO aluno (nome, cpf, rg, login, senha, TURMA_idTURMA)";
                    insert += " VALUES(?,?,?,?,?,?)";

            PreparedStatement stmt = this.con.prepareStatement(insert);
            stmt.setString(1, Aluno.getNome());
            stmt.setString(2, Aluno.getCpf());
            stmt.setString(3, Aluno.getRG());
            stmt.setString(4, Aluno.getCpf());
            stmt.setString(5, Aluno.getSenha());
            stmt.setInt(6, Aluno.getTurma());
        
            stmt.execute();
//            System.out.println("Gravado");
            stmt.close();
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(int id){
        try {
            String delete = "DELETE FROM aluno WHERE ";
            delete+="idALUNO=?";
            PreparedStatement stmt = this.con.prepareStatement(delete);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
            this.con.close();
//            System.out.println("Deletado");
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void edit(Aluno aluno){
        try {
            String update = "UPDATE aluno SET nome=?, cpf=?, rg=?, login=?, senha=?, ";
                update+="TURMA_idTURMA=? WHERE idALUNO=?";
            PreparedStatement stmt = this.con.prepareStatement(update);
             stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getRG());
            stmt.setString(4, aluno.getCpf());
            stmt.setString(5, aluno.getSenha());
            stmt.setInt(6, aluno.getTurma());
            stmt.setInt(7, aluno.getId());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Aluno> lista(){
        ArrayList<Aluno> alunos = new ArrayList();
        try {
            String select = "SELECT * FROM aluno";
            PreparedStatement stmt = this.con.prepareStatement(select);
        
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("idALUNO"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setRG(rs.getString("rg"));
                aluno.setLogin(rs.getString("login"));
                aluno.setSenha(rs.getString("senha"));
                aluno.setTurma(rs.getInt("TURMA_idTURMA"));
                alunos.add(aluno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alunos;
    }
    
     public ArrayList<AlunoGenerico> listaGen(){
        ArrayList<Aluno> alunoList =  this.lista();
        ArrayList<AlunoGenerico> alunoGenericoList = new ArrayList();
        for(Aluno a: alunoList){
                alunoGenericoList.add(new AlunoGenerico(a));
            }
        return alunoGenericoList;
    }
}
