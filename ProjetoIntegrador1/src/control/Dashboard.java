/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.FaculdadeDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.Aluno;
import model.AlunoGenerico;
import model.Curso;
import model.CursoGenerico;
import model.Disciplina;
import model.DisciplinaGenerica;
import model.Faculdade;
import model.FaculdadeGenerica;
import model.Professor;
import model.ProfessorGenerico;
import model.Turma;
import model.TurmaGenerica;

/**
 *
 * @author arthurcvm
 */
public class Dashboard {
    private BorderPane painel;

    public void setPainel(BorderPane painel) {
        this.painel = painel;
    }
    
    @FXML
    private void faculdades(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Faculdade.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            
            FaculdadeDAO dao = new FaculdadeDAO();
            ArrayList<FaculdadeGenerica> faculdadeGenericaList = dao.listaGen();
            
            this.painel.setRight(pane);
            FaculdadeController controller = loader.getController();
            controller.setFaculdadeGenericaList(faculdadeGenericaList);
            controller.setPrimaryStage(painel);
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void professores(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Professor.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            
            ArrayList<Professor> professorList = new ArrayList<>(); //Pega do banco
            ArrayList<ProfessorGenerico> professorGenericoList = new ArrayList<>();
            for(Professor p: professorList){
                professorGenericoList.add(new ProfessorGenerico(p));
            }
            
            this.painel.setRight(pane);
            ProfessorController controller = loader.getController();
            controller.setPrimaryStage(painel);
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void alunos(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Aluno.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            
            ArrayList<Aluno> alunoList = new ArrayList<>(); //Pega do banco
            ArrayList<AlunoGenerico> alunoGenericoList = new ArrayList<>();
            for(Aluno a: alunoList){
                alunoGenericoList.add(new AlunoGenerico(a));
            }
            
            this.painel.setRight(pane);
            AlunoController controller = loader.getController();
            controller.setPrimaryStage(painel);
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void cursos(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Curso.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            
            ArrayList<Curso> cursoList = new ArrayList<>(); //Pega do banco
            ArrayList<CursoGenerico> cursoGenericoList = new ArrayList<>();
            for(Curso c: cursoList){
                cursoGenericoList.add(new CursoGenerico(c));
            }
            
            FaculdadeDAO dao = new FaculdadeDAO();
            ArrayList<Faculdade> faculdadeList = dao.lista();
            
            this.painel.setRight(pane);
            CursoController controller = loader.getController();
            controller.setPrimaryStage(painel);
            controller.setCursoGenericoList(cursoGenericoList);
            controller.setFaculdadeList(faculdadeList);
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void turmas(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Turma.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            
            ArrayList<Turma> turmaList = new ArrayList<>(); //Pega do banco
            ArrayList<TurmaGenerica> turmaGenericaList = new ArrayList<>();
            for(Turma t: turmaList){
                turmaGenericaList.add(new TurmaGenerica(t));
            }
            
            this.painel.setRight(pane);
            TurmaController controller = loader.getController();
            controller.setPrimaryStage(painel);
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void disciplinas(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Disciplina.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            
            ArrayList<Disciplina> disciplinaList = new ArrayList<>(); //Pega do banco
            ArrayList<DisciplinaGenerica> disciplinaGenericaList = new ArrayList<>();
            for(Disciplina d: disciplinaList){
                disciplinaGenericaList.add(new DisciplinaGenerica(d));
            }
            
            this.painel.setRight(pane);
            DisciplinaController controller = loader.getController();
            controller.setPrimaryStage(painel);
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
