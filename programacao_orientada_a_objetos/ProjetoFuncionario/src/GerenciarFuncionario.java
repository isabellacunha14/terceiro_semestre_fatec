import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarFuncionario {
    public List<Funcionario> funcionarios = new ArrayList<>();

    public static void main(String[] args) {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        GerenciarFuncionario gerenciar = new GerenciarFuncionario();
        do{
            System.out.println(">>>> MENU PRINCIPAL <<<<");
            System.out.println("1. Cadastrar Funcionario");
            System.out.println("2. Bonificar Funcionario");
            System.out.println("3. Pesquisar Funcionario");
            System.out.println("4. Listar Todos");
            System.out.println("5. Excluir funcionario");
            System.out.println("6. Inativar Funcionario");
            System.out.println("7. Listar Funcionario Inativos");
            System.out.println("8. Listar Funcionarios Ativos");
            System.out.println("9. Sair");
            System.out.println(">>>> ESCOLHA A OPCAO <<<<");

            opcao = Integer.parseInt(sc.nextLine());

            switch(opcao){
                case 1 -> gerenciar.execCadastrar();
                case 2 -> gerenciar.execBonificar();
                case 3 -> gerenciar.execConsultar();
                case 4 -> gerenciar.execListarTodos();
                //case 5 ->
                //case 6 ->
                //case 7 ->
                //case 8 ->
                case 9 -> System.out.println("Fim");
                default -> System.out.println("Opcao invalida");
            }
        }while(opcao!=9);

    }

    public void execCadastrar(){
        Scanner sc = new Scanner(System.in);
        Funcionario func = new Funcionario();
        System.out.println("Cadastro de um novo funcionario: ");
        System.out.println("Digite o nome do funcionario: ");
        func.setNome(sc.nextLine());
        System.out.println("Digite o RG do funcionario: ");
        func.setRg(sc.nextLine());
        System.out.println("Digite o departamento: ");
        func.setDepartamento(sc.nextLine());
        System.out.println("Digite o salario: ");
        func.setSalario(Double.parseDouble(sc.nextLine()));
        func.setAtivo(true);
        funcionarios.add(func); //adicionando o funcionario a lista
        System.out.println("Cadastro efetuado com sucesso");
    }

    public void execConsultar(){
        Scanner sc = new Scanner(System.in);
        String rgProc;
        System.out.println("Digite o RG da pessoa a ser procurado: ");
        rgProc = sc.nextLine();
        //varrer a lista a procura do funcionario do rg digitado
        Funcionario funcionarioProc = null;
        for(Funcionario func: funcionarios){
            if(func.getRg().equals(rgProc)){
                funcionarioProc = func; //achou o funcionario
                break;
            }
        }
        if(funcionarioProc != null){
            System.out.println(funcionarioProc.toString());
        } else {
            System.out.println("Funcionario nao encontrado");
        }
    }

    public void execBonificar(){
        Scanner sc = new Scanner(System.in);
        String rgProc;
        System.out.println("Digite o RG da pessoa a ser bonificada: ");
        rgProc = sc.nextLine();
        //varrer a lista a procura do funcionario do rg digitado
        Funcionario funcionarioProc = null;
        for(Funcionario func: funcionarios){
            if(func.getRg().equals(rgProc)){
                funcionarioProc = func; //achou o funcionario
                break;
            }
        }
        if(funcionarioProc != null){
            //precisa bonificar pelo valor do usuario
            double valor;
            System.out.println("Digite o valor da bonificacao em reais:");
            valor = Double.parseDouble(sc.nextLine());
            funcionarioProc.bonificar(valor);
        } else{
            System.out.println("Funcionario nao encontrado");
        }
    }

    public void execListarTodos(){

    }

}
