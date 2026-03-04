import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public int idCliente;
    public String nome;
    public String email;
    public List<Carro> carros = new ArrayList<>();

    public void imprimir(){
        System.out.println("Dados do cliente e seus automoveis:");
        System.out.println("=-==-=--=-=-=-=-=-=-=--=-=-=-=-=--=-=");
        System.out.println("idCliente = " + idCliente);
        System.out.println("Nome = " + nome);
        System.out.println("E-mail = " + email);
        System.out.println(" Lista de carros:");
        for (Carro carro: carros){
            carro.imprimir();
        }
        System.out.println("Total de carros: " + carros.size()) ;
        System.out.println("=-=-=-=--=-=-=-=--=-=-=-=-=-=-=-=-=");
    }

    public void adicionarCarro(Carro carro){
        carros.add(carro); // adiciona na lista
    }

}
