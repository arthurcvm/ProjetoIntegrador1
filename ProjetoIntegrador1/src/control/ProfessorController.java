/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.ProfessorDAO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import model.Faculdade;
import model.Professor;
import model.ProfessorGenerico;

/**
 *
 * @author arthurcvm
 */
public class ProfessorController {
    @FXML
    private JFXTextField pesquisarField;
    @FXML
    private JFXComboBox faculdadeBox;
    @FXML
    private TableView<ProfessorGenerico> professorTable;
    @FXML
    private TableColumn<ProfessorGenerico, String> nomeColumn;
    @FXML
    private TableColumn<ProfessorGenerico, String> cpfColumn;
    
    private ArrayList<ProfessorGenerico> professorGenericoList = new ArrayList<ProfessorGenerico>();
    private ObservableList<ProfessorGenerico> genericos;
    
    private ArrayList<Faculdade> faculdadeList = new ArrayList();
    
    private ArrayList<String> faculdadeNomes = new ArrayList();
    private ArrayList<Integer> faculdadeIds = new ArrayList();
    
    private BorderPane primaryStage;
    
    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente
     * após o arquivo fxml ter sido carregado.
     */
    @FXML
    public void initialize() {
        nomeColumn.setCellValueFactory(cellData -> cellData.getValue().getNome());
        cpfColumn.setCellValueFactory(cellData -> cellData.getValue().getCpf());
        
        faculdadeBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                int index = faculdadeBox.getSelectionModel().getSelectedIndex(); //Pega o index da seleção pra buscar no array de IDs
                int faculdadeId = faculdadeIds.get(index);
            }
            
            //Aqui filtra os professores pelo id da faculdade e retorna um arraylist atualizado
        });
        
    }

    public void setPrimaryStage(BorderPane primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setProfessorGenericoList(ArrayList<ProfessorGenerico> professorGenericoList) {
        this.professorGenericoList = professorGenericoList;
        this.genericos = FXCollections.observableArrayList(this.professorGenericoList);
        professorTable.setItems(genericos); 
    }

    public void setFaculdadeList(ArrayList<Faculdade> faculdadeList) {
        this.faculdadeList = faculdadeList;
        
        for(Faculdade f: faculdadeList){
            faculdadeNomes.add(f.getNome());
            faculdadeIds.add(f.getIdFaculdade());
        }
        
        faculdadeBox.setItems(FXCollections.observableArrayList(faculdadeNomes));
    }
    
    @FXML
    private void adicionar(){
        Professor professor = new Professor();
        
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
                ProfessorDAO dao = new ProfessorDAO();
                dao.insert(professor);
            }
        
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
    
    public void recarregar() {
        ProfessorDAO dao = new ProfessorDAO();
        this.professorGenericoList = dao.listaGen();
        this.genericos = FXCollections.observableArrayList(this.professorGenericoList);
        professorTable.setItems(genericos); 
    }
}
