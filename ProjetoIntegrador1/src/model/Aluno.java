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
    private int IdAluno;
    private String RG;
    
    public Aluno(String nome, String cpf, String RG, int IdAluno) {
        this.nome = nome;
        this.cpf = cpf;
        this.RG = RG;
        this.IdAluno = IdAluno;
    }

    public int getIdAluno() {
        return IdAluno;
    }

    public void setIdAluno(int IdAluno) {
        this.IdAluno = IdAluno;
    }
    
    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }
    
}
