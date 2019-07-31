package model;

import java.util.ArrayList;

public class Empresa {

    public ArrayList<Funcionario> listarFuncionariosDeUmLocalX(ArrayList<Funcionario> funcionarios, String localX) {
        ArrayList<Funcionario> funcionarioAux = new ArrayList<Funcionario>();
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getCidade().equalsIgnoreCase(localX) || funcionarios.get(i).getEstado().equalsIgnoreCase(localX)) {
                funcionarioAux.add(funcionarios.get(i));
            }
        }

        return funcionarioAux;
    }

    public ArrayList<Funcionario> listarFuncionariosQueGanhamAcimaDe5000(ArrayList<Funcionario> funcionarios) {
        ArrayList<Funcionario> funcionarioAux = new ArrayList<Funcionario>();
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getSalario() >= 5000.00) {
                funcionarioAux.add(funcionarios.get(i));
            }
        }
        return funcionarioAux;
    }

    public ArrayList<Funcionario> listarFuncionariosGanhandoEntre1000e2000QueSaoDaPB(ArrayList<Funcionario> funcionarios) {
        ArrayList<Funcionario> funcionarioAux = new ArrayList<Funcionario>();
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getEstado().equalsIgnoreCase("PB") && funcionarios.get(i).getSalario() >= 1000.00 && funcionarios.get(i).getSalario() <= 2000.00) {
                funcionarioAux.add(funcionarios.get(i));
            }
        }
        return funcionarioAux;
    }

    public ArrayList<Funcionario> listarFuncionariosQueGanhamAbaixo1000(ArrayList<Funcionario> funcionarios) {
        ArrayList<Funcionario> funcionarioAux = new ArrayList<Funcionario>();
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getSalario() <= 1000.00) {
                funcionarioAux.add(funcionarios.get(i));
            }
        }
        return funcionarioAux;
    }

    public ArrayList<Funcionario> listarFuncionariosHomens(ArrayList<Funcionario> funcionarios) {
        ArrayList<Funcionario> funcionarioAux = new ArrayList<Funcionario>();
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getSexo() == 'M') {
                funcionarioAux.add(funcionarios.get(i));
            }
        }
        return funcionarioAux;
    }

    public ArrayList<Funcionario> listarFuncionariosHomensGanhandoAcimaDe800(ArrayList<Funcionario> funcionarios) {
        ArrayList<Funcionario> funcionarioAux = new ArrayList<Funcionario>();
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getSexo() == 'M' && funcionarios.get(i).getSalario() > 800) {
                funcionarioAux.add(funcionarios.get(i));
            }
        }
        return funcionarioAux;
    }

    public ArrayList<Funcionario> listarFuncionariosQueComecaComALetraIndicada(ArrayList<Funcionario> funcionarios, String letraProcurada) {
        ArrayList<Funcionario> funcionarioAux = new ArrayList<Funcionario>();
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNome().substring(0, 1).equalsIgnoreCase(letraProcurada)) {
                funcionarioAux.add(funcionarios.get(i));
            }
        }
        return funcionarioAux;
    }

    public ArrayList<Funcionario> listarFuncionariosCadeirantes(ArrayList<Funcionario> funcionarios) {
        ArrayList<Funcionario> funcionarioAux = new ArrayList<Funcionario>();
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getDeficiencia().equalsIgnoreCase("cadeirante")) {
                funcionarioAux.add(funcionarios.get(i));
            }
        }
        return funcionarioAux;
    }

    public int aposentadoria(ArrayList<Funcionario> funcionarios, String nomeDaPessoaASerProcurada) {
        int quantidadeDeAnosQueFaltaParaSeAposentar = -1;
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNome().equalsIgnoreCase(nomeDaPessoaASerProcurada)) {
                if (funcionarios.get(i).getSexo() == 'M') {
                    quantidadeDeAnosQueFaltaParaSeAposentar = 65 - funcionarios.get(i).getIdade();
                } else {
                    quantidadeDeAnosQueFaltaParaSeAposentar = 60 - funcionarios.get(i).getIdade();
                }
            }

        }
        return quantidadeDeAnosQueFaltaParaSeAposentar;
    }

    public static Funcionario pesquisarFuncionarioPorMatricula(ArrayList<Funcionario> funcionarios, String matricula) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (matricula.equals(funcionarios.get(i).getMatricula())) {
                return funcionarios.get(i);
            }
        }

        return null;
    }

    public static Funcionario pesquisarFuncionarioPorCPF(ArrayList<Funcionario> funcionarios, String cpf) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (cpf.equals(funcionarios.get(i).getCPF())) {
                return funcionarios.get(i);
            }
        }

        return null;
    }

    public static ArrayList<Funcionario> getFuncionariosMaisVelhos(ArrayList<Funcionario> funcionarios) {
        ArrayList<Funcionario> funcionariosMaisVelhos = new ArrayList<Funcionario>();
        int auxDeIdade = funcionarios.get(0).getIdade();

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getSexo() == 'M' && funcionarios.get(i).getIdade() > auxDeIdade) {
                auxDeIdade = funcionarios.get(i).getIdade();
            }
        }

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getSexo() == 'M' && funcionarios.get(i).getIdade() == auxDeIdade) {
                funcionariosMaisVelhos.add(funcionarios.get(i));
            }
        }

        return funcionariosMaisVelhos;
    }

    public static ArrayList<Funcionario> getFuncionariosMaisNovos(ArrayList<Funcionario> funcionarios) {
        ArrayList<Funcionario> funcionariosMaisNovos = new ArrayList<Funcionario>();
        int auxDeIdade = funcionarios.get(0).getIdade();

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getSexo() == 'M' && funcionarios.get(i).getIdade() < auxDeIdade) {
                auxDeIdade = funcionarios.get(i).getIdade();
            }
        }

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getSexo() == 'M' && funcionarios.get(i).getIdade() == auxDeIdade) {
                funcionariosMaisNovos.add(funcionarios.get(i));
            }
        }

        return funcionariosMaisNovos;
    }

    public static ArrayList<Funcionario> getFuncionariosComMaiorSalario(ArrayList<Funcionario> funcionarios) {
        ArrayList<Funcionario> funcionariosComMaiorSalario = new ArrayList<>();
        double auxDeMaiorSalario = funcionarios.get(0).getSalario();

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getSalario() > auxDeMaiorSalario) {
                auxDeMaiorSalario = funcionarios.get(i).getSalario();
            }
        }

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getSalario() == auxDeMaiorSalario) {
                funcionariosComMaiorSalario.add(funcionarios.get(i));
            }
        }

        return funcionariosComMaiorSalario;
    }

    public static ArrayList<Funcionario> getFuncionariasComMenorSalario(ArrayList<Funcionario> funcionarios) {
        ArrayList<Funcionario> funcionariasComMenorSalario = new ArrayList<>();
        double auxDeMenorSalario = funcionarios.get(0).getSalario();

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getSexo() == 'F' && funcionarios.get(i).getSalario() <= auxDeMenorSalario) {
                auxDeMenorSalario = funcionarios.get(i).getSalario();
            }
        }

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getSexo() == 'F' && funcionarios.get(i).getSalario() == auxDeMenorSalario) {
                funcionariasComMenorSalario.add(funcionarios.get(i));
            }
        }

        return funcionariasComMenorSalario;
    }

}
