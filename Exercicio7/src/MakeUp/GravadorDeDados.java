package MakeUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeDados {
	
	private String clienteArquivo;
	
	public GravadorDeDados () {
		this.clienteArquivo = "clientes.txt";
	}
	
	public GravadorDeDados (String clienteArquivo) {
		
		this.clienteArquivo = clienteArquivo;
	}
	
	public void gravarCliente(List<Cliente> clientes) throws IOException {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(clienteArquivo));
			List<Cliente> contatosAGravar = new ArrayList<Cliente>();
			contatosAGravar.addAll(clientes);
			out.writeObject(contatosAGravar);
		} catch (FileNotFoundException e) {
			throw new IOException("Não foi encontrado o arquivo "+clienteArquivo);
		} catch (IOException e) {
			throw e;
		} finally {
			if (out!=null) {
				out.close();
			}
		}
		
	}
	
	
	public List<Cliente> recuperarCliente () throws IOException{
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(clienteArquivo));
			List<Cliente> clientesAchados =   (List<Cliente>) in.readObject();
			return clientesAchados;
		} catch (FileNotFoundException e) {
			throw new IOException("Não foi encontrado o arquivo "+clienteArquivo);
		} catch (IOException e) {
			throw e;
		} catch(ClassNotFoundException e) {
			throw new IOException("Classe de objetos gravados no arquivo "+clienteArquivo+" não existe");
		} finally {
			if (in!=null) {
				in.close();
			}
		}
	}
	
}
