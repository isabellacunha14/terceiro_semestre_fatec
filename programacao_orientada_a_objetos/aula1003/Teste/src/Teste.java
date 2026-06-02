public class Teste {

    void alterar(int a){
        a = a + 5;
        System.out.println(a);
    }
    static void main() {
        int a = 10;
        Teste teste1 = new Teste();
        teste1.alterar(a);
        System.out.println("Valor de a: " +a);
    }


}
