import java.util.Scanner;

public class AcampamentoTeste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Acampamento membro = new Acampamento();
        System.out.println("Digite o nome do membro do acampamento: ");
        membro.nome = sc.nextLine();
        System.out.println("Digite a idade do membro do acampamento: ");
        membro.idade = Integer.parseInt(sc.nextLine());
        //primeiro imprimir
        membro.imprimir();
        //separar o membro para uma equipe do grupo
        membro.separarGrupo();
        //segundo imprimir
        System.out.println();
        membro.imprimir();
    }
}
