import java.util.Scanner;

public class Teste3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] v = new int[5];
        for (int i = 0; i < v.length; i++) {
            System.out.println("Digite o valor da posicao " + i + ":");
            v[i] = Integer.parseInt(sc.nextLine());
        }

        //imprimir
        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);
        }
    }
}
