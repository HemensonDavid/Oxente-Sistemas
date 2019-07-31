package model;

import java.util.ArrayList;

public class Util {

    public static String reescreverVirgulaParaPonto(String palavra) {
        palavra = palavra.replace(',', '.');
        return palavra;
    }

    public static String transformarArrayDeCharParaString(char[] caracteres) {
        String palavra = "";

        for (int i = 0; i < caracteres.length; i++) {
            palavra += caracteres[i];
        }

        return palavra;
    }

    public static String concatenarNomes(ArrayList<Funcionario> funcionarios) {
        String mensagem = "";

        for (int i = 0; i < funcionarios.size(); i++) {
            mensagem = mensagem + funcionarios.get(i).getNome() + "\n";
        }

        return mensagem;
    }
}
