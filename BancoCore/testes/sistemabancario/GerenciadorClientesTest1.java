package sistemabancario;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Teste unitário da modelagem de Cliente.
 * 
 * Unit testing Client.
 * 
 * @author Robson Pomponet
 * @date 2023/03/17
 * 
 * {@link GerenciadoraClientes}
 */

public class GerenciadorClientesTest1 {
	
	static GerenciadoraClientes gerClientes;
	
	/**
	 * Teste unitário - Pesquisa de Cliente por Id.
	 * 
	 * Unit Test - Search Client by Id
	 * 
	 * @author Robson Pomponet
	 * @date 2023/03/17
	 */
	
	@Test
	public void testPesquisaCliente() {
		Cliente cliente01 = new Cliente(1, "Joao", 46, "joao@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Maria", 11, "maria@gmail.com", 2, true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientes);
		
		gerClientes.pesquisaCliente(1);
		
		assertThat(cliente01.getId(), is(1));
	}
	
	/**
	 * Teste unitário - Remoção de Cliente por Id.
	 * 
	 * Unit Test - Delete Client by Id.
	 * 
	 * @author Robson Pomponet
	 * @date 2023/03/17
	 */
	
	@Test
	public void testRemoverCliente() {
		Cliente cliente01 = new Cliente(1, "Joao", 46, "joao@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Maria", 11, "maria@gmail.com", 2, true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		boolean remocao = gerClientes.removeCliente(2);
		
		assertTrue(remocao);
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(2));
	}
	
	/**
	 * Teste unitário - .
	 * 
	 * Unit Test - 
	 * 
	 * @author Robson Pomponet
	 * @date 2023/03/17
	 */
	
}
