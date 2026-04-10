package modelo;

public class Cliente {
    private String nome;
    private String cpf;
    private boolean mensalista;

    public Cliente(String nome, String cpf, boolean mensalista) {
        this.nome = nome;
        this.cpf = cpf;
        this.mensalista = mensalista;
    }

    public boolean isMensalista() {
        return mensalista;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
}