/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author arthurcvm
 */
public class LembrarSenha {
    @FXML
    private TextField cpf;
    @FXML
    private TextField senha;
    
    private Stage stage;
    
    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente após
     * o arquivo fxml ter sido carregado.
     */
    @FXML
    public void initialize() {

    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
    private void lembrar(){
        
    }
}
