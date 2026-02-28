public class Conta {

    public String conta;
    public String agencia;
    public double saldo;
    public String nomeCliente;

    public int sacar(double saque){
        if(saque > saldo){
            return 0;
        }
        saldo -= saque;
        return 1;
    }

    public void depositar (double valor){
        saldo+= valor;
    }

    public void imprimir (){
        System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=");
        System.out.println("Conta: " +conta);
        System.out.println("Agencia: " +agencia);
        System.out.println("Saldo: " +saldo);
        System.out.println("Nome Cliente: " +nomeCliente);
        System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=");

    }
}
