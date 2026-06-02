package model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    //Atributos privados
    private int idCurso;
    private String descricao;
    private String periodo;
    private int numeroAlunos;
    private List<Disciplina> disciplinas;

    //metodo construtor - personalizado
    public Curso(){
        disciplinas = new ArrayList<>();
    }
    public Curso(int idCurso, String descricao){
        this();
        this.idCurso = idCurso;
        this.descricao = descricao;
    }
    public Curso(int idCurso, String descricao, String periodo, int numeroAlunos){
        this(idCurso, descricao);
        this.periodo = periodo;
        this.numeroAlunos = numeroAlunos;
    }
    //metodos getters and setters

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getNumeroAlunos() {
        return numeroAlunos;
    }

    public void setNumeroAlunos(int numeroAlunos) {
        this.numeroAlunos = numeroAlunos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina){
        disciplinas.add(disciplina);
    }

    @Override
    public String toString() {
        //Melhorar o toString desta classe. StringBuilder.
        String lista = "";
        for(Disciplina disciplina : disciplinas){
            lista += disciplina.getNomeDisciplina() + "\n";
        }
        return "Curso: " + descricao + "\n" +
                "Periodo: " + periodo + "\n" +
                "Lista das disciplinas: \n" + lista;
    }
}
