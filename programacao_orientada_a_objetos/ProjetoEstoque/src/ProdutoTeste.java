import java.util.Scanner;

public class ProdutoTeste {
    Produto prod = new Produto();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProdutoTeste teste = new ProdutoTeste();
        int opcao;

        do {
            System.out.println("-----Menu-----");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Entrada de Produto");
            System.out.println("3. Venda (Saída)");
            System.out.println("4. Consultar Produto");
            System.out.println("0. Sair");
            System.out.println("Digite sua opcao");
            opcao = Integer.parseInt(sc.nextLine());
            switch (opcao) {
                case 1 -> teste.execCadastro();
                case 2 -> teste.execEntrada();
                case 3 -> teste.execSaida();
                case 4 -> teste.execConsulta();
                case 0 -> System.out.println("Fim");
                default -> System.out.println("Opcao Invalida");
            }
        } while (opcao != 0);
    }
        public void execConsulta(){
            prod.imprimir();
        }

        public void execCadastro(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o ID do produto");
            prod.idProduto = sc.nextInt();
            System.out.println("Digite o nome do produto");
            prod.nome = sc.nextLine();
            System.out.println("Digite o preco do produto");
            prod.preco = sc.nextDouble();
            System.out.println("Produto cadastrado com sucesso!");
        }

        public void execEntrada(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o valor a ser depositado: ");
            int qtde = sc.nextInt(sc.nextInt());
            prod.darEntrada(qtde);
            System.out.println("Depositado com sucesso");
        }


        public void execSaida(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o valor a quantidade: ");
            int qtde = sc.nextInt(sc.nextInt());
            boolean saida = prod.darBaixa(qtde);
            if(saida){
                System.out.println("Saida efetuada com sucesso");
            }else{
                System.out.println("Sem quantidade suficiente");
            }
        }

    }

