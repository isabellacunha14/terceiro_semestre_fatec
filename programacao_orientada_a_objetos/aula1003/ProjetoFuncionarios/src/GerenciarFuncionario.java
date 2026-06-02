import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarFuncionario {
    public List<Funcionario> funcionarios = new ArrayList<>();

    static void main() {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        GerenciarFuncionario gerenciar = new GerenciarFuncionario();
        do {
            System.out.println(">>>>> MENU PRINCIPAL <<<<<");
            System.out.println("1.. Cadastrar Funcionario");
            System.out.println("2.. Bonificar Funcionario");
            System.out.println("3.. Pesquisar Funcioanrio");
            System.out.println("4.. Listar Todos");
            System.out.println("5.. Excluir um Funcionario");
            System.out.println("6.. Inativar Funcionario");
            System.out.println("7.. Listar Funcionarios Inativos");
            System.out.println("8.. Listar Funcionarios Ativos");
            System.out.println("9.. SAIR");
            System.out.print(">>>>> ESCOLHA A OPCAO: ");
            opcao = Integer.parseInt(sc.nextLine());
            switch (opcao) {
                case 1 -> gerenciar.execCadastrar();
                case 2 -> gerenciar.execBonificar();
                case 3 -> gerenciar.execConsultar();
                case 4 -> gerenciar.execListarTodos();
                case 5 -> gerenciar.execExcluir();
                case 6 -> gerenciar.execInativar();
                case 7 -> gerenciar.execListarInativos();
                case 8 -> gerenciar.execListarAtivos();
                case 9 -> System.out.println("FIM");
                default -> System.out.println("Opcao invalida");
            }
        } while (opcao != 9);
    }

    private void execListarAtivos() {
        System.out.println("Imprimindo os Funcionarios ATIVOS");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        for (Funcionario f : funcionarios) {
            if (f.isAtivo()) {
                System.out.println(f.toString());
            }
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    private void execListarInativos() {
        System.out.println("Imprimindo os INATIVOS");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
        for (Funcionario f : funcionarios) {
            if (f.isAtivo() == false) {
                System.out.println(f.toString());
            }
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
    }

    private void execInativar() {
        Scanner sc = new Scanner(System.in);
        String rgProc;
        System.out.println("Digite o RG da pessoa a inativar: ");
        rgProc = sc.nextLine();
        //varrer lista a procura do funcionario com esse RG.
        Funcionario funcionarioProc = encontrarFuncionario(rgProc);

        if (funcionarioProc != null) {
            funcionarioProc.setAtivo(false);
            System.out.println("Funcionario inativado com sucesso");
        } else {
            System.out.println("Funcionario nao encontrado...");
        }
    }

    private void execExcluir() {
        Scanner sc = new Scanner(System.in);
        String rgProc;
        System.out.println("Digite o RG da pessoa a ser excluida: ");
        rgProc = sc.nextLine();
        //varrer lista a procura do funcionario com esse RG.
        Funcionario funcionarioProc = encontrarFuncionario(rgProc);
        if (funcionarioProc != null) {
            funcionarios.remove(funcionarioProc);
            System.out.println("Funcionario excluido com sucesso");
        } else {
            System.out.println("Funcionario nao encontrado...");
        }
    }

    private Funcionario encontrarFuncionario(String rgProc) {
        for (Funcionario func : funcionarios) {
            if (func.getRg().equals(rgProc)) {
                return func;
            }
        }
        return null;
    }

    public void execCadastrar() {
        Scanner sc = new Scanner(System.in);
        Funcionario func = new Funcionario();
        System.out.println("Cadastro de novo funcionario...");
        System.out.println("Digite o nome do funcioario: ");
        func.setNome(sc.nextLine());
        System.out.println("Digite o RG do funcionario: ");
        func.setRg(sc.nextLine());
        System.out.println("Digite o departamento: ");
        func.setDepartamento(sc.nextLine());
        System.out.println("Digite o salario do funcionario: ");
        func.setSalario(Double.parseDouble(sc.nextLine()));
        func.setAtivo(true);
        funcionarios.add(func); //adicionando o funcionario a minha lista de funcs.
        System.out.println("Cadastro efetuado com sucesso");
    }

    public void execConsultar() {
        Scanner sc = new Scanner(System.in);
        String rgProc;
        System.out.println("Digite o RG da pessoa procurada: ");
        rgProc = sc.nextLine();
        //varrer lista a procura do funcionario com esse RG.
        Funcionario funcionarioProc = encontrarFuncionario(rgProc);
        if (funcionarioProc != null) {
            System.out.println(funcionarioProc.toString());
        } else {
            System.out.println("Funcionario nao encontrado...");
        }
    }

    public void execBonificar() {
        Scanner sc = new Scanner(System.in);
        String rgProc;
        System.out.println("Digite o RG da pessoa a bonificar: ");
        rgProc = sc.nextLine();
        //varrer lista a procura do funcionario com esse RG.
        Funcionario funcionarioProc = encontrarFuncionario(rgProc);
        if (funcionarioProc != null) {
            //precisa bonificar com o valor dado pelo usuario
            double valor;
            System.out.println("Digite o valor da bonificacao em reais");
            valor = Double.parseDouble(sc.nextLine());
            funcionarioProc.bonificar(valor);
            System.out.println("Bonificacao efetuada com sucesso");
        } else {
            System.out.println("Funcionario nao encontrado");
        }
    }

    public void execListarTodos() {
        for (Funcionario f : funcionarios) {
            System.out.println(f.toString());
            System.out.println();
        }
    }
}
