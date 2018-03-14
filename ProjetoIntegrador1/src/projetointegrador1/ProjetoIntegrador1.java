/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetointegrador1;

import control.Login;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author arthurcvm
 */
public class ProjetoIntegrador1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();
        showLogin(stage);
    }
    
    public void showLogin(Stage stageMaster){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml")); //Carrega o arquivo FXML
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage(); //Cria um novo Stage
            stage.setTitle("Entrar"); //Seta um título
            stage.initOwner(stageMaster); //Seta um stage pai
            Scene scene = new Scene(page);
            stage.setScene(scene);
            
            Login controller = loader.getController(); //Puxa a referência do controller instanciado
            controller.setStage(stage); //Seta stage para controle interno
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
