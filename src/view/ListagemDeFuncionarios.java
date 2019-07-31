package view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Funcionario;

public class ListagemDeFuncionarios {

    public void listarTodosFuncionarios(ArrayList<Funcionario> funcionarios) {
        if (funcionarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ops, nenhum funcionário foi cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            for (int i = 0; i < funcionarios.size(); i++) {
                JOptionPane.showMessageDialog(null, funcionarios.get(i).toString());
            }
        }
    }
}
