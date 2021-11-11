package MakeUp;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String endereco;
	private String cpf;
	private int numeroDaCasa;
	
	public Cliente (String nome, String endereco, String cpf, int numeroDaCasa) {
		
		this.setNome(nome);
		this.setEndereco(endereco);
		this.cpf = cpf;
		this.setNumeroDaCasa(numeroDaCasa);
	}
	
	public Cliente () {
		this("", "","",0);
	}
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", endereco=" + endereco + ", cpf=" + cpf + ", numeroDaCasa=" + numeroDaCasa +"]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}

	public String getCpf() {
		return cpf;
	}
	

	public int getNumeroDaCasa() {
		return numeroDaCasa;
	}

	public void setNumeroDaCasa(int numeroDaCasa) {
		this.numeroDaCasa = numeroDaCasa;
	}

}
