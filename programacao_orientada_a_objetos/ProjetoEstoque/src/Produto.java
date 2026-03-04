public class Produto {
    public int idProduto;
    public String nome;
    public int quantidade;
    public double preco;

    public boolean darBaixa (int qtde){
        if(qtde <= quantidade){
            quantidade -= qtde;
            return true;
        }
        return false;
    }

    public void darEntrada(int qtde){
        quantidade +=qtde;
    }

    public void imprimir(){
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        System.out.println("idProduto = " + idProduto);
        System.out.println("Nome = " + nome);
        System.out.println("Quantidade = " + quantidade);
    }

}