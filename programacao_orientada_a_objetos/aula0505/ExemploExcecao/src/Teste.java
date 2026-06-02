import java.util.InputMismatchException;
import java.util.Scanner;

public class Teste {
    static void main() {
        while(true) {
            try {
                int a, b, result;
                Scanner sc = new Scanner(System.in);
                System.out.println("Digite um valor para a: ");
                a = Integer.parseInt(sc.nextLine());
                System.out.println("Digite um valor para b: ");
                b = sc.nextInt();
                result = a / b;
                System.out.println("Resultado: " + result);
                break;
            } catch (NumberFormatException | InputMismatchException ex) {
                System.out.println("Erro na Entrada. Valor deve ser inteiro");
            } catch (ArithmeticException ex) {
                System.out.println("Erro de Divisão por ZERO ");
            }
        }
    }
}
