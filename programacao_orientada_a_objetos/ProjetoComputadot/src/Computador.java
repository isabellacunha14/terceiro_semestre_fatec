public class Computador {

    //1. Atributos
    public String marca;
    public String cor;
    public String modelo;
    public long numeroSerie;
    public double preco;

    //2.Metodos

    public void imprimir(){
        System.out.println("Marca: " + marca);
        System.out.println("Cor: " +cor);
        System.out.println("Modelo: " + modelo);
        System.out.println("Numero Serie: " +numeroSerie);
        System.out.println("Preco: " +preco);
    }

    public void calcularValor(){
        if(marca == "HP"){
            preco *= 1.30;
            return;
        }
        if(marca == "IBM"){
            preco *= 1.50;
        }
        return;
    }

    public double alterarValor(double valor){

    }

}
