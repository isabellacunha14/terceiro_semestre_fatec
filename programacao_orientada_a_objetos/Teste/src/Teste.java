public class Teste {

    void alterar(int a){
        a = a + 5 ;
        System.out.println(a);
    }
    public static void main(String[] args) {
        int a = 10;
        Teste teste1 = new Teste();
        teste1.alterar(a);
        System.out.println("Valor de a: " +a);
    }
}
