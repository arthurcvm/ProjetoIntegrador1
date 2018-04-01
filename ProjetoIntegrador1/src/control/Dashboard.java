/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author arthurcvm
 */
public class Dashboard {
    private BorderPane painel;

    public void setPainel(BorderPane painel) {
        this.painel = painel;
    }
    
    @FXML
    private void faculdades(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Faculdade.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            
            this.painel.setRight(pane);
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void professores(){
        
    }
    
    @FXML
    private void alunos(){
        
    }
    @FXML
    private void cursos(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Curso.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            
            this.painel.setRight(pane);
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void turmas(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Turma.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            
            this.painel.setRight(pane);
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void disciplinas(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Disciplina.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            
            this.painel.setRight(pane);
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
