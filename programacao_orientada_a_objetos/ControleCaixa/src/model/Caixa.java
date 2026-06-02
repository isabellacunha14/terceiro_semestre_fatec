package model;

public class Caixa {
    private double saldo;

    public void sacar(double valor) throws IllegalAccessException {
        if(valor<saldo){
            saldo -= valor;
        }
        else{
            throw new IllegalAccessException("Saldo insuficiente");
        }
    }

    public void depositar(double valor) throws IllegalAccessException {
        if(valor>0){
            saldo += valor;
        }
        else{
            throw new IllegalAccessException("Valor invalido para deposito");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}

