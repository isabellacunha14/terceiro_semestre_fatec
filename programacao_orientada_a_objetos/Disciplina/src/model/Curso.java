package model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    //atributos privados;
    private int idCurso;
    private String descricao;
    private String periodo;
    private int numeroAlunos;
    private List<Disciplina> disciplinas;

    //metodo construtor - personalizado
    public Curso() {
        disciplinas = new ArrayList<>();
    }

    public Curso(int idCurso, String descricao) {
        this();
        this.idCurso = idCurso;
        this.descricao = descricao;
    }

    public Curso(int idCurso, String descricao, String periodo, int numeroAlunos) {
        this(idCurso, descricao);
        this.periodo = periodo;
        this.numeroAlunos = numeroAlunos;
    }

}