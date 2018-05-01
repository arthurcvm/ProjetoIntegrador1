/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author arthurcvm
 */
public class DisciplinaGenerica {
    private SimpleStringProperty nome;
    private SimpleStringProperty abreviacao;
    private SimpleIntegerProperty ch;
    private SimpleIntegerProperty semestre;
    private Disciplina disciplina;

    public DisciplinaGenerica(Disciplina disciplina) {
        this.disciplina = disciplina;
        this.nome = new SimpleStringProperty(disciplina.getNome());
        this.abreviacao = new SimpleStringProperty(disciplina.getAbreviacao());
        this.ch = new SimpleIntegerProperty(disciplina.getCH());
        this.semestre = new SimpleIntegerProperty(disciplina.getSemestre());
    }

    public SimpleStringProperty getNome() {
        return nome;
    }

    public SimpleStringProperty getAbreviacao() {
        return abreviacao;
    }

    public SimpleIntegerProperty getCh() {
        return ch;
    }

    public SimpleIntegerProperty getSemestre() {
        return semestre;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
    
}
