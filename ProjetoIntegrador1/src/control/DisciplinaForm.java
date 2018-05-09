/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.CursoDAO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.stage.Stage;
import model.Curso;
import model.Disciplina;
import model.Professor;

/**
 *
 * @author arthurcvm
 */
public class DisciplinaForm {
    @FXML
    private JFXTextField nomeField;
    @FXML
    private JFXTextField abreviacaoField;
    @FXML
    private JFXTextField chField;
    @FXML
    private JFXComboBox cursoBox;
    @FXML
    private JFXComboBox semestreBox;
    @FXML
    private JFXComboBox professorBox;
    @FXML
    private ButtonBar botoes;
    
    private Disciplina disciplina;
    private Stage dialogStage;
    
    private ArrayList<Professor> professorList = new ArrayList();
    private ArrayList<String> professorNomes = new ArrayList();
    
    private ArrayList<Curso> cursoList = new ArrayList();
    private ArrayList<String> cursoNomes = new ArrayList();
    
    private ArrayList<Integer> semestreList = new ArrayList();
    
    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente
     * após o arquivo fxml ter sido carregado.
     */
    @FXML
    public void initialize() {
        cursoBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                semestreList.clear();
                int index = cursoBox.getSelectionModel().getSelectedIndex(); //Pega o index da seleção pra buscar no array de IDs
                int qtdSemestres = cursoList.get(index).getQtdSemestres();
                
                for(int i = 1; i <= qtdSemestres; i++){
                    semestreList.add(i);
                }
                
                semestreBox.setItems(FXCollections.observableArrayList(semestreList));
            }
        });
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
        if(disciplina.getNome() != null){
            this.nomeField.setText(disciplina.getNome());
            this.abreviacaoField.setText(disciplina.getAbreviacao());
            this.chField.setText(String.valueOf(disciplina.getCH()));
        }
    }

    public void setProfessorList(ArrayList<Professor> professorList) {
        this.professorList = professorList;
        
        for(Professor p: professorList){
            professorNomes.add(p.getNome());
        }
        
        professorBox.setItems(FXCollections.observableArrayList(professorNomes));
        
        if(disciplina.getNome() != null){
            int professorId = disciplina.getProfessor();
            
            for(int i = 0; i < professorList.size(); i++){
                if(professorList.get(i).getId() == professorId){
                    this.professorBox.setValue(professorNomes.get(i));                    
                }
            }
        }
    }

    public void setCursoList(ArrayList<Curso> cursoList) {
        this.cursoList = cursoList;
        
        for(Curso c: cursoList){
            cursoNomes.add(c.getNomeCurso());
        }
        
        cursoBox.setItems(FXCollections.observableArrayList(cursoNomes));
        
        if(disciplina.getNome() != null){
            int cursoId = disciplina.getCurso();
            
            int qtdSemestres = new CursoDAO().get(cursoId).getQtdSemestres();
            
            for(int i = 0; i < cursoList.size(); i++){
                if(cursoList.get(i).getIdCurso() == cursoId){
                    this.cursoBox.setValue(cursoNomes.get(i));                    
                }
            }
            semestreList.clear();
            for(int i = 1; i <= qtdSemestres; i++){
                    semestreList.add(i);
            }
            semestreBox.setItems(FXCollections.observableArrayList(semestreList));
            this.semestreBox.setValue(disciplina.getSemestre());
        }
    }
    
    public void setBlock(){
        this.nomeField.setEditable(false);
        this.chField.setEditable(false);
        this.abreviacaoField.setEditable(false);
        this.professorBox.setEditable(false);
        this.semestreBox.setEditable(false);
        this.cursoBox.setEditable(false);
        botoes.setVisible(false);
        
        disciplina.setNome(null);
    }
    
    @FXML
    private void cancelar(){
        disciplina.setNome(null);
        
        this.dialogStage.close(); //fecha a janela
    }
    
    @FXML
    private void cadastrar(){
        this.disciplina.setNome(nomeField.getText());
        this.disciplina.setAbreviacao(abreviacaoField.getText());
        this.disciplina.setCH(Integer.valueOf(chField.getText()));
        this.disciplina.setCurso(cursoList.get(cursoBox.getSelectionModel().getSelectedIndex()).getIdCurso());
        this.disciplina.setProfessor(professorList.get(professorBox.getSelectionModel().getSelectedIndex()).getId());
        this.disciplina.setSemestre((semestreBox.getSelectionModel().getSelectedIndex())+1);
        
        this.dialogStage.close(); //fecha a janela
    }
}
