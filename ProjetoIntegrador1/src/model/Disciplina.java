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
public class Disciplina {
    private int idDisciplina;
    private String nome;
    private String abreviacao;
    private int CH;
    private int curso ;
    private int semestre;
    private int professor;
    
    public Disciplina(){
        
    }
    
    public Disciplina(String nome, String abreviacao, int CH, int semestre, int professor){
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.CH = CH;
        this.semestre = semestre;
        this.professor = professor;
    }
    
    public Disciplina(int idDisciplina, String nome, String abreviacao, int CH, int semestre, int professor){
        this.idDisciplina = idDisciplina;
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.CH = CH;
        this.semestre = semestre;
        this.professor = professor;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public int getCH() {
        return CH;
    }

    public void setCH(int CH) {
        this.CH = CH;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }
    
    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getProfessor() {
        return professor;
    }

    public void setProfessor(int professor) {
        this.professor = professor;
    }
    
    
}