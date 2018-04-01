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
import model.Faculdade;

/**
 *
 * @author arthurcvm
 */
public class FaculdadeDAO {
    private Connection con;
    public FaculdadeDAO(){
        this.con = new ConnectionFacotory().getConnection();
    }
    public void insert(Faculdade faculdade) throws SQLException{
        String insert = "INSERT INTO faculdade (nome, cnpj, rua, numero, bairro, convenio, cidade, estado)";
                insert += " VALUES(?,?,?,?,?,?,?,?)";
                
        PreparedStatement stmt = this.con.prepareStatement(insert);
        stmt.setString(1, faculdade.getNome());
        stmt.setString(2, faculdade.getCNPJ());
        stmt.setString(3, faculdade.getRua());
        stmt.setInt(4, faculdade.getNumero());
        stmt.setString(5, faculdade.getBairro());
        stmt.setString(6, faculdade.getConvenio());
        stmt.setString(7, faculdade.getCidade());
        stmt.setString(8, faculdade.getEstado());
        
        try {
            stmt.execute();
            System.out.println("Gravado");
        } catch (SQLException ex) {
            Logger.getLogger(FaculdadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            stmt.close();
            this.con.close();
        }
    }
    public void delete(int id) throws SQLException{
        String delete = "DELETE FROM faculdade WHERE ";
        delete+="id=?";
        
       try {
            PreparedStatement stmt = this.con.prepareStatement(delete);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
            this.con.close();
            System.out.println("Deletado");
        } catch (SQLException ex) {
            Logger.getLogger(FaculdadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void lista() throws SQLException{
        String select = "SELECT * FROM faculdade";
        PreparedStatement stmt = this.con.prepareStatement(select);
        try {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome");
                String cnpj = rs.getString("cnpj");
                String rua = rs.getString("rua");
                int numero = rs.getInt("numero");
                String bairro = rs.getString("bairro");
                String convenio = rs.getString("convenio");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                System.out.println("Nome: " + nome +" | CNPJ: " + cnpj + " | "
                        + "Rua: " + rua  + " | Número: " + numero +" | Bairro: "
                        + bairro + " | Convênio: " + convenio  + " | Cidade: " + cidade + " | Estado: " + estado  + " |");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FaculdadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            stmt.close();
            this.con.close();
        }  
    }
    public void buscadado(String dado) throws SQLException{
        String pesq = "SELECT nome, cnpj, rua, numero, bairro, convenio, cidade, estado FROM faculdade WHERE nome LIKE '%"+dado+"%'";
        PreparedStatement stmt = this.con.prepareStatement(pesq);
        
        try {    
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome");
                String cnpj = rs.getString("cnpj");
                String rua = rs.getString("rua");
                int numero = rs.getInt("numero");
                String bairro = rs.getString("bairro");
                String convenio = rs.getString("convenio");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                System.out.println("Nome: " + nome +" | CNPJ: " + cnpj + " | "
                        + "Rua: " + rua  + " | Número: " + numero +" | Bairro: "
                        + bairro + " | Convênio: " + convenio  + " | Cidade: " + cidade + " | Estado: " + estado  + " |");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FaculdadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            stmt.close();
            this.con.close();
        }           
    }
}
