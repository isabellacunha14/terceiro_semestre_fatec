import java.time.LocalDate;

public class Teste {
    public static void main(String[] args) {
        //Variáveis primitivas
        int a = 10;
        int b = 15;
        int soma = a + b;
        System.out.println("Soma: " + soma);
        //Variável objeto (referencia)
        //Matricular dois alunos e cancelar a matricula do segunda
        Aluno aluno1 = new Aluno();
        aluno1.rm = 111;
        aluno1.nome = "Carlos";
        aluno1.turma = "3. periodo";
        aluno1.data_matr = LocalDate.now();

        Aluno aluno2 = new Aluno();
        aluno2.rm = 222;
        aluno2.nome = "Maria";
        aluno2.turma = "2. periodo";
        aluno2.data_matr = LocalDate.now();


        //Matricula dos dois alunos
        aluno1.matricular();
        aluno2.matricular();

        //Cancelar a matricula do segundo aluno
        aluno2.cancelarMatricula();
    }
}
