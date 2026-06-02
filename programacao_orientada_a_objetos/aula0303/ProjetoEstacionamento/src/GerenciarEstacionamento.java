public class GerenciarEstacionamento {

    //Definir um cliente com dois carros
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.idCliente = 1;
        cliente.nome = "Pedro Zancopé";
        cliente.email = "pedro@gmail.com";

        Carro carro1 = new Carro();
        carro1.marca = "Fiat";
        carro1.modelo = "Palio";
        carro1.anoFab = 2011;
        carro1.placa = "FFF-0000";

        Carro carro2 = new Carro();
        carro2.marca = "Honda";
        carro2.modelo = "Civic";
        carro2.anoFab = 2019;
        carro2.placa = "FFF-1111";

        //Fazer a associacao dos dois carros com o cliente
        cliente.adicionarCarro(carro1);
        cliente.adicionarCarro(carro2);
        //Imprimir os dados cliente
        cliente.imprimir();
    }
}
