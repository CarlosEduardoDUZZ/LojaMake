package MakeUp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ListaRemoveController implements ActionListener {

	private Lista lista;
	private JFrame janelaPrincipal;

	public ListaRemoveController(Lista lista, JFrame janelaPrincipal) {
		this.lista = lista;
		this.janelaPrincipal = janelaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cpf = JOptionPane.showInputDialog(janelaPrincipal, 
				"Digite o CPF do cliente a remover ");
		boolean removeu = lista.removeCliente(cpf);
		if (removeu) {
			JOptionPane.showMessageDialog(janelaPrincipal, 
					"Cliente removido com sucesso");
		} else {
			JOptionPane.showMessageDialog(janelaPrincipal, 
					"Cliente não foi encontrado. Operação não realizada");
		}

	}

}