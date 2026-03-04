public class Carro {

    public String placa;
    public String marca;
    public String modelo;
    public int anoFab;

    public void imprimir(){
        System.out.println("Dados do carro: ");
        System.out.println("Placa: " + placa);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano Fabricação: " + anoFab);
    }
}
