/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author csarp
 */
public class Aluno extends Pessoa{
    
    public Aluno(String nome, String cpf) {
        super(nome, cpf);
    }
    private String RG;

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }
    
}
