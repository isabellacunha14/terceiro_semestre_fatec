package exception;

/**
 * Classe de exceção customizada para o sistema de Caixa.
 * Encapsula os erros de regras de negócio (como depósito inválido ou saldo insuficiente)
 * utilizando códigos de erro internos ("errNumber") e traduzindo-os para mensagens claras.
 */
public class CaixaException extends Exception {
    private String errNumber;

    /**
     * Construtor da exceção.
     *
     * @param errNumber Uma string representando o código numérico do erro ocorrido
     *                  (ex: "RF01EX01" ou "RF01EX02").
     */
    public CaixaException(String errNumber){
        this.errNumber  = errNumber;
    }

    /**
     * Sobrescreve o método getMessage da classe mãe (Exception).
     * Analisa o código de erro cadastrado na instância e retorna uma mensagem
     * descritiva em português para ser exibida ao usuário.
     *
     * @return Uma String contendo a explicação exata do motivo da falha.
     */
    @Override
    public String getMessage() {
        String msg = "";
        if(errNumber.equals("RF01EX01")){
            msg = "Valor inválido para depósito";
        }else if(errNumber.equals("RF01EX02")){
            msg = "Saldo insuficiente para o saque";
        }else{
            msg = "Aconteceu um erro. Contate o Adm";
        }
        return msg;
    }
}