package model;

import view.GerenciarAcesso;

public class Secretaria extends Funcionario implements Logavel {

    @Override
    public void login() {
        System.out.println("Secretaria logou");
        GerenciarAcesso.logados.add(this);
    }

    @Override
    public void logout() {
        System.out.println("Secretaria saiu do sistema");
        GerenciarAcesso.logados.remove(this);
    }
}
