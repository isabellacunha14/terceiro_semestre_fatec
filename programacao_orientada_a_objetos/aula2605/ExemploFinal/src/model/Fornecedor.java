package model;

import view.GerenciarAcesso;

public class Fornecedor implements Logavel {
    @Override
    public void login() {
        System.out.println("Fornecedor Logou");
        GerenciarAcesso.logados.add(this);
    }

    @Override
    public void logout() {
        System.out.println("Fornecedor saiu do sistema");
        GerenciarAcesso.logados.remove(this);
    }
}
