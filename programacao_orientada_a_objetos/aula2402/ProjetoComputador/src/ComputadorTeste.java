public class ComputadorTeste {
    public static void main(String[] args) {
        //Primeira etapa. primeiro objeto
        Computador computador = new Computador();
        computador.marca = "HP";
        computador.modelo = "Pavilon";
        computador.cor = "Prata";
        computador.numeroSerie = 1234;
        computador.preco = 3000.0;
        computador.imprimir();
        computador.calcularValor();
        computador.imprimir();

        Computador computador2 = new Computador();
        computador2.marca = "IBM";
        computador2.modelo = "Velho";
        computador2.cor = "Preta";
        computador2.numeroSerie = 2345;
        computador2.preco = 1000.0;
        computador2.imprimir();
        computador2.calcularValor();
        computador2.imprimir();

        boolean alterou = computador2.alterarValor(-2500.0);
        if(alterou){
            System.out.println("Valor Alterado com Sucesso!");
        }else{
            System.out.println("Valor com Erro");
        }
        computador2.imprimir();

    }
}
