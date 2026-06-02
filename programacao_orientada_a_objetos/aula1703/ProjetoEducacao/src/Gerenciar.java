import model.Curso;
import model.Disciplina;
import model.Mes;

public class Gerenciar {
    static void main() {
       /* Mes mesAtual = Mes.marco;

        System.out.println(mesAtual);
        System.out.println("Lista de meses");
        for(Mes mes : Mes.values()){
            System.out.println(mes);
        }*/

        Curso curso = new Curso(1, "ADS", "Noite", 40);
        Disciplina disc1 = new Disciplina(1, "POO",
                "Maromo", 80);
        Disciplina disc2 = new Disciplina(2, "Est de Dados",
                "Nava", 80);
        curso.adicionarDisciplina(disc1);
        curso.adicionarDisciplina(disc2);

        System.out.println(curso);
    }
}
