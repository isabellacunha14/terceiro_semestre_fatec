package model;

public class Corrente extends Conta {
    private double limite;

    public Corrente(){

    }
    public Corrente(int numConta, String nomeAgencia, String nomeCliente, double limite){
        super(numConta, nomeAgencia, nomeCliente);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        if(valor <= (saldo + limite)){
            double taxa = cobrarTaxaSaque();
            saldo-= (valor + taxa);
        }else{
            throw new IllegalArgumentException("Sem saldo ou limite");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Limite: ").append(limite).append("\n");
        return sb.toString();
    }

    @Override
    double cobrarTaxaSaque() {
        return 0.10;
    }
}
