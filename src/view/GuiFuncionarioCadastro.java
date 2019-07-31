package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Funcionario;
import model.GeradorDeMatriculas;
import model.Util;

public class GuiFuncionarioCadastro extends JFrame {

    private static final long serialVersionUID = 1L;

    private Funcionario funcionario = new Funcionario();

    private GeradorDeMatriculas geradorDeMatriculas = new GeradorDeMatriculas();
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JPanel pnCadastrar = new JPanel();
    private JButton btAddOption;
    private JButton btCancelarOption;
    private JLabel lbNome;
    private JLabel lbCPF;
    private JLabel lbEstado;
    private JLabel lbCidade;
    private JLabel lbSexo;
    private JLabel lbSalario;
    private JLabel lbDeficiencia;
    private JLabel lbIdade;
    private char sexo;
    private JTextField tfNome;
    private JTextField tfIdade;
    private JTextField tfDificiencia;
    private JTextField tfCPF;
    private JTextField tfCidade;
    private JTextField tfSalario;
    private JList<String> ltListaDeEstados;
    private JRadioButton rbSexoFeminino;
    private JRadioButton rbSexoMasculino;

    public GuiFuncionarioCadastro() {
        super("Oxente Sistemas - Funcionário - Adicionar Funcionário");
        iniciarCadastro();
        definirEventros();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);
    }

    private void iniciarCadastro() {
        setLayout(null);
        setBounds(0, 0, 480, 600);
        this.pnCadastrar.setLayout(null);
        this.pnCadastrar.setBounds(0, 0, 480, 600);

        this.lbNome = new JLabel("Nome: ");
        this.lbNome.setBounds(50, 30, 100, 25);

        this.tfNome = new JTextField();
        this.tfNome.setBounds(100, 29, 300, 30);

        this.pnCadastrar.add(this.lbNome);
        this.pnCadastrar.add(this.tfNome);

        this.lbCPF = new JLabel("CPF: ");
        this.lbCPF.setBounds(50, 80, 100, 25);

        this.tfCPF = new JTextField();
        this.tfCPF.setBounds(100, 79, 300, 30);

        this.pnCadastrar.add(this.lbCPF);
        this.pnCadastrar.add(this.tfCPF);

        this.lbEstado = new JLabel("Estado: ");
        this.lbEstado.setBounds(50, 136, 100, 24);

        String[] estados = {"RN", "PB", "SP", "BH", "RJ"};
        this.ltListaDeEstados = new JList<String>(estados);
        JScrollPane sbListaDeEstados = new JScrollPane(ltListaDeEstados);
        sbListaDeEstados.setBounds(115, 135, 50, 65);

        this.pnCadastrar.add(this.lbEstado);
        this.pnCadastrar.add(sbListaDeEstados);

        this.lbCidade = new JLabel("Cidade: ");
        this.lbCidade.setBounds(200, 180, 100, 25);

        this.tfCidade = new JTextField();
        this.tfCidade.setBounds(250, 179, 150, 30);

        this.pnCadastrar.add(this.lbCidade);
        this.pnCadastrar.add(this.tfCidade);
        this.pnCadastrar.setVisible(true);

        this.lbSexo = new JLabel("Sexo: ");
        this.lbSexo.setBounds(245, 125, 150, 30);
        this.pnCadastrar.add(this.add(lbSexo));

        this.rbSexoFeminino = new JRadioButton("Feminino");
        this.rbSexoFeminino.setBounds(287, 120, 100, 20);
        this.pnCadastrar.add(this.rbSexoFeminino);

        this.rbSexoMasculino = new JRadioButton("Masculino");
        this.rbSexoMasculino.setBounds(285, 141, 100, 20);
        this.pnCadastrar.add(rbSexoMasculino);

        this.buttonGroup.add(this.rbSexoFeminino);
        this.buttonGroup.add(this.rbSexoMasculino);

        this.lbSalario = new JLabel("Salário: ");
        this.lbSalario.setBounds(220, 224, 100, 30);
        this.pnCadastrar.add(this.lbSalario);

        this.tfSalario = new JTextField();
        this.tfSalario.setBounds(280, 225, 120, 30);
        this.pnCadastrar.add(this.tfSalario);

        this.lbDeficiencia = new JLabel("Deficiência: ");
        this.lbDeficiencia.setBounds(50, 269, 100, 30);
        this.pnCadastrar.add(lbDeficiencia);

        this.tfDificiencia = new JTextField();
        this.tfDificiencia.setBounds(125, 270, 275, 30);
        this.pnCadastrar.add(this.tfDificiencia);

        this.lbIdade = new JLabel("Idade: ");
        this.lbIdade.setBounds(50, 224, 50, 30);
        this.pnCadastrar.add(lbIdade);

        this.tfIdade = new JTextField();
        this.tfIdade.setBounds(100, 224, 100, 30);
        this.pnCadastrar.add(tfIdade);

        this.btAddOption = new JButton("Ok");
        this.btAddOption.setBounds(100, 480, 130, 40);
        this.btCancelarOption = new JButton("Cancelar");
        this.btCancelarOption.setBounds(250, 480, 130, 40);

        JLabel lbImagem = new JLabel(new ImageIcon("imagens\\funcionario+_icone.png"));
        lbImagem.setBounds(275, 323, 135, 126);
        pnCadastrar.add(lbImagem);

        this.pnCadastrar.add(this.btAddOption);
        this.pnCadastrar.add(this.btCancelarOption);

        add(pnCadastrar);
    }

    private void definirEventros() {
        btAddOption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarDadosAoFuncionario();
                JOptionPane.showMessageDialog(null, "Matrícula: " + funcionario.getMatricula(), "Matrícula", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
            }
        });

        btCancelarOption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    private void adicionarDadosAoFuncionario() {

        this.funcionario.setNome(tfNome.getText());

        this.funcionario.setEstado((String) ltListaDeEstados.getSelectedValue());
        this.funcionario.setCidade(tfCidade.getText());
        if (rbSexoMasculino.isSelected()) {
            this.sexo = 'M';
        } else if (rbSexoFeminino.isSelected()) {
            this.sexo = 'F';
        }

        this.funcionario.setMatricula(geradorDeMatriculas.gerarMatricula(Integer.parseInt(this.tfIdade.getText()), tfNome.getText(), this.sexo, this.tfCPF.getText()));
        this.funcionario.setSexo(this.sexo);
        this.funcionario.setSalario(Double.parseDouble(Util.reescreverVirgulaParaPonto(tfSalario.getText())));
        this.funcionario.setDeficiencia(this.tfDificiencia.getText());
        this.funcionario.setCPF(this.tfCPF.getText());
        this.funcionario.setIdade(Integer.parseInt(this.tfIdade.getText()));
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }
}
