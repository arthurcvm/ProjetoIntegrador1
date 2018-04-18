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
import model.Disciplina;
import model.DisciplinaGenerica;

/**
 *
 * @author arthurcvm
 */
public class DisciplinaController {
    private JFXTextField pesquisarField;
    private JFXComboBox faculdadeBox;
    private TableView<DisciplinaGenerica> disciplinaTable;
    private TableColumn<DisciplinaGenerica, String> disciplinaColumn;
    private TableColumn<DisciplinaGenerica, String> abreviacaoColumn;
    private TableColumn<DisciplinaGenerica, Integer> chColumn;
    private TableColumn<DisciplinaGenerica, Integer> semestreColumn;
    
    private ArrayList<DisciplinaGenerica> disciplinaGenericaList = new ArrayList<DisciplinaGenerica>();
    private ObservableList<DisciplinaGenerica> genericas;
    
    private BorderPane primaryStage;
    
    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente
     * após o arquivo fxml ter sido carregado.
     */
    @FXML
    public void initialize() {
        disciplinaColumn.setCellValueFactory(cellData -> cellData.getValue().getNome());
        abreviacaoColumn.setCellValueFactory(cellData -> cellData.getValue().getAbreviacao());
        chColumn.setCellValueFactory(cellData -> cellData.getValue().getCh().asObject());
        semestreColumn.setCellValueFactory(cellData -> cellData.getValue().getSemestre().asObject());
    }

    public void setPrimaryStage(BorderPane primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setDisciplinaGenericaList(ArrayList<DisciplinaGenerica> disciplinaGenericaList) {
        this.disciplinaGenericaList = disciplinaGenericaList;
        this.genericas = FXCollections.observableArrayList(this.disciplinaGenericaList);
        disciplinaTable.setItems(genericas); 
    }
    
    @FXML
    private void adicionar(){
        Disciplina disciplina = new Disciplina();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DisciplinaForm.fxml")); //Carrega o arquivo FXML
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage(); //Cria um novo Stage
            stage.initOwner(primaryStage.getScene().getWindow()); //Seta um stage pai
            stage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            stage.setScene(scene);
            
            DisciplinaForm controller = loader.getController(); //Puxa a referência do controller instanciado
            controller.setDialogStage(stage);
            controller.setDisciplina(disciplina);
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
            
            if(disciplina.getNome() != null){
                //Salva no banco
            }
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void excluir(){
        Disciplina disciplina = disciplinaTable.getSelectionModel().getSelectedItem().getDisciplina();
        //Exclui no banco
    }
    
    @FXML
    private void editar(){
        Disciplina disciplina = disciplinaTable.getSelectionModel().getSelectedItem().getDisciplina();
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DisciplinaForm.fxml")); //Carrega o arquivo FXML
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage(); //Cria um novo Stage
            stage.initOwner(primaryStage.getScene().getWindow()); //Seta um stage pai
            stage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            stage.setScene(scene);
            
            DisciplinaForm controller = loader.getController(); //Puxa a referência do controller instanciado
            controller.setDialogStage(stage);
            controller.setDisciplina(disciplina);
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
            
            if(disciplina.getNome() != null){
                //Salva no banco
            }
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void detalhes(){
        Disciplina disciplina = disciplinaTable.getSelectionModel().getSelectedItem().getDisciplina();
        
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DisciplinaForm.fxml")); //Carrega o arquivo FXML
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage(); //Cria um novo Stage
            stage.initOwner(primaryStage.getScene().getWindow()); //Seta um stage pai
            stage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            stage.setScene(scene);
            
            DisciplinaForm controller = loader.getController(); //Puxa a referência do controller instanciado
            controller.setDialogStage(stage);
            controller.setDisciplina(disciplina);
            controller.setBlock();
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
