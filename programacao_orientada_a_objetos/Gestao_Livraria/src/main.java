import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Produto> produtos = new ArrayList<>();

        int opcao = 0;

        while (opcao != 4) {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Livro e DVD");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Simular Venda");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    // Cadastro do Livro
                    System.out.println("\n=== CADASTRO DE LIVRO ===");

                    System.out.print("Descrição: ");
                    String descLivro = sc.nextLine();

                    System.out.print("Preço de custo: ");
                    double precoLivro = sc.nextDouble();

                    System.out.print("Estoque disponível: ");
                    int estoqueLivro = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    Livro livro = new Livro(
                            descLivro,
                            precoLivro,
                            0,
                            estoqueLivro,
                            autor
                    );

                    livro.calcularPrecoVenda();

                    produtos.add(livro);

                    // Cadastro do DVD
                    System.out.println("\n=== CADASTRO DE DVD ===");

                    System.out.print("Descrição: ");
                    String descDvd = sc.nextLine();

                    System.out.print("Preço de custo: ");
                    double precoDvd = sc.nextDouble();

                    System.out.print("Estoque disponível: ");
                    int estoqueDvd = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Diretor: ");
                    String diretor = sc.nextLine();

                    System.out.print("Cotação do dólar: ");
                    double cotacao = sc.nextDouble();
                    sc.nextLine();

                    Dvd dvd = new Dvd(
                            descDvd,
                            precoDvd,
                            0,
                            estoqueDvd,
                            diretor
                    );

                    dvd.calcularPrecoVenda(cotacao);

                    produtos.add(dvd);

                    System.out.println("\nProdutos cadastrados com sucesso!");

                    break;


                case 2:

                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                        break;
                    }

                    for (int i = 0; i < produtos.size(); i++) {

                        Produto p = produtos.get(i);

                        System.out.println("\nProduto #" + i);
                        System.out.println("Descrição: " + p.getDescricao());
                        System.out.println("Preço Venda: " + p.getPrecoVenda());
                        System.out.println("Estoque: " + p.getEstoqueDisponivel());

                        if (p instanceof Livro) {
                            Livro l = (Livro) p;
                            System.out.println("Autor: " + l.getAutor());
                        }

                        if (p instanceof Dvd) {
                            Dvd d = (Dvd) p;
                            System.out.println("Diretor: " + d.getDiretor());
                        }
                    }

                    break;

                case 3:

                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                        break;
                    }

                    System.out.println("Produtos:");

                    for (int i = 0; i < produtos.size(); i++) {

                        System.out.println(
                                i + " - " +
                                        produtos.get(i).getDescricao()
                        );
                    }

                    System.out.print("Escolha o produto: ");
                    int indice = sc.nextInt();

                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();

                    try {

                        produtos.get(indice).vender(qtd);

                        System.out.println("Venda realizada!");

                    } catch (EstoqueInsuficienteException e) {

                        System.out.println("Erro: " + e.getMessage());

                    } catch (IndexOutOfBoundsException e) {

                        System.out.println("Produto inexistente.");

                    }

                    break;

                case 4:

                    System.out.println("Programa encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}
