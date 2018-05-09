/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.AlunoDAO;
import DAO.CursoDAO;
import DAO.FaculdadeDAO;
import DAO.ProfessorDAO;
import DAO.TurmaDAO;
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
            
            ArrayList<ProfessorGenerico> professorGenericoList = new ProfessorDAO().listaGen();
            
            FaculdadeDAO dao = new FaculdadeDAO();
            ArrayList<Faculdade> faculdadeList = dao.lista();
            
            this.painel.setRight(pane);
            ProfessorController controller = loader.getController();
            controller.setPrimaryStage(painel);
            controller.setProfessorGenericoList(professorGenericoList);
            controller.setFaculdadeList(faculdadeList);
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void alunos(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Aluno.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            
            ArrayList<AlunoGenerico> alunoGenericoList = new AlunoDAO().listaGen();
            
            FaculdadeDAO dao = new FaculdadeDAO();
            ArrayList<Faculdade> faculdadeList = dao.lista();
            
            this.painel.setRight(pane);
            AlunoController controller = loader.getController();
            controller.setPrimaryStage(painel);
            controller.setAlunoGenericoList(alunoGenericoList);
            controller.setFaculdadeList(faculdadeList);
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void cursos(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Curso.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
            
            CursoDAO daoCurso = new CursoDAO();
            ArrayList<CursoGenerico> cursoGenericoList = daoCurso.listaGen();
            
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
            
            ArrayList<TurmaGenerica> turmaGenericaList = new TurmaDAO().listaGen();
            
            FaculdadeDAO dao = new FaculdadeDAO();
            ArrayList<Faculdade> faculdadeList = dao.lista();
            
            this.painel.setRight(pane);
            TurmaController controller = loader.getController();
            controller.setPrimaryStage(painel);
            controller.setTurmaGenericaList(turmaGenericaList);
            controller.setFaculdadeList(faculdadeList);
            
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
            
            FaculdadeDAO dao = new FaculdadeDAO();
            ArrayList<Faculdade> faculdadeList = dao.lista();
            
            this.painel.setRight(pane);
            DisciplinaController controller = loader.getController();
            controller.setPrimaryStage(painel);
            controller.setDisciplinaGenericaList(disciplinaGenericaList);
            controller.setFaculdadeList(faculdadeList);
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
