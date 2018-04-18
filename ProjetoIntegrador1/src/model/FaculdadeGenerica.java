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
public class FaculdadeGenerica {
    private SimpleStringProperty nome;
    private Faculdade faculdade;

    public FaculdadeGenerica(Faculdade faculdade) {
        this.faculdade = faculdade;
        this.nome = new SimpleStringProperty(faculdade.getNome());
    }

    public SimpleStringProperty getNome() {
        return nome;
    }

    public Faculdade getFaculdade() {
        return faculdade;
    }
}
