import java.util.ArrayList;

public static void main() {
    ArrayList<Pessoa> lista = new ArrayList<>();

    lista.add(new Pessoa("Nava", "Rua 10, 1", "1234"));
    lista.add(new Pessoa("Ana", "Rua 10, 1", "1234"));
    lista.add(new Pessoa("João", "Rua 10, 1", "1234"));
    lista.add(new Pessoa("Carlos", "Rua 10, 1", "1234"));

//    for(int i = 0; i < lista.size(); i++) {
//        System.out.println(lista.get(i));
//    }

//    for (Pessoa pessoa : lista) {
//        System.out.println(pessoa);
//    }

    lista.forEach(pessoa -> { System.out.println(pessoa);});
}