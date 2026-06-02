public class Dvd extends Produto{
    private String diretor;

    public Dvd(String descricao, double precoCusto,
               double precoVenda, int estoqueDisponivel,
               String diretor) {

        super(descricao, precoCusto, precoVenda, estoqueDisponivel);
        this.diretor = diretor;
    }

    @Override
    public void calcularPrecoVenda() {
        setPrecoVenda(getPrecoCusto() * 1.20);
    }

    // Sobrecarga
    public void calcularPrecoVenda(double cotacao) {
        setPrecoVenda(getPrecoCusto() * cotacao);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
