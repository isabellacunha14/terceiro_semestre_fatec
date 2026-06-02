package model;

import java.util.Random;

public class Tabuleiro {
    private int[][] matriz = new int[10][10];
    private int[] palpites = new int[2];

    public Tabuleiro(){
        //logica para gerar o tabuleiro aleatorio.
        //valores entre 1  e 100
        Random aleatorio = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = aleatorio.nextInt(1, 101);
            }
        }
    }
    public double jogar(int palpite1, int palpite2){
        this.palpites[0] = palpite1;
        this.palpites[1] = palpite2;
        int acertos = verificarAcertos();
        double premio = 0.0;
        if(acertos >= 3){
            premio = acertos * 1000.0;
        }
        exibirTabuleiro();
        return premio;
    }

    private void exibirTabuleiro() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(palpites[0]==matriz[i][j] || palpites[1]==matriz[i][j]){
                    System.out.printf("[%3d]* ", matriz[i][j]);
                }else{
                    System.out.printf("[%3d]  ", matriz[i][j]);
                }
            }
            System.out.println(); //proxima linha do tabuleiro
        }
    }

    private int verificarAcertos() {
        int contador = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(palpites[0]==matriz[i][j] || palpites[1]==matriz[i][j]){
                    contador++;
                }
            }
        }
        return contador;
    }
}
