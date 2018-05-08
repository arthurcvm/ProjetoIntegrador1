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
import javafx.stage.Stage;
import model.Curso;
import model.Turma;

/**
 *
 * @author arthurcvm
 */
public class TurmaForm {
    @FXML
    private JFXTextField descricaoField;
    @FXML
    private JFXComboBox cursoBox;
    @FXML
    private JFXComboBox semestreBox;
    
    private Stage dialogStage;
    private Turma turma;
    
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

    public void setCursoList(ArrayList<Curso> cursoList) {
        this.cursoList = cursoList;
        
        for(Curso c: cursoList){
            cursoNomes.add(c.getNomeCurso());
        }
        
        cursoBox.setItems(FXCollections.observableArrayList(cursoNomes));
        
        if(turma.getDescricao() != null){
            int cursoId = turma.getCurso();
            
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
            this.semestreBox.setValue(turma.getSemestre());
        }
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
        if(turma.getDescricao() != null){
            this.descricaoField.setText(turma.getDescricao());
        }
    }
    
    public void setBlock(){
        this.descricaoField.setEditable(false);
        this.cursoBox.setEditable(false);
        this.semestreBox.setEditable(false);
        
        turma.setDescricao(null);
    }
    
    @FXML
    private void cancelar(){
        turma.setDescricao(null);
        
        this.dialogStage.close(); //fecha a janela
    }
    
    @FXML
    private void cadastrar(){
        this.turma.setDescricao(descricaoField.getText());
        this.turma.setCurso(cursoList.get(cursoBox.getSelectionModel().getSelectedIndex()).getIdCurso());
        this.turma.setSemestre((semestreBox.getSelectionModel().getSelectedIndex())+1);
        
        this.dialogStage.close(); //fecha a janela
    }
}
