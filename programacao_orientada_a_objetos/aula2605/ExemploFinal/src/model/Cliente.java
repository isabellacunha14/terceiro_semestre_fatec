package model;

import view.GerenciarAcesso;

public class Cliente implements Logavel {
    @Override
    public void login() {
        System.out.println("Cliente logou");
        GerenciarAcesso.logados.add(this);
    }

    @Override
    public void logout() {
        System.out.println("Cliente saiu do sistema");
        GerenciarAcesso.logados.remove(this);
    }
}
