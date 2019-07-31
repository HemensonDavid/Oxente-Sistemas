package model;

public class GeradorDeMatriculas {

    private int contDeMatriculas = 0;

    public String gerarMatricula(int idade, String nome, char sexo, String cpf) {
        String matricula;

        int propriedadeDeIdade = 0;
        int propriedadeDeSexo = 1;
        int propriedadeDeTamanhoDoNome = nome.length();

        if (idade >= 18 && idade <= 20) {
            propriedadeDeIdade = 20 + this.contDeMatriculas;
        } else if (idade >= 21 && idade <= 30) {
            propriedadeDeIdade = 30 + this.contDeMatriculas;
        } else {
            propriedadeDeIdade = 40 + this.contDeMatriculas;
        }

        if (sexo == 'M') {
            propriedadeDeSexo = 2 * (propriedadeDeIdade - 3) * propriedadeDeTamanhoDoNome;
        } else if (sexo == 'F') {
            propriedadeDeSexo = 3 * (propriedadeDeIdade - 2) * propriedadeDeTamanhoDoNome;
        }

        matricula = propriedadeDeIdade + propriedadeDeSexo + propriedadeDeTamanhoDoNome + cpf;
        return matricula;
    }
}
