package MakeUp;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;



public class ListaLojaGUI extends JFrame {
	
	
	private GravadorDeDados gravador;
	private Lista lista;
	
	ImageIcon maquiagemImg = new ImageIcon ("./imgs/make.jpg");
	JLabel linha1, linha2;
	JMenuBar barraDeMenu = new JMenuBar();
	
	public ListaLojaGUI() {
		gravador = new GravadorDeDados();
	    lista = new ListaLoja();
	    
	    try {
	    	List<Cliente> clientesRecuperados = gravador.recuperarCliente();
			lista.setClientes(clientesRecuperados);	
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Dados não recuperados");
		}
	    
		setTitle("Lista de clientes");
		setSize(800, 600);
		setLocation(200,200);
		setResizable(false);
		getContentPane().setBackground(Color.white);
		linha1 = new JLabel("Super Mercado ...", JLabel.CENTER);
		linha1.setForeground(Color.RED);
		linha1.setFont(new Font("Serif", Font.BOLD, 24));
		linha2 = new JLabel(maquiagemImg, JLabel.CENTER);
		 
		setLayout(new GridLayout(3,1));
		add(linha1);
		add(linha2);
		add(new JLabel());
		JMenu menuCadastrar = new JMenu("Cliente");
		JMenuItem menuCadastrarCliente= new JMenuItem("Cadastrar cliente");
		menuCadastrar.add(menuCadastrarCliente);
		JMenu menuPesquisar = new JMenu("Pesquisar");
		JMenuItem menuPesquisarCliente = new JMenuItem("Pesquisar cliente");
		menuPesquisar.add(menuPesquisarCliente);
		JMenu menuRemover = new JMenu("Remover");
		JMenuItem menuRemoverCliente = new JMenuItem("Remover cliente");
		menuRemover.add(menuRemoverCliente);
		JMenu menuSalvar = new JMenu("Salvar");
		JMenuItem menuSalvarClientes= new JMenuItem("Salvar cliente");
		menuSalvar.add(menuSalvarClientes);
		
		
		menuPesquisarCliente.addActionListener(new ListaSearchController(lista, this));
		menuRemoverCliente.addActionListener(new ListaRemoveController(lista,this));
		
		menuCadastrarCliente.addActionListener(
		    (ae) -> {
		    	String nome = JOptionPane.showInputDialog(this, "Qual o nome do cliente?");
	    		String endereco = JOptionPane.showInputDialog(this, "Qual o seu endereço?");
		    	String cpf = JOptionPane.showInputDialog(this, "Digite o cpf");
				int numeroDaCasa = Integer.parseInt( JOptionPane.showInputDialog(this,"Qual o número da casa? "));
				boolean cadastrou;
				try {
					cadastrou = lista.cadastraCliente(nome ,endereco, cpf, numeroDaCasa);
					if (cadastrou) {
						JOptionPane.showMessageDialog(this, "Cliente cadastrado");
					} else {
						JOptionPane.showMessageDialog(this, "O cliente não foi cadastrado. Verifique se já existia alguém com esse nome");
					}

				} catch (ClienteJaExisteException e) {
					System.out.println("Esse cliente já está cadastrado");
					e.printStackTrace();
				}
				
	    	}
		    	
		);
		
		menuSalvarClientes.addActionListener(
			    (ae) -> {
			    	try {
			    	gravador.gravarCliente(lista.getClientes());
			    	JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso");
			    	} catch (IOException e){
			    		JOptionPane.showMessageDialog(this, "Problema ao salvar cliente");
			    	}
			    }
			    
			);
		
		barraDeMenu.add(menuCadastrar);
		barraDeMenu.add(menuPesquisar);
		barraDeMenu.add(menuRemover);
		barraDeMenu.add(menuSalvar);
		setJMenuBar(barraDeMenu);
	}
	
	
	public static void main(String [] args) {
		JFrame janela = new ListaLojaGUI();
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


