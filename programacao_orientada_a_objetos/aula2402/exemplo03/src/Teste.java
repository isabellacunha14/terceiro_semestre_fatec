import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu de Refri");
        System.out.println("1. Guarana");
        System.out.println("2. Coca cola");
        System.out.println("3. Fanta");
        System.out.println("0. Sair");
        int opcao = Integer.parseInt(sc.nextLine());
        double valor = switch (opcao) {
            case 1 -> {
                System.out.println("Escolheu Guarana");
                yield 3.89;
            }
            case 2 -> {
                System.out.println("Escolheu Coca cola");
                yield 5.89;
            }
            case 3 -> {
                System.out.println("Escolheu Fanta");
                yield 2.68;
            }
            case 0 -> {
                System.out.println("Fim do programa");
                yield 0;
            }
            default -> {
                System.out.println("Opcao invalida");
                yield 0;
            }
        };
        System.out.println("Fim do Programa. Valor a pagar " + valor);
    }

}
