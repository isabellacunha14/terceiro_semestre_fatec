import java.util.Scanner;

public class ContaTeste {

    Scanner sc = new Scanner(System.in);
    private Conta contaCorrente = new Conta();

    public static void main(String[] args) {

        ContaTeste contaTeste = new ContaTeste(); // cria objeto

        int op;

        do {
            System.out.println("SISTEMA CONTA");
            System.out.println("1. Cadastrar");
            System.out.println("2. Consultar");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            op = contaTeste.sc.nextInt();
            contaTeste.sc.nextLine(); // limpa o ENTER pendente

            switch (op) {
                case 1 -> contaTeste.execCadastrar();
                case 2 -> contaTeste.execConsultar();
                case 3 -> contaTeste.execDepositar();
                case 4 -> contaTeste.execSacar();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (op != 0);

        contaTeste.sc.close();
    }

    public void execCadastrar() {
        System.out.println("-------------");
        System.out.println("Digite a conta: ");
        contaCorrente.conta = sc.nextLine();

        System.out.println("Digite a Agencia: ");
        contaCorrente.agencia = sc.nextLine();

        System.out.println("Digite o nome:");
        contaCorrente.nomeCliente = sc.nextLine();

        System.out.println("Digite o Saldo: ");
        contaCorrente.saldo = sc.nextDouble();
        sc.nextLine(); // limpa buffer

        System.out.println("-------------");
    }

    public void execConsultar() {
        contaCorrente.imprimir();
    }

    public void execSacar() {
        System.out.println("Digite o valor a ser sacado: ");
        double saque = sc.nextDouble();
        sc.nextLine(); // limpa buffer

        int resultado = contaCorrente.sacar(saque);

        if (resultado == 1){
            System.out.println("Saque realizado");
            return;
        }

        System.out.println("Saque nao realizado");
    }

    public void execDepositar() {
        System.out.println("Digite o valor a ser Depositado: ");
        double deposito = sc.nextDouble();
        sc.nextLine(); // limpa buffer

        contaCorrente.depositar(deposito);
        System.out.println("Depósito realizado com sucesso!");
    }
}