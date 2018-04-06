/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Mateus
 */
public class Turma {
    private int idTurma;
    private String descricao;
    private int semestre;
    private int curso;
    
    public Turma(){
        
    }

    public Turma(String descricao, int semestre, int curso){
        this.descricao = descricao;
        this.semestre = semestre;
        this.curso = curso;
    }
        
    public Turma(int idTurma, String descricao, int semestre, int curso){
        this.idTurma = idTurma;
        this.descricao = descricao;
        this.semestre = semestre;
        this.curso = curso;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }
    
    
}
