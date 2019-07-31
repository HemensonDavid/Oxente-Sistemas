package model;

public class Funcionario {

    private String nome;
    private String cpf;
    private String matricula;
    private String estado;
    private String cidade;
    private char sexo;
    private double salario;
    private int idade;
    private String deficiencia = "";

    //Construtores
    public Funcionario(String nome, String cpf, String matricula, String estado, String cidade, char sexo, double salario, int idade, String deficiencia) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.estado = estado;
        this.cidade = cidade;
        this.sexo = sexo;
        this.salario = salario;
        this.idade = idade;
        if (deficiencia.equals("")) {
            this.deficiencia = null;
        } else {
            this.deficiencia = deficiencia;
        }

    }

    public Funcionario() {
    }

    //Gets
    public String getNome() {
        return this.nome;
    }

    public String getCPF() {
        return this.cpf;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getCidade() {
        return this.cidade;
    }

    public char getSexo() {
        return this.sexo;
    }

    public double getSalario() {
        return this.salario;
    }

    public String getDeficiencia() {
        return this.deficiencia;
    }

    public int getIdade() {
        return this.idade;
    }

    //sets
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setDeficiencia(String deficiencia) {
        this.deficiencia = deficiencia;
    }

    //toString
    public String toString() {
        if (this.deficiencia.equals("")) {
            return "* Funcionario: " + this.nome + "\n"
                    + " Sexo: " + this.sexo + "\n"
                    + " Idade: " + this.idade + "\n"
                    + " Cpf: " + this.cpf + "\n"
                    + " Matricula: " + this.matricula + "\n"
                    + " Cidade: " + this.cidade + "\n"
                    + " Estado: " + this.estado + "\n"
                    + " Salario: " + this.salario + "\n";
        } else {
            return "* Funcionario: " + this.nome + "\n"
                    + " Sexo: " + this.sexo + "\n"
                    + " Idade: " + this.idade + "\n"
                    + " Cpf: " + this.cpf + "\n"
                    + " Matricula: " + this.matricula + "\n"
                    + " Cidade: " + this.cidade + "\n"
                    + " Estado: " + this.estado + "\n"
                    + " Salario: " + this.salario + "\n"
                    + " Defici�ncia(s): " + this.deficiencia + "\n";
        }
    }
}
