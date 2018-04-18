/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Turma;

/**
 *
 * @author arthurcvm
 */
public class TurmaForm {
    @FXML
    private JFXTextField descricaoField;
    @FXML
    private JFXTextField cursoField;
    @FXML
    private JFXTextField semestreField;
    
    private Stage dialogStage;
    private Turma turma;
    
    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente
     * após o arquivo fxml ter sido carregado.
     */
    @FXML
    public void initialize() {        
        // Carregando lista de estados na Box.
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
        if(turma.getDescricao() != null){
            this.descricaoField.setText(turma.getDescricao());
            //this.cursoField.setText(turma.getCurso());
            //this.semestreField.setText(turma.getSemestre());
        }
    }
    
    public void setBlock(){
        this.descricaoField.setEditable(false);
        this.cursoField.setEditable(false);
        this.semestreField.setEditable(false);
        
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
//        this.turma.setCurso(0);
//        this.turma.setSemestre(0);
        
        this.dialogStage.close(); //fecha a janela
    }
}
