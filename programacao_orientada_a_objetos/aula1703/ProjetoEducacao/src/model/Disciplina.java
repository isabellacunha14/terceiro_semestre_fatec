package model;

public class Disciplina {
    private int idDisciplina;
    private String nomeDisciplina;
    private String professor;
    private int cargaHoraria;

    public Disciplina(){

    }
    public Disciplina(int idDisciplina, String nomeDisciplina,
                      String professor, int cargaHoraria){
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.professor = professor;
        this.cargaHoraria = cargaHoraria;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
