package MakeUp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ListaSearchController implements ActionListener {

	private Lista lista;
	private JFrame janelaPrincipal;
	
	public ListaSearchController(Lista lista, JFrame janelaPrincipal) {
		this.lista = lista;
		this.janelaPrincipal = janelaPrincipal;
	}
	
	
	public void actionPerformed(ActionEvent e)  {
		String cpf = JOptionPane.showInputDialog(janelaPrincipal,"Informe o CPF do cliente que deseja pesquisar ");
		List<Cliente> clientePesquisado = lista.pesquisaCliente(cpf);
			if (clientePesquisado.size() != 0) {
				JOptionPane.showMessageDialog(janelaPrincipal, "Cliente encontrado:");
				for (Cliente c: clientePesquisado) {
					JOptionPane.showMessageDialog(janelaPrincipal, c.toString());
					}
			}else {
				JOptionPane.showMessageDialog(janelaPrincipal, "Não foi encontrado nenhum cliente com esse CPF ");
			}
	}
}