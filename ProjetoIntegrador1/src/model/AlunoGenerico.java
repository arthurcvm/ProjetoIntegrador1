/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author arthurcvm
 */
public class AlunoGenerico {
    private SimpleStringProperty nome;
    private SimpleStringProperty cpf;
    private SimpleStringProperty rg;
    private Aluno aluno;

    public AlunoGenerico(Aluno aluno) {
        this.aluno = aluno;
        this.nome = new SimpleStringProperty(aluno.getNome());
        this.cpf = new SimpleStringProperty(aluno.getCpf());
        this.rg = new SimpleStringProperty(aluno.getRG());
    }

    public SimpleStringProperty getNome() {
        return nome;
    }

    public SimpleStringProperty getCpf() {
        return cpf;
    }

    public SimpleStringProperty getRg() {
        return rg;
    }

    public Aluno getAluno() {
        return aluno;
    }
    
}
