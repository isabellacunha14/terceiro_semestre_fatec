public class Teste {
    public static void main(String[] args) {
        String str_valor = "2000";
        int qtd = 3;

        int valor = Integer.parseInt(str_valor);
        int mult = qtd * valor;
        System.out.println(mult);

        String str_mult = Integer.toString(mult);
        System.out.println("Texto res: " + str_mult);
    }
}
