public abstract class Produto {
    private String descricao;
    private double precoCusto;
    private double precoVenda;
    private int estoqueDisponivel;

    //metodo concreto
    public Produto(String descricao, double precoCusto,double precoVenda, int estoqueDisponivel ){
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.estoqueDisponivel = estoqueDisponivel;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getEstoqueDisponivel() {
        return estoqueDisponivel;
    }

    public void setEstoqueDisponivel(int estoqueDisponivel) {
        this.estoqueDisponivel = estoqueDisponivel;
    }

    // Metodo abstrato
    public abstract void calcularPrecoVenda();

    public void vender(int qtd) throws EstoqueInsuficienteException {

        if (qtd > estoqueDisponivel) {
            throw new EstoqueInsuficienteException(
                    "Estoque insuficiente. Disponível: " + estoqueDisponivel
            );
        }

        estoqueDisponivel -= qtd;
    }

}
