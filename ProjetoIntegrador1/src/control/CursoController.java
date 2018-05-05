/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.CursoDAO;
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
import model.Curso;
import model.CursoGenerico;
import model.Faculdade;

/**
 *
 * @author arthurcvm
 */
public class CursoController {
    @FXML
    private JFXTextField pesquisarField;
    @FXML
    private JFXComboBox<String> faculdadeBox = new JFXComboBox<String>();
    @FXML
    private TableView<CursoGenerico> cursoTable;
    @FXML
    private TableColumn<CursoGenerico, String> cursoColumn;
    @FXML
    private TableColumn<CursoGenerico, Integer> semestreColumn;
    
    private ArrayList<CursoGenerico> cursoGenericoList = new ArrayList<CursoGenerico>();
    private ObservableList<CursoGenerico> genericos;
    
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
        cursoColumn.setCellValueFactory(cellData -> cellData.getValue().getNome());
        semestreColumn.setCellValueFactory(cellData -> cellData.getValue().getSemestres().asObject());
        
        faculdadeBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                int index = faculdadeBox.getSelectionModel().getSelectedIndex(); //Pega o index da seleção pra buscar no array de IDs
                int faculdadeId = faculdadeIds.get(index); //pega o id da faculdade
            }
            
            //Aqui filtra os cursos pelo id da faculdade e retorna um arraylist atualizado
        });
        
    }

    public void setPrimaryStage(BorderPane primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setCursoGenericoList(ArrayList<CursoGenerico> cursoGenericoList) {
        this.cursoGenericoList = cursoGenericoList;
        this.genericos = FXCollections.observableArrayList(this.cursoGenericoList);
        cursoTable.setItems(genericos); 
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
            controller.setFaculdadeList(faculdadeList);
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
            
            if(curso.getNomeCurso() != null){
                CursoDAO dao = new CursoDAO();
                dao.insert(curso);
            }
            recarregar();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        recarregar();
    }
    
    @FXML
    private void excluir(){
        Curso curso = cursoTable.getSelectionModel().getSelectedItem().getCurso();
        CursoDAO dao = new CursoDAO();
        dao.delete(curso.getIdCurso());
        recarregar();
    }
    
    @FXML
    private void editar(){
        Curso curso = cursoTable.getSelectionModel().getSelectedItem().getCurso();
        
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
            controller.setFaculdadeList(faculdadeList);
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
            
            if(curso.getNomeCurso() != null){
                CursoDAO dao = new CursoDAO();
                dao.edit(curso);
                recarregar();
            }
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void detalhes(){
        Curso curso = cursoTable.getSelectionModel().getSelectedItem().getCurso();
        
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
            controller.setFaculdadeList(faculdadeList);
            controller.setBlock();
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public void recarregar() {
        CursoDAO dao = new CursoDAO();
        this.cursoGenericoList = dao.listaGen();
        this.genericos = FXCollections.observableArrayList(this.cursoGenericoList);
        cursoTable.setItems(genericos); 
    }
}
