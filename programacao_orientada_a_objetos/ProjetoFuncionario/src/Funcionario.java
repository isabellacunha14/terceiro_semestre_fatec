public class Funcionario {
    //1.atributos
    private String nome;
    private String departamento;
    private double salario;
    private String rg;
    private boolean ativo;

    //Metodo contrutor padrao
    public Funcionario(){

    }

    //Metodos getters and setters

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void bonificar(double valor){
            if(valor>0){
                salario += valor;
            } else{
                System.out.println("Impossivel bonificar com 0 ou menos reais");
            }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Dados do Funcionario: ");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("RG: ").append(rg).append("\n");
        sb.append("Departamento: ").append(departamento).append("\n");
        sb.append("Salario: ").append(salario).append("\n");
        String str_ativo = ativo ? "Funcionario Ativo" : "Funcionario Inativo";
        sb.append(str_ativo).append("\n");
        return sb.toString();

    }
}
