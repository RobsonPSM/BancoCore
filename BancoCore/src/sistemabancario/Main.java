package sistemabancario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
	
	static GerenciadoraClientes gerClientes;
	static GerenciadoraContas gerContas;
	
	public static void main(String[] args) {
		 inicializaSistemaBancario();
		 
		 Scanner sc = new Scanner(System.in);
		 
		 boolean continua = true;
		 
		 while (continua) {
			 printMenu();
			
			 int opcao = sc.nextInt();
			 switch(opcao) {
			
			 case 1:
				 //consultar cliente
				 System.out.println("Digite o ID do cliente: ");
				 int idCliente = sc.nextInt();
				 Cliente cliente = gerClientes.pesquisaCliente(idCliente);
				 if (cliente!=null) {
					 System.out.println(cliente.toString());
				 } else {
					 System.out.println("Cliente não encontrado!");
				 }
				 break;
			 
			 case 2:
				 //consultar conta corrente
				 System.out.println("Digite o ID do conta: ");
				 int idConta = sc.nextInt();
				 ContaCorrente conta = gerContas.pesquisaConta(idConta);
				 break;
			 
			 case 3:
				 //ativar um cliente
				 System.out.println("Digite o ID do cliente a ser ativado: ");
				 int idCliente2=sc.nextInt();
				 Cliente cliente2 = gerClientes.pesquisaCliente(idCliente2);
				 if(cliente2!=null) {
					 cliente2.setAtivo(true);
					 System.out.println("Cliente ativado com sucesso!");
				 } else {
					 System.out.println("Cliente não encontrado!");
				 }
				 break;
			 case 4:
				 //desativar um cliente
				 System.out.println("Digite o ID do cliente a ser desativado: ");
				 int idCliente3=sc.nextInt();
				 Cliente cliente3 = gerClientes.pesquisaCliente(idCliente3);
				 if(cliente3!=null) {
					 cliente3.setAtivo(true);
					 System.out.println("Cliente desativado com sucesso!");
				 } else {
					 System.out.println("Cliente não encontrado!");
				 }
				 break;
			 case 5:
				 continua = false;
				 break;
			 }
		 }
	}

	private static void printMenu() {
		System.out.println("Escolha a operação");
		System.out.println("1- Consultar um Cliente");
		System.out.println("2- Consultar uma Conta Corrente");
		System.out.println("3- Ativar um Cliente");
		System.out.println("4- Desativar um Cliente");
		System.out.println("5- Sair");
		
		
	}

	private static void inicializaSistemaBancario() {
		//cria lista vazia de contas e cliente
		List<ContaCorrente> contas = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		
		ContaCorrente cc1 = new ContaCorrente(1, 0, true);
		ContaCorrente cc2 = new ContaCorrente(2, 0, true);
		contas.add(cc1);
		contas.add(cc2);
	
		//cria contas novas e insere na lista
		
		Cliente c1 = new Cliente(1, "João da Silva", 30, "joaodasilva@gmail.com", cc1.getId(), true);
		Cliente c2 = new Cliente(2, "Maria da Silva", 28, "mariadasilva@gmail.com", cc2.getId(), true);
		clientes.add(c1);
		clientes.add(c2);
		
		gerClientes = new GerenciadoraClientes(clientes);
		gerContas = new GerenciadoraContas(contas);
	}
}
