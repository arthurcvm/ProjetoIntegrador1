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
import model.Aluno;
import model.AlunoGenerico;

/**
 *
 * @author arthurcvm
 */
public class AlunoController {
    private JFXTextField pesquisarField;
    private JFXComboBox faculdadeBox;
    private TableView<AlunoGenerico> alunoTable;
    private TableColumn<AlunoGenerico, String> nomeColumn;
    private TableColumn<AlunoGenerico, String> cpfColumn;
    private TableColumn<AlunoGenerico, String> rgColumn;
    
    private ArrayList<AlunoGenerico> alunoGenericoList = new ArrayList<AlunoGenerico>();
    private ObservableList<AlunoGenerico> genericos;
    
    private BorderPane primaryStage;
    
    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente
     * após o arquivo fxml ter sido carregado.
     */
    @FXML
    public void initialize() {
        nomeColumn.setCellValueFactory(cellData -> cellData.getValue().getNome());
        cpfColumn.setCellValueFactory(cellData -> cellData.getValue().getCpf());
        rgColumn.setCellValueFactory(cellData -> cellData.getValue().getRg());
    }

    public void setPrimaryStage(BorderPane primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setAlunoGenericoList(ArrayList<AlunoGenerico> alunoGenericoList) {
        this.alunoGenericoList = alunoGenericoList;
        this.genericos = FXCollections.observableArrayList(this.alunoGenericoList);
        alunoTable.setItems(genericos); 
    }
    
    @FXML
    private void adicionar(){
        //Aluno aluno = new Aluno();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AlunoForm.fxml")); //Carrega o arquivo FXML
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage(); //Cria um novo Stage
            stage.initOwner(primaryStage.getScene().getWindow()); //Seta um stage pai
            stage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            stage.setScene(scene);
            
            AlunoForm controller = loader.getController(); //Puxa a referência do controller instanciado
            controller.setDialogStage(stage);
            //controller.setAluno(aluno);
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
            
            /*if(aluno.getNome != null){
                //salva no banco
            }*/
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void excluir(){
        Aluno aluno = alunoTable.getSelectionModel().getSelectedItem().getAluno();
        //Exclui no banco
    }
    
    @FXML
    private void editar(){
      Aluno aluno = alunoTable.getSelectionModel().getSelectedItem().getAluno();
      
      try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AlunoForm.fxml")); //Carrega o arquivo FXML
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage(); //Cria um novo Stage
            stage.initOwner(primaryStage.getScene().getWindow()); //Seta um stage pai
            stage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            stage.setScene(scene);
            
            AlunoForm controller = loader.getController(); //Puxa a referência do controller instanciado
            controller.setDialogStage(stage);
            controller.setAluno(aluno);
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
            
            /*if(aluno.getNome != null){
                //salva no banco
            }*/
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void detalhes(){
        Aluno aluno = alunoTable.getSelectionModel().getSelectedItem().getAluno();
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AlunoForm.fxml")); //Carrega o arquivo FXML
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage(); //Cria um novo Stage
            stage.initOwner(primaryStage.getScene().getWindow()); //Seta um stage pai
            stage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            stage.setScene(scene);
            
            AlunoForm controller = loader.getController(); //Puxa a referência do controller instanciado
            controller.setDialogStage(stage);
            controller.setAluno(aluno);
            controller.setBlock();
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
