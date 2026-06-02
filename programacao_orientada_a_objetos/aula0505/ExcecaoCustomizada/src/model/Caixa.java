package model;

import exception.CaixaException;

/**
 * Classe que representa o modelo de negócios do Caixa (Model).
 * Responsável por armazenar o estado (saldo) e aplicar as regras de negócio
 * rigorosas para as operações financeiras.
 */
public class Caixa {
    private double saldo;

    /**
     * Realiza a operação de depósito, incrementando o saldo do caixa.
     *
     * @param valor O valor em ponto flutuante (double) a ser depositado.
     * @throws CaixaException Caso o valor seja menor ou igual a zero, é lançada uma
     * exceção com o código "RF01EX01" (Regra de Negócio de Depósito Inválido).
     */
    public void depositar(double valor) throws CaixaException {
        if (valor <= 0) {
            throw new CaixaException("RF01EX01");
        } else {
            saldo += valor;
        }
    }

    /**
     * Realiza a operação de saque, deduzindo o valor do saldo do caixa.
     *
     * @param valor O valor em ponto flutuante (double) a ser sacado.
     * @throws CaixaException Caso o valor de saque seja superior ao saldo disponível,
     * é lançada uma exceção com o código "RF01EX02" (Saldo Insuficiente).
     */
    public void sacar(double valor) throws CaixaException {
        if(valor > saldo){
            throw new CaixaException("RF01EX02");
        }else{
            saldo -= valor;
        }
    }

    /**
     * Retorna o saldo atual disponível no caixa.
     *
     * @return Um double representando o saldo monetário.
     */
    public double getSaldo() {
        return saldo;
    }
}