/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.AlunoDAO;
import DAO.TurmaDAO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.sql.SQLException;
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
import model.Aluno;
import model.AlunoGenerico;
import model.Faculdade;
import model.Turma;

/**
 *
 * @author arthurcvm
 */
public class AlunoController {
    @FXML
    private JFXTextField pesquisarField;
    @FXML
    private JFXComboBox faculdadeBox;
    @FXML
    private TableView<AlunoGenerico> alunoTable;
    @FXML
    private TableColumn<AlunoGenerico, String> nomeColumn;
    @FXML
    private TableColumn<AlunoGenerico, String> cpfColumn;
    @FXML
    private TableColumn<AlunoGenerico, String> rgColumn;
    
    private ArrayList<AlunoGenerico> alunoGenericoList = new ArrayList<AlunoGenerico>();
    private ObservableList<AlunoGenerico> genericos;
    
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
        rgColumn.setCellValueFactory(cellData -> cellData.getValue().getRg());
        
        faculdadeBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                int index = faculdadeBox.getSelectionModel().getSelectedIndex(); //Pega o index da seleção pra buscar no array de IDs
                int faculdadeId = faculdadeIds.get(index);
            }
            
            //Aqui filtra os alunos pelo id da faculdade e retorna um arraylist atualizado
        });
    }

    public void setPrimaryStage(BorderPane primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setAlunoGenericoList(ArrayList<AlunoGenerico> alunoGenericoList) {
        this.alunoGenericoList = alunoGenericoList;
        this.genericos = FXCollections.observableArrayList(this.alunoGenericoList);
        alunoTable.setItems(genericos); 
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
    private void adicionar() throws SQLException{
        Aluno aluno = new Aluno();
        ArrayList<Turma> turmaList = new TurmaDAO().lista();
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
            controller.setTurmaList(turmaList);
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
            
            if(aluno.getNome() != null){
                AlunoDAO dao = new AlunoDAO();
                dao.insert(aluno);
            }
            
            recarregar();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void excluir(){
        Aluno aluno = alunoTable.getSelectionModel().getSelectedItem().getAluno();
        AlunoDAO dao = new AlunoDAO();
        dao.delete(aluno.getId());
    }
    
    @FXML
    private void editar(){
      Aluno aluno = alunoTable.getSelectionModel().getSelectedItem().getAluno();
      ArrayList<Turma> turmaList = new TurmaDAO().lista();
      
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
            controller.setTurmaList(turmaList);
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
            
            if(aluno.getNome() != null){
                AlunoDAO dao = new AlunoDAO();
                dao.edit(aluno);
            }
            
            recarregar();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void detalhes(){
        Aluno aluno = alunoTable.getSelectionModel().getSelectedItem().getAluno();
        ArrayList<Turma> turmaList = new TurmaDAO().lista();
        
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
            controller.setTurmaList(turmaList);
            controller.setBlock();
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void recarregar() {
        AlunoDAO dao = new AlunoDAO();
        this.alunoGenericoList = dao.listaGen();
        this.genericos = FXCollections.observableArrayList(this.alunoGenericoList);
        alunoTable.setItems(genericos); 
    }
}
