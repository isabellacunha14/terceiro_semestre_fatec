public class Funcionario {
    //1. Atributos
    private String nome;
    private String departamento;
    private double salario;
    private String rg;
    private boolean ativo;

    //Método construtor padrão
    public Funcionario(){

    }

    //Metodos getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void bonificar(double valor){
        if(valor > 0){
            salario += valor;
            System.out.println("Bonificado com sucesso");
        }else{
            System.out.println("Impossivel bonifica com 0 ou menos reais");
        }
    }
    @Override
    public String toString(){
       StringBuilder sb = new StringBuilder();
       sb.append("Dados do Funcionario: \n");
       sb.append("Nome: ").append(nome).append("\n");
       sb.append("RG: ").append(rg).append("\n");
       sb.append("Departamento: ").append(departamento).append("\n");
       sb.append("Salario R$ ").append(salario).append("\n");
       String str_ativo = ativo ? "Funcionario Ativo" : "Funcionario Inativo";
       sb.append(str_ativo).append("\n");
       return sb.toString();
    }
}
