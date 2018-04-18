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
import model.Curso;
import model.CursoGenerico;

/**
 *
 * @author arthurcvm
 */
public class CursoController {
    private JFXTextField pesquisarField;
    private JFXComboBox faculdadeBox;
    private TableView<CursoGenerico> cursoTable;
    private TableColumn<CursoGenerico, String> cursoColumn;
    private TableColumn<CursoGenerico, Integer> semestreColumn;
    
    private ArrayList<CursoGenerico> cursoGenericoList = new ArrayList<CursoGenerico>();
    private ObservableList<CursoGenerico> genericos;
    
    private BorderPane primaryStage;
    
    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente
     * após o arquivo fxml ter sido carregado.
     */
    @FXML
    public void initialize() {
        cursoColumn.setCellValueFactory(cellData -> cellData.getValue().getNome());
        semestreColumn.setCellValueFactory(cellData -> cellData.getValue().getSemestres().asObject());
    }

    public void setPrimaryStage(BorderPane primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setCursoGenericoList(ArrayList<CursoGenerico> cursoGenericoList) {
        this.cursoGenericoList = cursoGenericoList;
        this.genericos = FXCollections.observableArrayList(this.cursoGenericoList);
        cursoTable.setItems(genericos); 
    }
    
    @FXML
    private void adicionar(){
        Curso curso = new Curso();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CursoForm.fxml")); //Carrega o arquivo FXML
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage(); //Cria um novo Stage
            stage.initOwner(primaryStage.getScene().getWindow()); //Seta um stage pai
            stage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            stage.setScene(scene);
            
            CursoForm controller = loader.getController(); //Puxa a referência do controller instanciado
            controller.setDialogStage(stage);
            controller.setCurso(curso);
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void excluir(){
        Curso curso = cursoTable.getSelectionModel().getSelectedItem().getCurso();
        //Exclui no banco
    }
    
    @FXML
    private void editar(){
        Curso curso = cursoTable.getSelectionModel().getSelectedItem().getCurso();
        //Edita no banco
    }
    
    @FXML
    private void detalhes(){
        Curso curso = cursoTable.getSelectionModel().getSelectedItem().getCurso();
        //Abre a janela de cadastro bloqueada
        
    }
}
