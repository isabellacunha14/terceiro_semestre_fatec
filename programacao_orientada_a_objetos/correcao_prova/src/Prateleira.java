import java.util.List;

public class Prateleira {
    private int idPrateleira;
    private String categoria;
    private List<Livro> = new ArrayList<>();

    public void exibirCatalogo(){
        System.out.println("Dados da Prateleira:");
        System.out.println("Id: " + idPrateleira);
        System.out.println("Categoria: " +categoria);
        for(Livro l : livroList){
            System.out.println("Id Livro: " + l.getIdLivro());
            System.out.println("Titulo: " + l.getTitulo());
        }
    }
}
