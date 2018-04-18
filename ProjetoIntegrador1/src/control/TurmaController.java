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
import model.Turma;
import model.TurmaGenerica;

/**
 *
 * @author arthurcvm
 */
public class TurmaController {
    private JFXTextField pesquisarField;
    private JFXComboBox faculdadeBox;
    private TableView<TurmaGenerica> turmaTable;
    private TableColumn<TurmaGenerica, String> descricaoColumn;
    private TableColumn<TurmaGenerica, String> cursoColumn;
    private TableColumn<TurmaGenerica, Integer> chColumn;
    private TableColumn<TurmaGenerica, Integer> semestreColumn;
    
    private ArrayList<TurmaGenerica> turmaGenericaList = new ArrayList<TurmaGenerica>();
    private ObservableList<TurmaGenerica> genericas;
    
    private BorderPane primaryStage;
    
    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente
     * após o arquivo fxml ter sido carregado.
     */
    @FXML
    public void initialize() {
        descricaoColumn.setCellValueFactory(cellData -> cellData.getValue().getDescricao());
        cursoColumn.setCellValueFactory(cellData -> cellData.getValue().getCurso());
        //chColumn.setCellValueFactory(cellData -> cellData.getValue().getCh());
        semestreColumn.setCellValueFactory(cellData -> cellData.getValue().getSemestre().asObject());
    }

    public void setPrimaryStage(BorderPane primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setTurmaGenericaList(ArrayList<TurmaGenerica> turmaGenericaList) {
        this.turmaGenericaList = turmaGenericaList;
        this.genericas = FXCollections.observableArrayList(this.turmaGenericaList);
        turmaTable.setItems(genericas);
    }
    
    @FXML
    private void adicionar(){
        Turma turma = new Turma();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TurmaForm.fxml")); //Carrega o arquivo FXML
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage(); //Cria um novo Stage
            stage.initOwner(primaryStage.getScene().getWindow()); //Seta um stage pai
            stage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            stage.setScene(scene);
            
            TurmaForm controller = loader.getController(); //Puxa a referência do controller instanciado
            controller.setDialogStage(stage);
            controller.setTurma(turma);
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void excluir(){
        Turma turma = turmaTable.getSelectionModel().getSelectedItem().getTurma();
        //Exclui no banco
    }
    
    @FXML
    private void editar(){
        Turma turma = turmaTable.getSelectionModel().getSelectedItem().getTurma();
        //Edita no banco
    }
    
    @FXML
    private void detalhes(){
        Turma turma = turmaTable.getSelectionModel().getSelectedItem().getTurma();
        //Abre a janela de cadastro bloqueada
    }
}
