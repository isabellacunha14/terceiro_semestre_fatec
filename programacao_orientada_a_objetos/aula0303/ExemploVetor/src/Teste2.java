import java.util.Arrays;

public class Teste2 {
    public static void main(String[] args) {
        int[] vetor1 = { 2,4,6,8,10,12,14,16,18,20};
        int[] vetor2 = new int[10];
        System.arraycopy(vetor1, 2, vetor2, 4, 6);
        for (int i = 0; i < vetor2.length; i++) {
            System.out.println(vetor2[i]);
        }
        int[] vetor3 = {34, 1, 6, 100, 4, 55};
        Arrays.sort(vetor3);
        System.out.println("Vetor 3");
        for (int i = 0; i < vetor3.length; i++) {
            System.out.println(vetor3[i]);
        }

    }
}
