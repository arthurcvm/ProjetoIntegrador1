/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.CursoDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author arthurcvm
 */
public class TurmaGenerica {
    private SimpleStringProperty descricao;
    private SimpleIntegerProperty semestre;
    private SimpleStringProperty curso;
    private Turma turma;

    public TurmaGenerica(Turma turma) {
        this.turma = turma;
        this.descricao = new SimpleStringProperty(turma.getDescricao());
        this.semestre = new SimpleIntegerProperty(turma.getSemestre());
        this.curso = new SimpleStringProperty(new CursoDAO().get(turma.getCurso()).getNomeCurso());
    }

    public SimpleStringProperty getDescricao() {
        return descricao;
    }

    public SimpleIntegerProperty getSemestre() {
        return semestre;
    }

    public SimpleStringProperty getCurso() {
        return curso;
    }

    public Turma getTurma() {
        return turma;
    }
    
}
