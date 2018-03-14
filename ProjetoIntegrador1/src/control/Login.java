/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author arthurcvm
 */
public class Login {
    @FXML
    private TextField usuario;
    @FXML
    private PasswordField senha;
    
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
    private void login(){
        
        
        stage.close();
    }
    
    @FXML
    private void recuperarSenha(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LembrarSenha.fxml")); //Carrega o arquivo FXML
            AnchorPane page = (AnchorPane) loader.load();
            Stage DialogStage = new Stage(); //Cria um novo Stage
            DialogStage.setTitle("Lembrar Senha"); //Seta um título
            DialogStage.initModality(Modality.WINDOW_MODAL); //Bloqueia a janela pai
            DialogStage.initOwner(stage); //Seta um stage pai
            Scene scene = new Scene(page);
            DialogStage.setScene(scene);
            
            LembrarSenha controller = loader.getController(); //Puxa a referência do controller instanciado
            controller.setStage(DialogStage); //Seta stage para controle interno
            
            DialogStage.showAndWait(); //Exibe janela e pausa esta thread
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
