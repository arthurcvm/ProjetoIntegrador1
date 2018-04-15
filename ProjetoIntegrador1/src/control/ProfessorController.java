/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author arthurcvm
 */
public class ProfessorController {
    private JFXTextField pesquisarField;
    private JFXComboBox faculdadeBox;
    private TableView professorTable;
    private TableColumn nomeColumn;
    private TableColumn cpfColumn;
    
    private BorderPane primaryStage;
    
    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente
     * após o arquivo fxml ter sido carregado.
     */
    @FXML
    public void initialize() {
        
    }

    public void setPrimaryStage(BorderPane primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    @FXML
    private void adicionar(){
        //Professor professor = new Professor();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ProfessorForm.fxml")); //Carrega o arquivo FXML
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage(); //Cria um novo Stage
            stage.initOwner(primaryStage.getScene().getWindow()); //Seta um stage pai
            stage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            stage.setScene(scene);
            
            ProfessorForm controller = loader.getController(); //Puxa a referência do controller instanciado
            //controller.setDialogStage(stage);
            //controller.setProfessor(professor);
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void excluir(){
        
    }
    
    @FXML
    private void editar(){
        
    }
    
    @FXML
    private void detalhes(){
        
    }
}
