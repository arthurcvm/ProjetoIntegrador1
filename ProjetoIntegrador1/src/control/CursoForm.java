/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Curso;
import model.Faculdade;

/**
 *
 * @author arthurcvm
 */
public class CursoForm {
    @FXML
    private JFXTextField nomeField;
    @FXML
    private JFXComboBox<String> faculdadeBox = new JFXComboBox<String>();
    @FXML
    private JFXTextField qtdSemestresField;
    
    private ArrayList<Faculdade> faculdadeList = new ArrayList();
    
    private ArrayList<String> faculdadeNomes = new ArrayList();
    private ArrayList<Integer> faculdadeIds = new ArrayList();
    
    private Stage dialogStage;
    private Curso curso;
    
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

    public void setCurso(Curso curso) {
        this.curso = curso;
        if(curso.getNomeCurso() != null){
            this.nomeField.setText(curso.getNomeCurso());
            //this.faculdadeBox.setValue();
            this.qtdSemestresField.setText(String.valueOf(curso.getQtdSemestres()));
        }
    }

    public void setFaculdadeList(ArrayList<Faculdade> faculdadeList) {
        this.faculdadeList = faculdadeList;
        
        for(Faculdade f: faculdadeList){
            faculdadeNomes.add(f.getNome());
            faculdadeIds.add(f.getIdFaculdade());
        }
        
        faculdadeBox.setItems(FXCollections.observableArrayList(faculdadeNomes));
    }
    
    public void setBlock(){
        this.nomeField.setEditable(false);
        this.qtdSemestresField.setEditable(false);
        this.faculdadeBox.setEditable(false);
        
        curso.setNomeCurso(null);
    }
    
    @FXML
    private void cancelar(){
        curso.setNomeCurso(null);
        
        this.dialogStage.close(); //fecha a janela
    }
    
    @FXML
    private void cadastrar(){
        this.curso.setNomeCurso(nomeField.getText());
        
        int index = faculdadeBox.getSelectionModel().getSelectedIndex(); //Pega o index da seleção pra buscar no array de IDs
        int idFaculdade = faculdadeIds.get(index);
        
        this.curso.setFaculdade(idFaculdade);
        this.curso.setQtdSemestres(Integer.valueOf(qtdSemestresField.getText()));
        //this.aluno.setSenha(senhaField.getText())
        
        this.dialogStage.close(); //fecha a janela
    }
}
