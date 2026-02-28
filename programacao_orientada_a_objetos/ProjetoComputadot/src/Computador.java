public class Computador {

    //1. Atributos
    public String marca;
    public String cor;
    public String modelo;
    public long numeroSerie;
    public double preco;

    //2.Metodos

    public void imprimir(){
        System.out.println("----------------------------");
        System.out.println();
        System.out.println("Marca: " + marca);
        System.out.println("Cor: " +cor);
        System.out.println("Modelo: " + modelo);
        System.out.println("Numero Serie: " +numeroSerie);
        System.out.println("Preco: " +preco);
        System.out.println("----------------------------");
        System.out.println();
    }

    public void calcularValor(){
        if(marca.equalsIgnoreCase("HP")){
            preco *= 1.3;
            return;
        }
        if(marca.equalsIgnoreCase("IBM")){
            preco *= 1.5;
        }
    }

    public int alterarValor(double valor){
        if(valor > 0){
            preco = valor;
            return 1;
        }
        return 0;
    }

}
