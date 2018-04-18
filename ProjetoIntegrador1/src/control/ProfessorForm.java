/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Professor;

/**
 *
 * @author arthurcvm
 */
public class ProfessorForm {
    @FXML
    private JFXTextField nomeField;
    @FXML
    private JFXTextField cpfField;
    @FXML
    private JFXPasswordField senhaField;
    
    private Stage dialogStage;
    private Professor professor;
    
    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente
     * após o arquivo fxml ter sido carregado.
     */
    @FXML
    public void initialize() {        
        // Carregando lista de estados na Box.
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
        if(professor.getNome() != null){
            this.nomeField.setText(professor.getNome());
            this.cpfField.setText(professor.getCpf());
            //this.senhaField.setText("");
        }
    }
    
    public void setBlock(){
        this.nomeField.setEditable(false);
        this.cpfField.setEditable(false);
        this.senhaField.setEditable(false);
        
        professor.setNome(null);
    }
    
    @FXML
    private void cancelar(){
        //curso.setNome(null);
        
        this.dialogStage.close(); //fecha a janela
    }
    
    @FXML
    private void cadastrar(){
        this.professor.setNome(nomeField.getText());
        this.professor.setCpf(cpfField.getText());
        //this.aluno.setSenha(senhaField.getText())
        
        this.dialogStage.close(); //fecha a janela
    }
}
