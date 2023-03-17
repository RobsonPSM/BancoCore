package sistemabancario;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Teste unitário da modelagem de Conta.
 * 
 * Unit testing Account.
 * 
 * @author Robson Pomponet
 * @date 2023/03/17
 * 
 * {@link GerenciadoraContas}
 */


public class GerenciadorContasTest1 {
	
	static GerenciadoraContas gerContas;
	
	/**
	 * Teste unitário - Transferência Bancária.
	 * 
	 * Unit Test - Bank transfer.
	 * 
	 * @author Robson Pomponet
	 * @date 2023/03/17
	 */
	
	@Test
	public void testTransfereValor() {
		
		List<ContaCorrente> contas = new ArrayList<>();
		
		ContaCorrente cc1 = new ContaCorrente(1, 200, true);
		ContaCorrente cc2 = new ContaCorrente(2, 150, true);
		contas.add(cc1);
		contas.add(cc2);
		
		gerContas = new GerenciadoraContas(contas);
		
		double saldocc1 =  gerContas.pesquisaConta(2).getSaldo();
		double saldocc2 = gerContas.pesquisaConta(2).getSaldo();
		boolean transferencia = gerContas.transfereValor(1, 100, 2);
		
		assertTrue(transferencia);
		assertThat(gerContas.pesquisaConta(1).getSaldo(), is(saldocc1-100));
		assertThat(gerContas.pesquisaConta(2).getSaldo(), is(saldocc2+100));
	}
}
