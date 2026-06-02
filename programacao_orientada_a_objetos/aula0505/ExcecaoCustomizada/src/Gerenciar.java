import view.CaixaView;

/**
 * Classe principal responsável por inicializar a aplicação.
 * Serve como o ponto de partida para a execução do sistema de gerenciamento de caixa.
 */
public class Gerenciar {

    /**
     * Ponto de entrada do programa.
     * Instancia a interface de usuário (CaixaView), o que por sua vez inicia
     * o loop do menu principal da aplicação.
     *
     * Nota: Em Java padrão, a assinatura recomendada seria "public static void main(String[] args)".
     */
    static void main() {
        CaixaView ui = new CaixaView();
    }
}