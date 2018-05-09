/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetointegrador1;

import DAO.AlunoDAO;
import DAO.ProfessorDAO;
import control.Dashboard;
import control.DashboardAluno;
import control.DashboardProfessor;
import control.Login;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Aluno;
import model.Professor;

/**
 *
 * @author arthurcvm
 */
public class ProjetoIntegrador1 extends Application {
    private static Professor usuarioP;
    private static Aluno usuarioA;
    
    @Override
    public void start(Stage stage) throws Exception {

//        showLogin(stage);

        dashboard(stage);
    }
    
    public void showLogin(Stage stageMaster){
        ArrayList<Professor> professorList = new ProfessorDAO().lista();
        ArrayList<Aluno> alunoList = new AlunoDAO().lista();
        
        usuarioA = new Aluno();
        usuarioP = new Professor();
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml")); //Carrega o arquivo FXML
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage(); //Cria um novo Stage
            stage.setTitle("Entrar"); //Seta um título
            stage.initOwner(stageMaster); //Seta um stage pai
            Scene scene = new Scene(page);
            stage.setScene(scene);
            
            Login controller = loader.getController(); //Puxa a referência do controller instanciado
            controller.setStage(stage); //Seta stage para controle interno
            controller.setAluno(usuarioA);
            controller.setProfessor(usuarioP);
            controller.setAlunoList(alunoList);
            controller.setProfessorList(professorList);
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
            
            if(usuarioA.getNome() != null){
                dashboardAluno(stageMaster);
            }
            else if(usuarioP.getNome() != null){
                dashboardProfessor(stageMaster);
            }
            
//            dashboard(stageMaster);
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void dashboard(Stage stageMaster){        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Dashboard.fxml")); //Carrega o arquivo FXML
            BorderPane page = (BorderPane) loader.load();
            Stage stage = new Stage(); //Cria um novo Stage
            stage.initOwner(stageMaster); //Seta um stage pai
            Scene scene = new Scene(page);
            stage.setScene(scene);
            
            Dashboard controller = loader.getController(); //Puxa a referência do controller instanciado
            controller.setPainel(page);
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void dashboardAluno(Stage stageMaster){        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardAluno.fxml")); //Carrega o arquivo FXML
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage(); //Cria um novo Stage
            stage.initOwner(stageMaster); //Seta um stage pai
            Scene scene = new Scene(page);
            stage.setScene(scene);
            
            DashboardAluno controller = loader.getController(); //Puxa a referência do controller instanciado
//            controller.setPainel(page);
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void dashboardProfessor(Stage stageMaster){        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashboardProfessor.fxml")); //Carrega o arquivo FXML
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage(); //Cria um novo Stage
            stage.initOwner(stageMaster); //Seta um stage pai
            Scene scene = new Scene(page);
            stage.setScene(scene);
            
            DashboardProfessor controller = loader.getController(); //Puxa a referência do controller instanciado
//            controller.setPainel(page);
            
            stage.showAndWait(); //Exibe janela e pausa esta thread
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
