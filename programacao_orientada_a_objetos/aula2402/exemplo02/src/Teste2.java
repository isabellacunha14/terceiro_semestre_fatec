import java.util.Scanner;

public class Teste2 {

    /**
     * Função que soma dois valores
     * @param v1 primeiro argumento inteiro a ser passado
     * @param v2 segundo argumento inteiro a ser passador
     * @return resultado da soma dos dois numeros
     */
    public static int somar(int v1, int v2){
        return v1 + v2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //duas variáveis
        /*
           Vou pedir para o usuario
           entrar com os dois valores
         */
        System.out.println("Digite o primeiro valor: ");
        int a = sc.nextInt();
        System.out.println("Digite o segundo valor: ");
        int b = sc.nextInt();
        int soma = somar(a, b);
        System.out.println("Soma: " + soma);
    }
}
