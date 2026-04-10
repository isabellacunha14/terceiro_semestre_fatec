package model;

import java.util.List;

public class Disciplina {
    private int idDisciplina;
    private String nomeDisciplina;
    private String professor;
    private int cargaHoraria;

    public Disciplina(){

    }

    public Disciplina(int idDisciplina, String nomeDisciplina,String professor, int cargaHoraria){
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.professor = professor;
        this.cargaHoraria = cargaHoraria;
    }
    //metodo getters and setters

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
