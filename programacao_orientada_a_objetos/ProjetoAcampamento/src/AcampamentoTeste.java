import java.util.Scanner;

public class AcampamentoTeste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Acampamento membro = new Acampamento();
        System.out.println("Digite o nome: ");
        membro.nome = sc.nextLine();
        System.out.println("Digite a idade: ");
        membro.idade=Integer.parseInt(sc.nextLine());

        //primeiro imprimir
        membro.imprimir();

        //separar grupo
        membro.separarGrupo();

        //segundo imprimir
        System.out.println();
        membro.imprimir();
    }
}
