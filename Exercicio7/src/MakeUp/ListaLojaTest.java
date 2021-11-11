package MakeUp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ListaLojaTest {

	@Test
	void testaListaCliente() {
		ListaLoja sistema = new ListaLoja();
		try {
			assertFalse(sistema.pesquisaCliente("223.344.556-67"));
			sistema.cadastraCliente("Carlos","Rua Antonio","223.344.556-67",123);
			assertTrue(sistema.getClientes().size() == 1);
			assertTrue(sistema.pesquisaCliente("223.344.556-67"));
			sistema.cadastraCliente("Carlos","Rua Antonio","223.344.556-67",123);
			fail("Deveria lançar exceção");
			assertTrue(sistema.removeCliente("223.344.556-67"));
			assertTrue(sistema.getClientes().size() == 0);
		} catch (ClienteJaExisteException e) {
			System.out.println("Ok.");
		}
	}
	
	@Test
	void testaLojaProduto() {
		
	}

}