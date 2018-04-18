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
import model.Aluno;

/**
 *
 * @author arthurcvm
 */
public class AlunoForm {
    @FXML
    private JFXTextField nomeField;
    @FXML
    private JFXTextField cpfField;
    @FXML
    private JFXTextField rgField;
    @FXML
    private JFXPasswordField senhaField;
    
    private Stage dialogStage;
    private Aluno aluno;
    
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

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
        if(aluno.getNome() != null){
            this.nomeField.setText(aluno.getNome());
            this.cpfField.setText(aluno.getCpf());
            this.rgField.setText(aluno.getRG());
            //this.senhaField.setText("");
        }
    }
    
    @FXML
    private void cancelar(){
        aluno.setNome(null);
        
        this.dialogStage.close(); //fecha a janela
    }
    
    @FXML
    private void cadastrar(){
        this.aluno.setNome(nomeField.getText());
        this.aluno.setCpf(cpfField.getText());
        this.aluno.setRG(rgField.getText());
        //this.aluno.setSenha(senhaField.getText())
        
        this.dialogStage.close(); //fecha a janela
    }
}
