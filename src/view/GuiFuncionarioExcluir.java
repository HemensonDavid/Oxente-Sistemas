package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Funcionario;

public class GuiFuncionarioExcluir extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel pnBuscar = new JPanel();
    private JLabel lbNome, lbCPF;
    private JTextField tfNome, tfCPF;
    private JButton btExcluirOption, btCancelarOption;

    public GuiFuncionarioExcluir(ArrayList<Funcionario> funcionarios) {
        super("Oxente Sistemas - Funcionário - Excluir Funcionário");
        iniciarComponentes();
        definirEventos(funcionarios);

        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);
    }

    private void iniciarComponentes() {
        setLayout(null);
        setBounds(0, 0, 430, 270);

        this.pnBuscar.setLayout(null);
        this.pnBuscar.setBounds(0, 0, 430, 270);

        this.lbNome = new JLabel("Nome do funcionário: ");
        this.lbNome.setFont(new Font("Arial", Font.PLAIN, 16));
        this.lbNome.setBounds(20, 60, 160, 25);
        this.pnBuscar.add(this.lbNome);

        this.tfNome = new JTextField();
        this.tfNome.setBounds(180, 60, 210, 30);
        this.pnBuscar.add(this.tfNome);

        this.lbCPF = new JLabel("CPF do funcionário: ");
        this.lbCPF.setFont(new Font("Arial", Font.PLAIN, 16));
        this.lbCPF.setBounds(20, 110, 160, 25);
        this.pnBuscar.add(this.lbCPF);

        this.tfCPF = new JTextField();
        this.tfCPF.setBounds(180, 107, 210, 30);
        this.pnBuscar.add(this.tfCPF);

        this.btExcluirOption = new JButton("Excluir");
        this.btExcluirOption.setBounds(40, 170, 150, 40);
        this.pnBuscar.add(this.btExcluirOption);

        this.btCancelarOption = new JButton("Cancelar");
        this.btCancelarOption.setBounds(210, 170, 150, 40);
        this.pnBuscar.add(this.btCancelarOption);

        add(pnBuscar);
    }

    public void definirEventos(ArrayList<Funcionario> funcionarios) {

        btExcluirOption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (isFuncionarioPresente(funcionarios, tfNome.getText(), tfCPF.getText())) {
                    removerFuncionario(funcionarios, tfNome.getText(), tfCPF.getText());
                    JOptionPane.showMessageDialog(null, "Funcionario " + tfNome.getText() + " excluido com sucesso!");
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Funcionário não encontrado");
                }
            }
        });

        btCancelarOption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    private void removerFuncionario(ArrayList<Funcionario> funcionarios, String nome, String cpf) {

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNome().equals(nome) && funcionarios.get(i).getCPF().equals(cpf)) {
                funcionarios.remove(i);
            }
        }
    }

    private boolean isFuncionarioPresente(ArrayList<Funcionario> funcionarios, String nome, String cpf) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNome().equals(nome) && funcionarios.get(i).getCPF().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
}
