import java.util.Scanner;

public class ComputadorTeste {
    public static void main(String[] args) {
        //a. criar um objeto da classe computador1

        Scanner sc = new Scanner(System.in);
        Computador computador1 = new Computador();
        System.out.println("Digite a marca: ");
        computador1.marca = sc.nextLine();
        System.out.println("Digite a cor: ");
        computador1.cor = sc.nextLine();
        System.out.println("Digite o modelo: ");
        computador1.modelo = sc.nextLine();
        System.out.println("Digite o numero de serie: ");
        computador1.numeroSerie = sc.nextLong();
        System.out.println("Digite o preco: ");
        computador1.preco = sc.nextDouble();
        sc.nextLine();

        //b. imprimir e analisar o que tá na tela

        computador1.imprimir();

        //c.executar o metodo calcularValor

        computador1.calcularValor();

        //d. imprimir e analisar o que tá na tela

        computador1.imprimir();

        //e. Computador 2

        Computador computador2 = new Computador();
        System.out.println("Digite a marca: ");
        computador2.marca = sc.nextLine();
        System.out.println("Digite a cor: ");
        computador2.cor = sc.nextLine();
        System.out.println("Digite o modelo: ");
        computador2.modelo = sc.nextLine();
        System.out.println("Digite o numero de serie: ");
        computador2.numeroSerie = sc.nextLong();
        System.out.println("Digite o preco: ");
        computador2.preco = sc.nextDouble();

        //f. imprimir e analisar o que tá na tela

        computador2.imprimir();

        //g.executar o metodo calcularValor

        computador2.calcularValor();

        //h. imprimir e analisar o que tá na tela

        computador2.imprimir();

        //i. verificar o metodo alterar valor

        System.out.println("Digite o novo valor: ");
        double novoValor = sc.nextDouble();

        int retorno = computador1.alterarValor(novoValor);

        if (retorno == 1) {
            System.out.println("Valor alterado");
        } else {
            System.out.println("Valor NÃO alterado");
        }

        computador1.imprimir();


    }
}
