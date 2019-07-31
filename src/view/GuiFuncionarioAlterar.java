package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.Funcionario;
import model.Util;

public class GuiFuncionarioAlterar extends JFrame {

    private static final long serialVersionUID = 1L;
    private Funcionario funcionario;
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JPanel pnAlterar = new JPanel();
    private JButton btAddOption;
    private JButton btCancelarOption;
    private JLabel lbNome;
    private JLabel lbCPF;
    private JLabel lbMatricula;
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
    private JTextField tfMatricula;
    private JTextField tfCidade;
    private JTextField tfSalario;
    private JList<String> ltListaDeEstados;
    private JRadioButton rbSexoFeminino;
    private JRadioButton rbSexoMasculino;

    public GuiFuncionarioAlterar(Funcionario funcionario) {
        this.funcionario = funcionario;

        setTitle("Oxente Sistemas - Funcionários - Alterar Funcionário");
        iniciarCadastro();
        definirEventros(funcionario);

        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);
    }

    private void iniciarCadastro() {
        setLayout(null);
        setBounds(0, 0, 480, 600);
        this.pnAlterar.setLayout(null);
        this.pnAlterar.setBounds(0, 0, 480, 600);

        this.lbNome = new JLabel("Nome: ");
        this.lbNome.setBounds(50, 30, 100, 25);

        this.tfNome = new JTextField(this.funcionario.getNome());
        this.tfNome.setBounds(100, 29, 300, 30);

        this.pnAlterar.add(this.lbNome);
        this.pnAlterar.add(this.tfNome);

        this.lbCPF = new JLabel("CPF: ");
        this.lbCPF.setBounds(50, 80, 100, 25);

        this.tfCPF = new JTextField(this.funcionario.getCPF());
        this.tfCPF.setBounds(100, 79, 300, 30);

        this.pnAlterar.add(this.lbCPF);
        this.pnAlterar.add(this.tfCPF);

        this.lbMatricula = new JLabel("Matrícula: ");
        this.lbMatricula.setBounds(50, 130, 100, 25);

        this.tfMatricula = new JTextField(this.funcionario.getMatricula());
        this.tfMatricula.setBounds(120, 129, 280, 30);
        this.tfMatricula.setEditable(false);

        this.pnAlterar.add(this.lbMatricula);
        this.pnAlterar.add(this.tfMatricula);

        this.lbEstado = new JLabel("Estado: ");
        this.lbEstado.setBounds(50, 180, 100, 25);

        String[] estados = {"RN", "PB", "SP", "BH", "RJ"};
        this.ltListaDeEstados = new JList<String>(estados);

        int auxiliarDeIndice = 0;
        for (int i = 0; i < estados.length; i++) {
            if (funcionario.getEstado().equals(estados[i])) {
                auxiliarDeIndice = i;
            }
        }

        ltListaDeEstados.setSelectedIndex(auxiliarDeIndice);
        JScrollPane spListaDeEstados = new JScrollPane(ltListaDeEstados);
        spListaDeEstados.setBounds(100, 179, 40, 30);

        this.pnAlterar.add(this.lbEstado);
        this.pnAlterar.add(spListaDeEstados);

        this.lbCidade = new JLabel("Cidade: ");
        this.lbCidade.setBounds(200, 180, 100, 25);

        this.tfCidade = new JTextField(funcionario.getCidade());
        this.tfCidade.setBounds(250, 179, 150, 30);

        this.pnAlterar.add(this.lbCidade);
        this.pnAlterar.add(this.tfCidade);
        this.pnAlterar.setVisible(true);

        this.lbSexo = new JLabel("Sexo: ");
        this.lbSexo.setBounds(50, 220, 150, 30);
        this.pnAlterar.add(this.add(lbSexo));

        this.rbSexoFeminino = new JRadioButton("Feminino");
        this.rbSexoFeminino.setBounds(100, 219, 100, 20);

        this.pnAlterar.add(this.rbSexoFeminino);

        this.rbSexoMasculino = new JRadioButton("Masculino");
        this.rbSexoMasculino.setBounds(100, 239, 100, 20);
        this.pnAlterar.add(rbSexoMasculino);

        if (funcionario.getSexo() == 'F') {
            rbSexoFeminino.setSelected(true);
        } else {
            rbSexoMasculino.setSelected(true);
        }

        this.buttonGroup.add(this.rbSexoFeminino);
        this.buttonGroup.add(this.rbSexoMasculino);

        this.lbSalario = new JLabel("Salário: ");
        this.lbSalario.setBounds(220, 224, 100, 30);
        this.pnAlterar.add(this.lbSalario);

        this.tfSalario = new JTextField(Double.toString(funcionario.getSalario()));
        this.tfSalario.setBounds(280, 225, 120, 30);
        this.pnAlterar.add(this.tfSalario);

        this.lbDeficiencia = new JLabel("Deficiência: ");
        this.lbDeficiencia.setBounds(50, 269, 100, 30);
        this.pnAlterar.add(lbDeficiencia);

        this.tfDificiencia = new JTextField(funcionario.getDeficiencia());
        this.tfDificiencia.setBounds(125, 270, 125, 30);
        this.pnAlterar.add(this.tfDificiencia);

        this.lbIdade = new JLabel("Idade: ");
        this.lbIdade.setBounds(280, 269, 50, 30);
        this.pnAlterar.add(lbIdade);

        this.tfIdade = new JTextField(Integer.toString(funcionario.getIdade()));
        this.tfIdade.setBounds(325, 270, 75, 30);
        this.pnAlterar.add(tfIdade);

        this.btAddOption = new JButton("Ok");
        this.btAddOption.setBounds(100, 480, 130, 40);
        this.btCancelarOption = new JButton("Cancelar");
        this.btCancelarOption.setBounds(250, 480, 130, 40);

        this.pnAlterar.add(this.btAddOption);
        this.pnAlterar.add(this.btCancelarOption);

        add(pnAlterar);
    }

    private void definirEventros(Funcionario funcionario) {
        btAddOption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarDadosAoFuncionario(funcionario);
                JOptionPane.showMessageDialog(null, funcionario);
                setVisible(false);
            }
        });

        btCancelarOption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    private void adicionarDadosAoFuncionario(Funcionario funcionario) {
        funcionario.setNome(tfNome.getText());
        funcionario.setMatricula(tfMatricula.getText());
        funcionario.setEstado((String) ltListaDeEstados.getSelectedValue());
        funcionario.setCidade(tfCidade.getText());

        if (rbSexoMasculino.isSelected()) {
            sexo = 'M';
        } else if (rbSexoFeminino.isSelected()) {
            this.sexo = 'F';
        }

        funcionario.setSexo(this.sexo);
        funcionario.setSalario(Double.parseDouble(Util.reescreverVirgulaParaPonto(tfSalario.getText())));
        funcionario.setDeficiencia(this.tfDificiencia.getText().toLowerCase());
        funcionario.setCPF(this.tfCPF.getText());
        funcionario.setIdade(Integer.parseInt(this.tfIdade.getText()));
    }
}
