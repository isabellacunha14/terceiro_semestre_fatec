import java.util.Scanner;

public class ContaTeste {
    public Conta cc = new Conta();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContaTeste teste = new ContaTeste();
        int opcao = 0;
        do{
            System.out.println("---- MENU PRINCIPAL ----");
            System.out.println("1. Cadastrar Conta");
            System.out.println("2. Depositar na Conta");
            System.out.println("3. Sacar da Conta");
            System.out.println("4. Consultar Dados");
            System.out.println("9. SAIR");
            System.out.println("Digite sua opcao: ");
            opcao = Integer.parseInt(sc.nextLine());
            switch(opcao){
                case 1-> teste.execCadastrar();
                case 2-> teste.execDepositar();
                case 3-> teste.execSacar();
                case 4-> teste.execConsultar();
                case 9-> System.out.println("FIM");
                default ->  System.out.println("Opcao invalida");
            }
        }while(opcao!=9);
    }

    public void execCadastrar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome da agencia: ");
        cc.agencia = sc.nextLine();
        System.out.println("Digite o numero da conta: ");
        cc.conta = sc.nextLine();
        System.out.println("Digite o nome do cliente: ");
        cc.nomeCliente = sc.nextLine();
        System.out.println("Conta cadastrada com sucesso!");
    }
    public void execConsultar(){
        cc.imprimir();
    }
    public void execSacar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor a ser sacado: ");
        double valor = Double.parseDouble(sc.nextLine());
        boolean sacou = cc.sacar(valor);
        if(sacou){
            System.out.println("Saque efetuado com sucesso");
        }else{
            System.out.println("Sem saldo suficiente");
        }
    }
    public void execDepositar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor a ser depositado: ");
        double valor = Double.parseDouble(sc.nextLine());
        cc.depositar(valor);
        System.out.println("Depositado com sucesso");
    }
}
