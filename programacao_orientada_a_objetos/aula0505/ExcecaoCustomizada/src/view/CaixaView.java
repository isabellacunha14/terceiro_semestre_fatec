package view;

import model.Caixa;
import java.util.Scanner;

/**
 * Classe responsável pela interface com o usuário (View).
 * Exibe o menu principal, interage com o usuário recebendo entradas via console
 * e invoca os métodos do modelo (Caixa) para executar as operações de negócio.
 */
public class CaixaView {
    private Caixa caixa;

    /**
     * Construtor da classe CaixaView.
     * Inicializa uma nova instância de Caixa e inicia o loop do menu principal.
     * O loop continua sendo executado e processando as escolhas do usuário até que
     * a opção de saída (9) seja selecionada.
     */
    public CaixaView(){
        caixa = new Caixa();
        int opcao;
        do{
            opcao = construirMenu();
            switch (opcao){
                case 1 -> execDepositar();
                case 2 ->  execSacar();
                case 3 ->  execSaldo();
                case 9 ->  System.out.println("Fim do Programa");
                default -> System.out.println("Opcao invalida");
            }
        }while(opcao!=9);
    }

    /**
     * Constrói e exibe o menu de opções para o usuário no console.
     * Fica em um loop infinito até que o usuário digite um valor numérico válido (inteiro).
     *
     * @return int correspondente à opção escolhida pelo usuário.
     */
    public int construirMenu(){
        while(true) {
            try {
                int opcao;
                Scanner sc = new Scanner(System.in);
                System.out.println("----- MENU PRINCIPAL ----");
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Exibir Saldo");
                System.out.println("9. Sair");
                System.out.println("Escolha sua opcao: ");
                opcao = Integer.parseInt(sc.nextLine());
                return opcao;
            } catch (NumberFormatException ex) {
                System.out.println("Entrada invalida de dados");
            }
        }
    }

    /**
     * Executa o fluxo de interação para depósito.
     * Solicita o valor ao usuário, faz a conversão de tipo e chama o método de
     * depósito no modelo Caixa. Trata erros de conversão de número e exceções de negócio (CaixaException).
     */
    public void execDepositar(){
        try {
            Scanner sc = new Scanner(System.in);
            double valor;
            System.out.println("Digite o valor do deposito: ");
            valor = Double.parseDouble(sc.nextLine());
            caixa.depositar(valor);
        }catch (NumberFormatException ex){
            System.out.println("Entrada invalida. Valor deve ser numérico");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Executa o fluxo de interação para saque.
     * Solicita o valor ao usuário e chama o método de saque no modelo Caixa.
     * Captura possíveis exceções caso o usuário digite texto ou não tenha saldo suficiente.
     */
    public void execSacar(){
        try {
            Scanner sc = new Scanner(System.in);
            double valor;
            System.out.println("Digite o valor do saque: ");
            valor = Double.parseDouble(sc.nextLine());
            caixa.sacar(valor);
        }catch (NumberFormatException ex){
            System.out.println("Entrada invalida. Valor deve ser numérico");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Recupera e exibe o saldo atual do caixa no console para o usuário.
     */
    public void execSaldo(){
        System.out.println("Saldo atual: " + caixa.getSaldo());
    }
}