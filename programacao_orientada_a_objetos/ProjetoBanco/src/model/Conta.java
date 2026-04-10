package model;

public class Conta {
    private int numConta;
    private String nomeAgencia;
    private String nomeCliente;
    private double saldo;

    public Conta(){

    }

    public Conta (int numConta, String nomeAgencia, String nomeCliente){
        this.numConta = numConta;
        this.nomeAgencia = nomeAgencia;
        this.nomeCliente = nomeCliente;
        this.saldo = 0.0;
    }


    public void sacar
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
