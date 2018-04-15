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
public class Professor extends Pessoa{
    private int IdPessoa;
    
    public Professor(String nome, String cpf, int IdPessoa) {
        this.cpf=cpf;
        this.nome=nome;
        this.IdPessoa = IdPessoa;
    }

    public int getIdPessoa() {
        return IdPessoa;
    }

    public void setIdPessoa(int IdPessoa) {
        this.IdPessoa = IdPessoa;
    }
    
}
