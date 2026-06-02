import model.Tabuleiro;

import java.util.Scanner;

public class GerenciarJogo {
    static void main() {
        Scanner sc = new Scanner(System.in);
        Tabuleiro tabu = new Tabuleiro();
        System.out.println("Digite o primeiro palpite [1..100] ");
        int p1 = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o segundo palpite [1..100] ");
        int p2 = Integer.parseInt(sc.nextLine());
        double premio = tabu.jogar(p1, p2);
        if(premio>0){
            System.out.println("Feliz Ganhador. Verifique seus acertos");
            System.out.println("Seu premio R$ " + premio);
        }else{
            System.out.println("Infelizmente não foi dessa vez");
        }
    }
}
