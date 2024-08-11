package projeto.principal;

import java.util.Scanner;
import projeto.modelos.Cliente;
import projeto.modelos.Produto;
import projeto.modelosDAO.ClienteDAO;
import projeto.modelosDAO.ProdutoDAO;

public class Principal {
	//
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		ProdutoDAO bicicletaDAO = new ProdutoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		String user;
		String senha;
		
		do {
			System.out.println("User: ");
			user = leitor.nextLine();

			System.out.println("Senha: ");
			senha = leitor.nextLine();
		} while (!(user.equals("root")) || !(senha.equals("1234")));
		
		//menu provisório em andamento(se necessário)
		
		// Criar e adicionar bicicletas
		Produto bicicleta1 = new Produto("Mountain Bike", 1200.00, 15, 3);
		Produto bicicleta2 = new Produto("Bicicleta Elétrica", 3500.00, 5, 1);
		Produto bicicleta3 = new Produto("Bicicleta", 200.0, 10, 2); 
		bicicletaDAO.adicionarProduto(bicicleta1);
		bicicletaDAO.adicionarProduto(bicicleta2);
		bicicletaDAO.adicionarProduto(bicicleta3);

		// Listar bicicletas
		System.out.println("Lista de Bicicletas:");
		for (Produto b : bicicletaDAO.listarProdutos()) {
			System.out.println(b);
		}

		// Atualizar bicicleta
		bicicleta1.setPreco(1150.00);
		bicicletaDAO.atualizarProduto(bicicleta1);

		// Remover bicicleta
		bicicletaDAO.removerProduto(2);

		// Criar e adicionar clientes
		Cliente cliente1 = new Cliente("Carlos", "Rua das Flores, 123", "987654321", "carlos@example.com");
		Cliente cliente2 = new Cliente("Ana", "Avenida Central, 456", "123456789", "ana@example.com");
		Cliente cliente3 = new Cliente("Marquinos", "Rua 2", "99988776655", "marquinhos@email.com");
		clienteDAO.adicionarCliente(cliente1);
		clienteDAO.adicionarCliente(cliente2);
		clienteDAO.adicionarCliente(cliente3);

		cliente1.adicionarAoCarrinho(bicicleta1);
		System.out.println(cliente1.exibirCarrinhoDeCompras());

		// Listar clientes
		System.out.println("\nLista de Clientes:");
		for (Cliente c : clienteDAO.listarClientes()) {
			System.out.println(c.getNome());
		}

		// Atualizar cliente
		cliente1.setEndereco("Rua das Palmeiras, 789");
		clienteDAO.atualizarCliente(cliente1);

		// Remover cliente
		clienteDAO.removerCliente(2);
		leitor.close();
	}
}
