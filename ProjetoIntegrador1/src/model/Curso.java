/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Junior Soares
 */
public class Curso {
    private int idCurso;
    private int faculdade;
    private String nomeCurso;
    private int tempoCurso;
    
    public Curso() {
        
    }
    
     public Curso(int idCurso, int faculdade, String nomeCurso, int tempoCurso) {
         this.idCurso = idCurso;
         this.faculdade = faculdade;
         this.nomeCurso = nomeCurso;
         this.tempoCurso = tempoCurso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(int faculdade) {
        this.faculdade = faculdade;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getTempoCurso() {
        return tempoCurso;
    }

    public void setTempoCurso(int tempoCurso) {
        this.tempoCurso = tempoCurso;
    }
     
    
}
