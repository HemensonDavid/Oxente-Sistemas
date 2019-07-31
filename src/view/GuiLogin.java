package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import model.Util;

public class GuiLogin extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel pnDeLogin = new JPanel();
    private JTextField tfLogin;
    private JPasswordField pfSenha;
    private JButton btLogar, btCancelar;
    private JLabel lbNome, lbSenha;
    private String usuario;

    public GuiLogin() {
        super("Login");

        iniciarLogin();
        definirEventos();

        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

        Image icone = Toolkit.getDefaultToolkit().getImage("imagens//icone.png");
        this.setIconImage(icone);
    }

    private void iniciarLogin() {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pnDeLogin.setLayout(null);
        this.pnDeLogin.setBackground(Color.DARK_GRAY);
        setBounds(0, 0, 400, 270);
        this.pnDeLogin.setBounds(0, 0, 400, 270);

        this.lbNome = new JLabel("Usuário: ");
        this.lbNome.setForeground(Color.WHITE);
        this.lbNome.setFont(new Font("Arial", Font.BOLD, 15));
        this.lbNome.setBounds(38, 30, 65, 20);
        this.pnDeLogin.add(this.lbNome);

        this.tfLogin = new JTextField();
        this.tfLogin.setBounds(110, 25, 225, 30);
        this.pnDeLogin.add(this.tfLogin);

        this.lbSenha = new JLabel("Senha: ");
        this.lbSenha.setForeground(Color.WHITE);
        this.lbSenha.setFont(new Font("Arial", Font.BOLD, 15));
        this.lbSenha.setBounds(38, 85, 65, 20);
        this.pnDeLogin.add(this.lbSenha);

        this.pfSenha = new JPasswordField();
        this.pfSenha.setBounds(110, 80, 225, 30);
        this.pnDeLogin.add(this.pfSenha);

        this.btLogar = new JButton("Entrar");
        this.btLogar.setBounds(30, 150, 150, 50);
        this.btLogar.setFocusPainted(false);
        this.btLogar.setForeground(Color.white);
        this.btLogar.setBorderPainted(false);
        this.btLogar.setBackground(Color.GRAY);
        this.pnDeLogin.add(this.btLogar);

        this.btCancelar = new JButton("Cancelar");
        this.btCancelar.setBounds(195, 150, 150, 50);
        this.btCancelar.setFocusPainted(false);
        this.btCancelar.setForeground(Color.white);
        this.btCancelar.setBorderPainted(false);
        this.btCancelar.setBackground(Color.GRAY);
        this.pnDeLogin.add(this.btCancelar);

        this.add(pnDeLogin);
    }

    private void definirEventos() {

        btLogar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (isLoginValido()) {
                    setVisible(false);
                    GuiPrincipal gp = new GuiPrincipal(usuario);
                    gp.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário inválido!", "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

    }

    private boolean isLoginValido() {
        String senha = Util.transformarArrayDeCharParaString(this.pfSenha.getPassword());
        if (this.tfLogin.getText().equals("Lucas") && senha.equals("lucas")) {
            this.usuario = "Lucas";
            return true;
        } else if (this.tfLogin.getText().equals("Hemenson") && senha.equals("hemenson")) {
            this.usuario = "Hemenson";
            return true;
        } else if (this.tfLogin.getText().equals("Isadora") && senha.equals("isadora")) {
            this.usuario = "Isadora";
            return true;
        } else if (this.tfLogin.getText().equals("Gabriel") && senha.equals("gabriel")) {
            this.usuario = "Gabriel";
            return true;
        } else if (this.tfLogin.getText().equals("Admin") && senha.equals("admin")) {
            this.usuario = "Admin";
            return true;
        }

        return false;
    }
}
