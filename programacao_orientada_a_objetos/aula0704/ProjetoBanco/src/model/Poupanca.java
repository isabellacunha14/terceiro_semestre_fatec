package model;

public class Poupanca extends Conta{
    private double taxaRendimento;

    public Poupanca(){

    }
    public Poupanca(int numConta, String nomeAgencia, String nomeCliente, double taxaRendimento ){
        super(numConta, nomeAgencia, nomeCliente);
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Taxa Rendimento: ").append(taxaRendimento).append("\n");
        return sb.toString();
    }

    @Override
    double cobrarTaxaSaque() {
        return 0.05;
    }
}
