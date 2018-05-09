/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Aluno;
import model.Professor;

/**
 *
 * @author arthurcvm
 */
public class Login {
    @FXML
    private JFXTextField usuario;
    @FXML
    private JFXPasswordField senha;
    
    private Stage stage;
    private Aluno aluno;
    private Professor professor;
    
    private ArrayList<Professor> professorList;
    private ArrayList<Aluno> alunoList;
    
    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente após
     * o arquivo fxml ter sido carregado.
     */
    @FXML
    public void initialize() {

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setProfessorList(ArrayList<Professor> professorList) {
        this.professorList = professorList;
    }

    public void setAlunoList(ArrayList<Aluno> alunoList) {
        this.alunoList = alunoList;
    }
    
    @FXML
    private void login(){
        String login = this.usuario.getText();
        String pass = this.senha.getText();
        
        for(Professor p: professorList){
            if(p.getLogin().equals(login)){
                if(p.getSenha().equals(pass)){
                    professor.setNome(p.getNome());
                    professor.setCpf(p.getCpf());
                    professor.setFaculdade(p.getFaculdade());
                    professor.setId(p.getId());
                    professor.setLogin(p.getLogin());
                    professor.setSenha(p.getSenha());
                }
            }
        }
        
        for(Aluno a: alunoList){
            if(a.getLogin().equals(login)){ //troca pelo login
                if(a.getSenha().equals(pass)){ //troca pela senha
                    aluno.setNome(a.getNome());
                    aluno.setCpf(a.getCpf());
                    aluno.setId(a.getId());
                    aluno.setLogin(a.getLogin());
                    aluno.setRG(a.getRG());
                    aluno.setSenha(a.getSenha());
                    aluno.setTurma(a.getTurma());
                }
            }
        }
        
        if(aluno.getNome() == null && professor.getNome() == null){ //Login incorreto
            usuario.clear();
            senha.clear();
        }
        else{ //Login correto
            this.stage.close();
        }
    }
    
    @FXML
    private void recuperarSenha(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LembrarSenha.fxml")); //Carrega o arquivo FXML
            AnchorPane page = (AnchorPane) loader.load();
            Stage DialogStage = new Stage(); //Cria um novo Stage
            DialogStage.setTitle("Lembrar Senha"); //Seta um título
            DialogStage.initModality(Modality.WINDOW_MODAL); //Bloqueia a janela pai
            DialogStage.initOwner(stage); //Seta um stage pai
            Scene scene = new Scene(page);
            DialogStage.setScene(scene);
            
            LembrarSenha controller = loader.getController(); //Puxa a referência do controller instanciado
            controller.setStage(DialogStage); //Seta stage para controle interno
            
            DialogStage.showAndWait(); //Exibe janela e pausa esta thread
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
