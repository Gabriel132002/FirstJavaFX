package com.example.firstjavafx;

import com.example.firstjavafx.config.ConnectionClass;

import java.sql.*;

public class AlunoDAO implements IAlunoDAO {
    @Override
    public Alunos create(Alunos aluno) {
        try(Connection connection = ConnectionClass.getConnection() ){
            String query = "INSERT INTO alunos"+
                    "(NOME, MAIORIDADE, CURSO, SEXO)"+
                    "VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, aluno.getNome());
            statement.setBoolean(2, aluno.isMaioridade());
            statement.setString(3, aluno.getCursos().toString());
            statement.setString(4, aluno.getSexo());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            Long matriculaGerada = resultSet.getLong(1);
            aluno.setMatricula(matriculaGerada);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return aluno;
    }
}
