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
import javafx.scene.control.ButtonBar;
import javafx.stage.Stage;
import model.Faculdade;
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
    @FXML
    private JFXComboBox<String> faculdadeBox = new JFXComboBox<String>();
    @FXML
    private ButtonBar botoes;
    
    private ArrayList<Faculdade> faculdadeList = new ArrayList();
    
    private ArrayList<String> faculdadeNomes = new ArrayList();
    
    private Stage dialogStage;
    private Professor professor;
    
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

    public void setProfessor(Professor professor) {
        this.professor = professor;
        if(professor.getNome() != null){
            this.nomeField.setText(professor.getNome());
            this.cpfField.setText(professor.getCpf());
            this.senhaField.setText(professor.getSenha());
        }
    }

    public void setFaculdadeList(ArrayList<Faculdade> faculdadeList) {
        this.faculdadeList = faculdadeList;
        
        for(Faculdade f: faculdadeList){
            faculdadeNomes.add(f.getNome());
        }
        
        faculdadeBox.setItems(FXCollections.observableArrayList(faculdadeNomes));
        
        if(professor.getNome() != null){
            for(int i=0; i < faculdadeList.size(); i++){
                if(faculdadeList.get(i).getIdFaculdade() == professor.getFaculdade()){
                    faculdadeBox.setValue(faculdadeNomes.get(i));
                }
            }
        }
    }
    
    public void setBlock(){
        this.nomeField.setEditable(false);
        this.cpfField.setEditable(false);
        this.senhaField.setEditable(false);
        botoes.setVisible(false);
        
        professor.setNome(null);
    }
    
    @FXML
    private void cancelar(){
        professor.setNome(null);
        
        this.dialogStage.close(); //fecha a janela
    }
    
    @FXML
    private void cadastrar(){
        this.professor.setNome(nomeField.getText());
        this.professor.setCpf(cpfField.getText());
        this.professor.setLogin(cpfField.getText());
        this.professor.setSenha(senhaField.getText());
        this.professor.setFaculdade(faculdadeList.get(faculdadeBox.getSelectionModel().getSelectedIndex()).getIdFaculdade());
        
        this.dialogStage.close(); //fecha a janela
    }
}
