/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Aluno;
import model.Turma;

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
    @FXML
    private JFXComboBox turmaBox;
    
    private Stage dialogStage;
    private Aluno aluno;
    
    private ArrayList<Turma> turmaList = new ArrayList();
    private ArrayList<String> turmaNomes = new ArrayList();
    
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
            this.senhaField.setText(aluno.getSenha());
        }
    }

    public void setTurmaList(ArrayList<Turma> turmaList) {
        this.turmaList = turmaList;
        
        for(Turma t: turmaList){
            turmaNomes.add(t.getDescricao());
        }
        
        turmaBox.setItems(FXCollections.observableArrayList(turmaNomes));
        
        if(aluno.getNome() != null){
            for(int i=0; i < turmaList.size(); i++){
                if(turmaList.get(i).getIdTurma() == aluno.getTurma()){
                    turmaBox.setValue(turmaNomes.get(i));
                }
            }
        }
    }
    
    public void setBlock(){
        this.nomeField.setEditable(false);
        this.cpfField.setEditable(false);
        this.rgField.setEditable(false);
        this.senhaField.setEditable(false);
        aluno.setNome(null);
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
        this.aluno.setSenha(senhaField.getText());
        this.aluno.setTurma(turmaList.get(turmaBox.getSelectionModel().getSelectedIndex()).getIdTurma());
        
        this.dialogStage.close(); //fecha a janela
    }
}
