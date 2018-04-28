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
public class CursoGenerico {
    private SimpleStringProperty nome;
    private SimpleIntegerProperty semestres;
    private Curso curso;

    public CursoGenerico(Curso curso) {
        this.curso = curso;
        this.nome = new SimpleStringProperty(curso.getNomeCurso());
        this.semestres = new SimpleIntegerProperty(curso.getQtdSemestres());
    }

    public SimpleStringProperty getNome() {
        return nome;
    }

    public SimpleIntegerProperty getSemestres() {
        return semestres;
    }

    public Curso getCurso() {
        return curso;
    }
}
