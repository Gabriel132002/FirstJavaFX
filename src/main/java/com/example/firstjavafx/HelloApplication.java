package com.example.firstjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Layout.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

//        HelloController helloController = new HelloController();
//
//        AlunoDAO alunoDAO = new AlunoDAO();
//        Alunos alunos = new Alunos();
//        alunos.setNome("");
//        alunos.setSexo("M");
//        alunos.setCursos(Cursos.ADS);
//        alunos.setMaioridade(true);
//        alunoDAO.create(alunos);

    }
}