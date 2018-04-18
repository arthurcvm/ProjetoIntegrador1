/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Professor;
import model.ProfessorGenerico;

/**
 *
 * @author arthurcvm
 */
public class ProfessorController {
    private JFXTextField pesquisarField;
    private JFXComboBox faculdadeBox;
    private TableView<ProfessorGenerico> professorTable;
    private TableColumn<ProfessorGenerico, String> nomeColumn;
    private TableColumn<ProfessorGenerico, String> cpfColumn;
    
    private ArrayList<ProfessorGenerico> professorGenericoList = new ArrayList<ProfessorGenerico>();
    private ObservableList<ProfessorGenerico> genericos;
    
    private BorderPane primaryStage;
    
    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente
     * após o arquivo fxml ter sido carregado.
     */
    @FXML
    public void initialize() {
        nomeColumn.setCellValueFactory(cellData -> cellData.getValue().getNome());
        cpfColumn.setCellValueFactory(cellData -> cellData.getValue().getCpf());
        
    }

    public void setPrimaryStage(BorderPane primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setProfessorGenericoList(ArrayList<ProfessorGenerico> professorGenericoList) {
        this.professorGenericoList = professorGenericoList;
        this.genericos = FXCollections.observableArrayList(this.professorGenericoList);
        professorTable.setItems(genericos); 
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
            controller.setDialogStage(stage);
            //controller.setProfessor(professor);
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
            
            /*if(professor.getNome() != null){
                //salva no banco
            }*/
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void excluir(){
        Professor professor = professorTable.getSelectionModel().getSelectedItem().getProfessor();
        //Exclui no banco
    }
    
    @FXML
    private void editar(){
        Professor professor = professorTable.getSelectionModel().getSelectedItem().getProfessor();
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ProfessorForm.fxml")); //Carrega o arquivo FXML
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage(); //Cria um novo Stage
            stage.initOwner(primaryStage.getScene().getWindow()); //Seta um stage pai
            stage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            stage.setScene(scene);
            
            ProfessorForm controller = loader.getController(); //Puxa a referência do controller instanciado
            controller.setDialogStage(stage);
            controller.setProfessor(professor);
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
            
            if(professor.getNome() != null){
                //salva no banco
            }
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void detalhes(){
        Professor professor = professorTable.getSelectionModel().getSelectedItem().getProfessor();
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ProfessorForm.fxml")); //Carrega o arquivo FXML
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage(); //Cria um novo Stage
            stage.initOwner(primaryStage.getScene().getWindow()); //Seta um stage pai
            stage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            stage.setScene(scene);
            
            ProfessorForm controller = loader.getController(); //Puxa a referência do controller instanciado
            controller.setDialogStage(stage);
            controller.setProfessor(professor);
            controller.setBlock();
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
            
            if(professor.getNome() != null){
                //salva no banco
            }
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
