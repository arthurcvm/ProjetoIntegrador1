/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Faculdade;

/**
 *
 * @author arthurcvm
 */
public class FaculdadeForm {
    @FXML
    private JFXTextField cnpjField;
    @FXML
    private JFXTextField nomeField;
    @FXML
    private JFXTextField logradouroField;
    @FXML
    private JFXTextField cidadeField;
    @FXML
    private JFXTextField bairroField;
    @FXML
    private JFXTextField numeroField;
    @FXML
    private JFXComboBox<String> ufBox = new JFXComboBox<String>();
    @FXML
    private JFXComboBox<String> convenioBox = new JFXComboBox<String>();
    
    private Stage dialogStage;
    private Faculdade faculdade;
    
    private final String estados[] = {"AC", "AL", "AP", "AM", "BA", "CE",
        "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR",
        "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "TO"};
    
    private final String convenioList[] = {"Aprovado", "Reprovado"};
    
    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente
     * após o arquivo fxml ter sido carregado.
     */
    @FXML
    public void initialize() {        
        // Carregando lista de estados na Box.
        ufBox.setItems(FXCollections.observableArrayList(estados));
        convenioBox.setItems(FXCollections.observableArrayList(convenioList));
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setFaculdade(Faculdade faculdade) {
        this.faculdade = faculdade;
        if(faculdade.getNome() != null){
            this.nomeField.setText(faculdade.getNome());
            this.cnpjField.setText(faculdade.getCNPJ());
            this.logradouroField.setText(faculdade.getRua());
            this.cidadeField.setText(faculdade.getCidade());
            this.bairroField.setText(faculdade.getBairro());
            this.numeroField.setText(String.valueOf(faculdade.getNumero()));
            //this.ufBox.setValue(faculdade.getEstado());
            //this.convenioBox.setValue(faculdade.getConvenio());
        }
    }
    
    @FXML
    private void cancelar(){
        faculdade.setCNPJ(null);
        
        this.dialogStage.close(); //fecha a janela
    }
    
    @FXML
    private void cadastrar(){
        this.faculdade.setCNPJ(cnpjField.getText());
        this.faculdade.setNome(nomeField.getText());
        this.faculdade.setBairro(bairroField.getText());
        this.faculdade.setConvenio(convenioBox.getSelectionModel().getSelectedItem());
        this.faculdade.setNumero(Integer.parseInt(numeroField.getText()));
        this.faculdade.setRua(logradouroField.getText());
        this.faculdade.setCidade(cidadeField.getText());
        this.faculdade.setEstado(ufBox.getSelectionModel().getSelectedItem());
        
        this.dialogStage.close(); //fecha a janela
    }
}
