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
public class ProfessorGenerico {
    private SimpleStringProperty nome;
    private SimpleStringProperty cpf;
    private Professor professor;

    public ProfessorGenerico(Professor professor) {
        this.professor = professor;
        this.nome = new SimpleStringProperty(professor.getNome());
        this.cpf = new SimpleStringProperty(professor.getCpf());
    }

    public SimpleStringProperty getNome() {
        return nome;
    }

    public SimpleStringProperty getCpf() {
        return cpf;
    }

    public Professor getProfessor() {
        return professor;
    }
}
