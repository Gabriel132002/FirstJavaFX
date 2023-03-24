package com.example.firstjavafx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public enum Cursos implements Serializable {

    ADS("Análise e desenvolvimento de sistemas"),
    ENG("Engenharia da Computação"),
    CIENCIA("Ciências da Computação"),
    OUTROS("Outros");

    private String nomeCurso;
    private Cursos(String nomeCurso){
        this.nomeCurso = nomeCurso;
    }
    public String nomeCurso(){
        return this.nomeCurso;
    }

}
