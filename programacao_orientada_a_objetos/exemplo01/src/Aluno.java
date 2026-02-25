import java.time.LocalDate;

public class Aluno {
    //1. Definir os atributos
    public int rm;
    public String nome;
    public String turma;
    public LocalDate data_matr;
    public static String nomeEscola = "Fatec";

    //2. Definir os metodos
    public void matricular(){
        //logica
        System.out.println("Matricula efetuada, dados: ");
        System.out.println("Ra: " +rm);
        System.out.println("Nome: " + nome);
        System.out.println("Escola: " +nomeEscola);
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    public void cancelarMatricula(){
        //logica
        System.out.println("Matricula cancelada, dados: ");
        System.out.println("Rm: " + rm);
        System.out.println("Cancelada em: " + LocalDate.now());
        System.out.println("=-=-=-=-=--=-=-=-=-=-=-=-=-=--=-=-=-=-=--=-=-=-=-=");
    }


}
