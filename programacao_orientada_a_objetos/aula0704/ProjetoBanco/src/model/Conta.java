package model;

public abstract class Conta {
    private int numConta;
    private String nomeAgencia;
    private String nomeCliente;
    protected double saldo;

    public Conta(){

    }
    public Conta(int numConta, String nomeAgencia, String nomeCliente){
        this.numConta = numConta;
        this.nomeAgencia = nomeAgencia;
        this.nomeCliente = nomeCliente;
        this.saldo = 0.0;
    }

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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor){
        if(valor > 0){
            saldo += valor;
        }else{
            throw new IllegalArgumentException("Erro de valor");
        }
    }

    public void sacar(double valor){
        if(valor <= saldo){
            double taxa = cobrarTaxaSaque();
            saldo-= (valor + taxa);
        }else{
            throw new IllegalArgumentException("Sem saldo para saque");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Num. Conta: ").append(numConta).append("\n");
        sb.append("Nome Cliente: ").append(nomeCliente).append("\n");
        sb.append("Nome Agencia: ").append(nomeAgencia).append("\n");
        sb.append("Saldo R$ ").append(saldo).append("\n");
        return sb.toString();
    }
    //método abstrato para representar cobranca de taxa de saque
    abstract double cobrarTaxaSaque();
}
