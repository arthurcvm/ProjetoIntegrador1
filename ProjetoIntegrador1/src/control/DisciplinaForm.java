/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.stage.Stage;
import model.Disciplina;

/**
 *
 * @author arthurcvm
 */
public class DisciplinaForm {
    @FXML
    private JFXTextField nomeField;
    @FXML
    private JFXTextField abreviacaoField;
    @FXML
    private JFXTextField chField;
    @FXML
    private JFXTextField semestreField;
    @FXML
    private JFXTextField professorField;
    @FXML
    private ButtonBar botoes;
    
    private Disciplina disciplina;
    private Stage dialogStage;
    
    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente
     * após o arquivo fxml ter sido carregado.
     */
    @FXML
    public void initialize() {
        
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
        if(disciplina.getNome() != null){
            this.nomeField.setText(disciplina.getNome());
            this.abreviacaoField.setText(disciplina.getAbreviacao());
            this.chField.setText(String.valueOf(disciplina.getCH()));
            //this.semestreField;
            //this.professorField;
        }
    }
    
    public void setBlock(){
        this.nomeField.setEditable(false);
        this.chField.setEditable(false);
        this.abreviacaoField.setEditable(false);
        this.professorField.setEditable(false);
        this.semestreField.setEditable(false);
        botoes.setVisible(false);
        
        disciplina.setNome(null);
    }
    
    @FXML
    private void cancelar(){
        disciplina.setNome(null);
        
        this.dialogStage.close(); //fecha a janela
    }
    
    @FXML
    private void cadastrar(){
        this.disciplina.setNome(nomeField.getText());
        this.disciplina.setAbreviacao(abreviacaoField.getText());
        this.disciplina.setCH(Integer.valueOf(chField.getText()));
//        this.disciplina.setProfessor(0);
//        this.disciplina.setSemestre(0);
        
        this.dialogStage.close(); //fecha a janela
    }
}
