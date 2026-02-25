import java.time.LocalDate;

public class Teste {
    public static void main(String[] args) {
        int a=10;
        int b= 15;
        int soma = a+b;
        System.out.println("Soma: " + soma);
        // variavel objeto (referencia)
        //matricular dois alunos e cancelar a matricula do segundo
        Aluno aluno1 = new Aluno();
        aluno1.rm=111;
        aluno1.nome="Carlos";
        aluno1.turma="3.Periodo";
        aluno1.data_matr= LocalDate.now();

        Aluno aluno2 = new Aluno();
        aluno2.rm=222;
        aluno2.nome="Maria";
        aluno2.turma="2.Periodo";
        aluno2.data_matr = LocalDate.now();

        //matricula
        aluno1.matricular();
        aluno2.matricular();

        //cancelar a matricula do segundo
        aluno2.cancelarMatricula();
    }
}
