package view;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class GerenciarAcesso {
    public static List<Logavel> logados = new ArrayList<>();

    static void main() {
        Operador operador = new Operador();
        Secretaria secretaria = new Secretaria();
        Gerente gerente = new Gerente();
        Fornecedor fornecedor = new Fornecedor();
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        //Efetuando o login
        secretaria.login();
        gerente.login();
        fornecedor.login();
        cliente1.login();
        cliente2.login();
        GerenciarAcesso ga = new GerenciarAcesso();
        ga.exibirLogados();
        cliente1.logout(); //Cliente 1 saiu do sistema
        ga.exibirLogados();
    }

    public void exibirLogados(){
        System.out.println("Logados no Momento: " + logados.size() + " pessoas");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Lista:");
        for(Logavel logado : logados){
            System.out.println(logado.getClass() + " com Hash: " + logado.hashCode());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
