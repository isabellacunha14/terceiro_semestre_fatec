import model.Conta;
import model.Corrente;
import model.Poupanca;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class GerenciarBanco {
    static List<Conta> listConta = new ArrayList<>();

    static void main() {
        Corrente conta1 = new Corrente(1, "Mogi Mirim", "maromo", 2000);
        Poupanca poupanca1 = new Poupanca(101, "MM", "Maromo", 2.0);
        listConta.add(conta1);
        listConta.add(poupanca1);
        conta1.depositar(5000);
        conta1.sacar(500);
        System.out.println(conta1);
        poupanca1.depositar(3000);
        poupanca1.sacar(2000);
        System.out.println(poupanca1);
        System.out.println("Saldo de todas as contas no momento: " + patrimonioBanco());
    }

    public static double patrimonioBanco(){
        double total = 0.0;
        for (Conta x : listConta){
            total += x.getSaldo();
        }
        return total;
    }
}
