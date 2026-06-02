import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public int idCliente;
    public String nome;
    public String email;
    public List<Carro> carros = new ArrayList<>();


    public void imprimir() {
        System.out.println("Dados da pessoa e seus automóveis");
        System.out.println("---------------------------------");
        System.out.println("idCliente = " + idCliente);
        System.out.println("nome = " + nome);
        System.out.println("email = " + email);
        System.out.println("Lista de seus carros: ");
        for (Carro carro : carros) {
            carro.imprimir();
        }
        System.out.println("Total de Carros: " +  carros.size());
        System.out.println("---------------------------------");
    }

    public void adicionarCarro(Carro carro) {
        carros.add(carro); //adiciona na lista
    }
}
