package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Empresa;
import model.Funcionario;
import model.Util;

public class GuiPrincipal extends JFrame {

    ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

    private Empresa empresa = new Empresa();
    private static final long serialVersionUID = 1L;
    private JPanel pnPrincipal = new JPanel();
    private JLabel lbMensagemInicial;
    private JMenuBar mbMenu = new JMenuBar();
    private JMenu mnOpcoes, mnFuncionario, mnAjuda;
    private JMenuItem miCadastrarFuncionario, miExcluirFuncionario, miAlterarFuncionario;
    private JMenuItem miPesquisarFuncionarioPorCPF, miPesquisarFuncionarioPorMatricula;
    private JMenuItem miMostrarFuncionarioDeMaiorSalario, miMostrarFuncionariaDeMenorSalario;
    private JMenuItem miMostrarFuncionarioMaisVelho, miMostrarFuncionarioMaisNovo;
    private JMenuItem miSobre;
    private JMenu mnListagemDeFuncionario;
    private JMenuItem miListarTodosOsFuncionarios, miListarFuncionariosDaCidadeInformada, miListarFuncionariosDoEstadoInformado;
    private JMenuItem miListarFuncionariosQueGanhamAcimaDe5000, miListarFuncionariosQueGanhamAbaixoDe1000;
    private JMenuItem miListarFuncionariosHomens, miListarFuncionariosHomensQueGanhamAcimaDe800;
    private JMenuItem miListarFuncionariosQueGanhamEntre1000e2000eSaoDaPB, miListarFuncionariosComALetraInformada;
    private JMenuItem miListarFuncionariosCadeirantes;
    private JMenuItem miAposentadoria;
    private JMenu mnListar, mnPesquisar;
    private String usuario;

    public GuiPrincipal(String usuario) {
        setTitle("Oxente Sistemas - Funcionários");
        this.usuario = usuario;
        iniciarComp();
        definirEventos();

        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

        Image icone = Toolkit.getDefaultToolkit().getImage("imagens//icone.png");
        this.setIconImage(icone);
    }

    public void iniciarComp() {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pnPrincipal.setLayout(null);
        setBounds(0, 0, 600, 650);
        this.pnPrincipal.setBounds(0, 0, 600, 650);

        this.mnOpcoes = new JMenu("Opções");

        //Op��es de funcion�rio
        this.mnFuncionario = new JMenu("Funcionário");
        this.miCadastrarFuncionario = new JMenuItem("Cadastrar Funcionário");
        this.miExcluirFuncionario = new JMenuItem("Excluir Funcionário");
        this.miAlterarFuncionario = new JMenuItem("Alterar Funcionário");
        this.miAposentadoria = new JMenuItem("Aposentadoria");
        this.mnFuncionario.add(this.miCadastrarFuncionario);
        this.mnFuncionario.add(this.miExcluirFuncionario);
        this.mnFuncionario.add(this.miAlterarFuncionario);
        this.mnFuncionario.add(this.miAposentadoria);
        this.mnOpcoes.add(this.mnFuncionario);
        this.mbMenu.add(this.mnOpcoes);

        //Op��es de listagem
        this.mnListagemDeFuncionario = new JMenu("Opções De Listagem");
        this.mnListar = new JMenu("Listar Funcionários...");
        this.miListarTodosOsFuncionarios = new JMenuItem("Todos os funcionários");
        this.miListarFuncionariosDaCidadeInformada = new JMenuItem("Da cidade informada");
        this.miListarFuncionariosDoEstadoInformado = new JMenuItem("Do Estado informado");
        this.miListarFuncionariosQueGanhamAcimaDe5000 = new JMenuItem("Que ganham acima de 5000.00");
        this.miListarFuncionariosQueGanhamAbaixoDe1000 = new JMenuItem("Que ganham abaixo de 1000.00");
        this.miListarFuncionariosHomens = new JMenuItem("Que s�o homens");
        this.miListarFuncionariosHomensQueGanhamAcimaDe800 = new JMenuItem("Que são homens e ganham acima de 800.00");
        this.miListarFuncionariosQueGanhamEntre1000e2000eSaoDaPB = new JMenuItem("Que ganham entre 1000.00 e 2000.00 e são da PB");
        this.miListarFuncionariosComALetraInformada = new JMenuItem("Que come�a com a letra informada");
        this.miListarFuncionariosCadeirantes = new JMenuItem("Cadeirantes");

        //Adicionando ao menu de listagem
        this.mnListar.add(this.miListarTodosOsFuncionarios);
        this.mnListar.add(this.miListarFuncionariosCadeirantes);
        this.mnListar.add(this.miListarFuncionariosDaCidadeInformada);
        this.mnListar.add(this.miListarFuncionariosDoEstadoInformado);
        this.mnListar.add(this.miListarFuncionariosHomens);
        this.mnListar.add(this.miListarFuncionariosComALetraInformada);
        this.mnListar.add(this.miListarFuncionariosQueGanhamAcimaDe5000);
        this.mnListar.add(this.miListarFuncionariosQueGanhamAbaixoDe1000);
        this.mnListar.add(this.miListarFuncionariosHomensQueGanhamAcimaDe800);
        this.mnListar.add(this.miListarFuncionariosQueGanhamEntre1000e2000eSaoDaPB);

        //Op��es de pesquisa
        this.mnPesquisar = new JMenu("Pesquisar Funcionario...");
        this.miPesquisarFuncionarioPorMatricula = new JMenuItem("Por matricula");
        this.miPesquisarFuncionarioPorCPF = new JMenuItem("Por Cpf");
        this.miMostrarFuncionarioDeMaiorSalario = new JMenuItem("Funcionário de maior Salário");
        this.miMostrarFuncionariaDeMenorSalario = new JMenuItem("Funcionária de menor Salário");
        this.miMostrarFuncionarioMaisVelho = new JMenuItem("Mais Velho");
        this.miMostrarFuncionarioMaisNovo = new JMenuItem("Mais Novo");

        //Adicionando ao menu de pesquisa
        this.mnPesquisar.add(miPesquisarFuncionarioPorMatricula);
        this.mnPesquisar.add(miPesquisarFuncionarioPorCPF);
        this.mnPesquisar.add(miMostrarFuncionarioMaisVelho);
        this.mnPesquisar.add(miMostrarFuncionarioMaisNovo);
        this.mnPesquisar.add(miMostrarFuncionarioDeMaiorSalario);
        this.mnPesquisar.add(miMostrarFuncionariaDeMenorSalario);

        this.mnListagemDeFuncionario.add(this.mnListar);
        this.mnListagemDeFuncionario.add(this.mnPesquisar);
        this.mnOpcoes.add(this.mnListagemDeFuncionario);

        this.mnAjuda = new JMenu("Ajuda");
        this.miSobre = new JMenuItem("Sobre");
        this.mnAjuda.add(this.miSobre);
        this.mbMenu.add(this.mnAjuda);
        setJMenuBar(this.mbMenu);

        this.lbMensagemInicial = new JLabel("Bem vindo(a), " + this.usuario + "!");
        lbMensagemInicial.setBounds(30, 540, 600, 35);
        lbMensagemInicial.setFont(new Font("Big Surprise Regular", Font.PLAIN, 30));

        JLabel lbImagem = new JLabel(new ImageIcon("imagens//imagem.png"));
        lbImagem.setBounds(100, 60, 400, 400);
        this.pnPrincipal.add(lbImagem);

        this.pnPrincipal.add(this.lbMensagemInicial);

        add(this.pnPrincipal);
    }

    private void definirEventos() {
        miCadastrarFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                GuiFuncionarioCadastro cadastro = new GuiFuncionarioCadastro();
                cadastro.setVisible(true);

                Funcionario auxFuncionario = cadastro.getFuncionario();
                funcionarios.add(auxFuncionario);
            }
        });

        miExcluirFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiFuncionarioExcluir fe = new GuiFuncionarioExcluir(funcionarios);
                fe.setVisible(true);
            }
        });

        miAlterarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpfDoFuncionarioASerBuscado = JOptionPane.showInputDialog("Informe o CPF do funcion�rios que deseja alterar");
                boolean funcionarioPresente = false;
                int posicaoDoFuncionarioParaAlterar = 0;

                for (int i = 0; i < funcionarios.size(); i++) {
                    if (cpfDoFuncionarioASerBuscado.equals(funcionarios.get(i).getCPF())) {
                        funcionarioPresente = true;
                        posicaoDoFuncionarioParaAlterar = i;
                    }
                }

                if (funcionarioPresente) {
                    GuiFuncionarioAlterar alterarFuncionario = new GuiFuncionarioAlterar(funcionarios.get(posicaoDoFuncionarioParaAlterar));
                    alterarFuncionario.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Funcion�rio não encontrado", "Funcionário Inválido", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //A��es de pesquisa
        miPesquisarFuncionarioPorMatricula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricula = JOptionPane.showInputDialog("Informe a matr�cula do funcionário: ");

                Funcionario funcionarioEncontrado = Empresa.pesquisarFuncionarioPorMatricula(funcionarios, matricula);

                if (funcionarioEncontrado != null) {
                    JOptionPane.showMessageDialog(null, funcionarioEncontrado.toString(), "Funcion�rio pesquisado por matrícula", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Funcionário não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        miPesquisarFuncionarioPorCPF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = JOptionPane.showInputDialog("Informe o CPF do funcionário: ");

                Funcionario funcionarioEncontrado = Empresa.pesquisarFuncionarioPorCPF(funcionarios, cpf);

                if (funcionarioEncontrado != null) {
                    JOptionPane.showMessageDialog(null, funcionarioEncontrado.toString(), "Funcionário pesquisado por CPF", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Funcionário não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //�rea de amostra de funcion�rios
        miMostrarFuncionarioMaisVelho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Funcionario> funcionariosMaisVelhos = Empresa.getFuncionariosMaisVelhos(funcionarios);
                String listaDeFuncionarios = Util.concatenarNomes(funcionariosMaisVelhos);
                JOptionPane.showMessageDialog(null, listaDeFuncionarios, "Funcionários mais velhos", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        miMostrarFuncionarioMaisNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Funcionario> funcionariosMaisNovos = Empresa.getFuncionariosMaisNovos(funcionarios);
                String listaDeFuncionarios = Util.concatenarNomes(funcionariosMaisNovos);
                JOptionPane.showMessageDialog(null, listaDeFuncionarios, "Funcionários mais novos", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        miMostrarFuncionarioDeMaiorSalario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ArrayList<Funcionario> funcionariosComMaiorSalario = Empresa.getFuncionariosComMaiorSalario(funcionarios);
                String listaDeFuncionarios = Util.concatenarNomes(funcionariosComMaiorSalario);
                JOptionPane.showMessageDialog(null, listaDeFuncionarios, "Funcionários com maior salário", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        miMostrarFuncionariaDeMenorSalario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Funcionario> funcionariasComMenorSalario = Empresa.getFuncionariasComMenorSalario(funcionarios);
                String listaDeFuncionarias = Util.concatenarNomes(funcionariasComMenorSalario);
                JOptionPane.showMessageDialog(null, listaDeFuncionarias, "Funcionárias com menor salário", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        //A��es de listagem
        miListarTodosOsFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListagemDeFuncionarios listarTodosFuncionarios = new ListagemDeFuncionarios();
                listarTodosFuncionarios.listarTodosFuncionarios(funcionarios);
            }
        });

        miListarFuncionariosCadeirantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Funcionario> funcionariosCadeirantes = new ArrayList<Funcionario>();
                funcionariosCadeirantes = empresa.listarFuncionariosCadeirantes(funcionarios);

                if (funcionariosCadeirantes.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum funcionário encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (int i = 0; i < funcionariosCadeirantes.size(); i++) {
                        JOptionPane.showMessageDialog(null, funcionariosCadeirantes.get(i).getNome());
                    }
                }
            }
        });

        miListarFuncionariosDaCidadeInformada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Funcionario> funcionariosDaCidadeInformada = new ArrayList<Funcionario>();
                String localX = JOptionPane.showInputDialog("Digite a cidade que deseja procurar os funcionários");

                funcionariosDaCidadeInformada = empresa.listarFuncionariosDeUmLocalX(funcionarios, localX);

                if (funcionariosDaCidadeInformada.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum funcionário encontrado!", "erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (int i = 0; i < funcionariosDaCidadeInformada.size(); i++) {
                        JOptionPane.showMessageDialog(null, funcionariosDaCidadeInformada.get(i).getNome());
                    }
                }
            }
        });

        miListarFuncionariosDoEstadoInformado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empresa Empresa = new Empresa();
                ArrayList<Funcionario> funcionariosDoEstadoInformado = new ArrayList<Funcionario>();
                String localX = JOptionPane.showInputDialog("Digite o Estado que deseja procurar os funcionários");

                funcionariosDoEstadoInformado = Empresa.listarFuncionariosDeUmLocalX(funcionarios, localX);

                if (funcionariosDoEstadoInformado.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum funcionário encontrado!", "erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (int i = 0; i < funcionariosDoEstadoInformado.size(); i++) {
                        JOptionPane.showMessageDialog(null, funcionariosDoEstadoInformado.get(i).getNome());
                    }
                }
            }
        });

        miListarFuncionariosHomens.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Empresa Empresa = new Empresa();
                ArrayList<Funcionario> funcionariosHomens = new ArrayList<Funcionario>();

                funcionariosHomens = Empresa.listarFuncionariosHomens(funcionarios);

                if (funcionariosHomens.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum funcionário encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (int i = 0; i < funcionariosHomens.size(); i++) {
                        JOptionPane.showMessageDialog(null, funcionariosHomens.get(i).getNome());
                    }
                }
            }
        });

        miListarFuncionariosComALetraInformada.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Empresa Empresa = new Empresa();
                ArrayList<Funcionario> funcionariosComAQueComercaComLetraInformada = new ArrayList<Funcionario>();

                String letraProcurada = JOptionPane.showInputDialog("Digite a letra");

                funcionariosComAQueComercaComLetraInformada = Empresa.listarFuncionariosQueComecaComALetraIndicada(funcionarios, letraProcurada);

                if (funcionariosComAQueComercaComLetraInformada.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum funcionário encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (int i = 0; i < funcionariosComAQueComercaComLetraInformada.size(); i++) {
                        JOptionPane.showMessageDialog(null, funcionariosComAQueComercaComLetraInformada.get(i).getNome());
                    }
                }
            }
        });

        miListarFuncionariosQueGanhamAcimaDe5000.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Empresa Empresa = new Empresa();
                ArrayList<Funcionario> funcionariosGanhandoAcimaDe5000 = new ArrayList<Funcionario>();

                funcionariosGanhandoAcimaDe5000 = Empresa.listarFuncionariosQueGanhamAcimaDe5000(funcionarios);

                if (funcionariosGanhandoAcimaDe5000.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum funcionário encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (int i = 0; i < funcionariosGanhandoAcimaDe5000.size(); i++) {
                        JOptionPane.showMessageDialog(null, funcionariosGanhandoAcimaDe5000.get(i).getNome());
                    }
                }
            }
        });

        miListarFuncionariosQueGanhamAbaixoDe1000.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Empresa Empresa = new Empresa();
                ArrayList<Funcionario> funcionariosGanhandoAbaixoDe1000 = new ArrayList<Funcionario>();

                funcionariosGanhandoAbaixoDe1000 = Empresa.listarFuncionariosQueGanhamAbaixo1000(funcionarios);

                if (funcionariosGanhandoAbaixoDe1000.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum funcionário encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (int i = 0; i < funcionariosGanhandoAbaixoDe1000.size(); i++) {
                        JOptionPane.showMessageDialog(null, funcionariosGanhandoAbaixoDe1000.get(i).getNome());
                    }
                }
            }
        });

        miListarFuncionariosHomensQueGanhamAcimaDe800.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Empresa Empresa = new Empresa();
                ArrayList<Funcionario> funcionariosHomensGanhandoAcimadDe800 = new ArrayList<Funcionario>();

                funcionariosHomensGanhandoAcimadDe800 = Empresa.listarFuncionariosHomensGanhandoAcimaDe800(funcionarios);

                if (funcionariosHomensGanhandoAcimadDe800.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum funcionário encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (int i = 0; i < funcionariosHomensGanhandoAcimadDe800.size(); i++) {
                        JOptionPane.showMessageDialog(null, funcionariosHomensGanhandoAcimadDe800.get(i).getNome());
                    }
                }
            }
        });

        miListarFuncionariosQueGanhamEntre1000e2000eSaoDaPB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Empresa Empresa = new Empresa();
                ArrayList<Funcionario> funcionariosGanhandoEntre1000e2000QueSaoDaPB = new ArrayList<Funcionario>();

                funcionariosGanhandoEntre1000e2000QueSaoDaPB = Empresa.listarFuncionariosGanhandoEntre1000e2000QueSaoDaPB(funcionarios);

                if (funcionariosGanhandoEntre1000e2000QueSaoDaPB.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum funcionário encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (int i = 0; i < funcionariosGanhandoEntre1000e2000QueSaoDaPB.size(); i++) {
                        JOptionPane.showMessageDialog(null, funcionariosGanhandoEntre1000e2000QueSaoDaPB.get(i).getNome());
                    }
                }
            }
        });

        //Aposentadoria
        miAposentadoria.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeDaPessoaParaSerProcurada = JOptionPane.showInputDialog("Digite o nome do funcionário a ser procurado");
                int quantidadeDeAnosQueFaltaParaSeAposentar = empresa.aposentadoria(funcionarios, nomeDaPessoaParaSerProcurada);
                if (quantidadeDeAnosQueFaltaParaSeAposentar == -1) {
                    JOptionPane.showMessageDialog(null, "Nenhum funcionário encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);;
                } else {
                    JOptionPane.showMessageDialog(null, "Falta " + quantidadeDeAnosQueFaltaParaSeAposentar + " anos\n" + "para o funcionário " + nomeDaPessoaParaSerProcurada + " aposentar-se!", "Aposentadoria", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //A��es do menu sobre
        miSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Versão Do Aplicativo 2.0 \n Desenvolvido por: Lucas Emanuel, Hemenson David, Isadora Medeiros, Gabriel de Araújo");
            }
        });
    }
}
