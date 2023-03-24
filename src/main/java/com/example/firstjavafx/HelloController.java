package com.example.firstjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbCursos.setItems(cursos);

    }

    @FXML
    private AnchorPane ApMain;

    @FXML
    private Button IDSubmit;

    @FXML
    private TextField TfNome;

    @FXML
    private ComboBox<Cursos> cbCursos;
    private ObservableList<Cursos> cursos = FXCollections.observableArrayList(Cursos.values());

    @FXML
    private CheckBox itsAdult;

    @FXML
    private TextField tsSexo;

    @FXML
    void ClickBTN(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Alunos alunos = new Alunos();
        AlunoDAO alunoDAO = new AlunoDAO();

        String nome = TfNome.getText();
        String sexo = tsSexo.getText();
        String curso = cbCursos.getValue().toString();
        Boolean maior = itsAdult.isSelected();

        if (nome.isEmpty() || sexo.isEmpty() || curso.isEmpty() || maior == false) {
            alert.setTitle("Erro no envio do formulário");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, preencha todos os campos");
            alert.showAndWait();
        } else {

            alunos.setNome(TfNome.getText());
            alunos.setSexo(tsSexo.getText());
            alunos.setCursos(cbCursos.getValue());

            if (itsAdult.isSelected()) {
                alunos.setMaioridade(true);
            }

            alunoDAO.create(alunos);

            alert.setContentText("Gravado com sucesso");
            alert.showAndWait();

        }
    }
}
