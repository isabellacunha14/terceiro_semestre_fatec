public class TesteRef {
    public int registro;
    public String nome;
    public int idade;

    void alterar(TesteRef obj){
        obj.registro = 5;
        obj.nome = "Maria";
        obj.idade = 40;
        obj.imprimir();
    }
    static void main() {
        TesteRef objeto = new TesteRef();
        objeto.registro = 1;
        objeto.nome = "Oscar";
        objeto.idade = 35;
        objeto.alterar(objeto);
        objeto.imprimir();
    }
    void imprimir(){
        System.out.println("registro = " + registro);
        System.out.println("nome = " + nome);
        System.out.println("idade = " + idade);
    }


}
