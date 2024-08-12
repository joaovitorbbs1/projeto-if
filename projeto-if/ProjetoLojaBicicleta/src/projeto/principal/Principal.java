package projeto.principal;

//import java.util.List;
import java.util.Scanner;

import projeto.modelos.Cliente;
import projeto.modelos.Loja;
import projeto.modelos.Produto;
import projeto.modelosDAO.ClienteDAO;
import projeto.modelosDAO.ProdutoDAO;

public class Principal {
	public static void main(String[] args) {

		Loja minhaLoja = new Loja();
	/*	Scanner scanner = new Scanner(System.in); */
		
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

	/*	while (true) {
            System.out.println("Menu:");
            System.out.println("1. Gerenciar Produtos");
            System.out.println("2. Gerenciar Clientes");
            System.out.println("3. Realizar Venda");
            System.out.println("4. Ver Total de Vendas do Mês");
            System.out.println("5. Ver Produto Mais Vendido");
            System.out.println("6. Ver Melhor Cliente");
            System.out.println("7. Imprimir Resumo da Venda");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    gerenciarProdutos(loja, scanner);
                    break;
                case 2:
                    gerenciarClientes(loja, scanner);
                    break;
                case 3:
                    realizarVenda(loja, scanner);
                    break;
                case 4:
                    verificarTotalVendasDoMes(loja, scanner);
                    break;
                case 5:
                    verificarProdutoMaisVendido(loja);
                    break;
                case 6:
                    verificarMelhorCliente(loja);
                    break;
                case 7:
                    imprimirResumoVenda(loja, scanner);
                    break;
                case 8:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarProdutos(Loja loja, Scanner scanner) {
        while (true) {
            System.out.println("Gerenciar Produtos:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Atualizar Produto");
            System.out.println("3. Remover Produto");
            System.out.println("4. Listar Produtos");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Quantidade em Estoque: ");
                    int quantidadeEmEstoque = scanner.nextInt();
                    System.out.print("Estoque Mínimo: ");
                    int estoqueMinimo = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    int idProduto = loja.listarProdutos().size() + 1;
                    loja.adicionarProduto(new Produto(idProduto, nome, preco, quantidadeEmEstoque, estoqueMinimo));
                    break;
                case 2:
                    System.out.print("ID do Produto a Atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    System.out.print("Novo Nome do Produto: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo Preço: ");
                    double novoPreco = scanner.nextDouble();
                    System.out.print("Nova Quantidade em Estoque: ");
                    int novaQuantidade = scanner.nextInt();
                    System.out.print("Novo Estoque Mínimo: ");
                    int novoEstoqueMinimo = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    loja.atualizarProduto(idAtualizar, new Produto(idAtualizar, novoNome, novoPreco, novaQuantidade, novoEstoqueMinimo));
                    break;
                case 3:
                    System.out.print("ID do Produto a Remover: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    loja.removerProduto(idRemover);
                    break;
                case 4:
                    System.out.println("Produtos:");
                    for (Produto p : loja.listarProdutos()) {
                        System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() + ", Preço: R$ " + p.getPreco() + ", Quantidade: " + p.getQuantidadeEmEstoque());
                    }
                    break;
                case 5:
                    return; // Voltar ao Menu Principal
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarClientes(Loja loja, Scanner scanner) {
        while (true) {
            System.out.println("Gerenciar Clientes:");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Atualizar Cliente");
            System.out.println("3. Remover Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    int idCliente = loja.listarClientes().size() + 1;
                    loja.adicionarCliente(new Cliente(idCliente, nome, endereco, telefone, email));
                    break;
                case 2:
                    System.out.print("ID do Cliente a Atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo Endereço: ");
                    String novoEndereco = scanner.nextLine();
                    System.out.print("Novo Telefone: ");
                    String novoTelefone = scanner.nextLine();
                    System.out.print("Novo Email: ");
                    String novoEmail = scanner.nextLine();
                    loja.atualizarCliente(idAtualizar, new Cliente(idAtualizar, novoNome, novoEndereco, novoTelefone, novoEmail));
                    break;
                case 3:
                    System.out.print("ID do Cliente a Remover: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    loja.removerCliente(idRemover);
                    break;
                case 4:
                    System.out.println("Clientes:");
                    for (Cliente c : loja.listarClientes()) {
                        System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome() + ", Email: " + c.getEmail());
                    }
                    break;
                case 5:
                    return; // Voltar ao Menu Principal
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void realizarVenda(Loja loja, Scanner scanner) {
        System.out.print("ID do Cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        Cliente cliente = loja.buscarClientePorId(idCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        List<Produto> carrinho = new ArrayList<>();
        while (true) {
            System.out.print("ID do Produto para adicionar ao carrinho (0 para finalizar): ");
            int idProduto = scanner.nextInt();
            if (idProduto == 0) break;
            scanner.nextLine(); // Consumir a nova linha
            Produto produto = loja.buscarProdutoPorId(idProduto);
            if (produto != null) {
                carrinho.add(produto);
                System.out.println("Produto adicionado ao carrinho.");
            } else {
                System.out.println("Produto não encontrado.");
            }
        }
        loja.realizarVenda(cliente, carrinho);
    }

    private static void verificarTotalVendasDoMes(Loja loja, Scanner scanner) {
        System.out.print("Mês (1-12): ");
        int mes = scanner.nextInt();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        double total = loja.totalVendasDoMes(mes, ano);
        System.out.println("Total de vendas do mês " + mes + "/" + ano + ": R$ " + total);
    }

    private static void verificarProdutoMaisVendido(Loja loja) {
        Produto maisVendido = loja.produtoMaisVendido();
        if (maisVendido != null) {
            System.out.println("Produto mais vendido: " + maisVendido.getNome());
        } else {
            System.out.println("Nenhum produto foi vendido.");
        }
    }

    private static void verificarMelhorCliente(Loja loja) {
        Cliente melhorCliente = loja.melhorCliente();
        if (melhorCliente != null) {
            System.out.println("Melhor cliente: " + melhorCliente.getNome());
        } else {
            System.out.println("Nenhum cliente encontrado.");
        }
    }

    private static void imprimirResumoVenda(Loja loja, Scanner scanner) {
        System.out.print("ID da Venda: ");
        int vendaId = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        loja.imprimirResumoVenda(vendaId);
    }
} */


		// Criar e adicionar bicicletas
		Produto bicicleta1 = new Produto("Mountain Bike", 1200.00, 15, 3);
		Produto bicicleta2 = new Produto("Bicicleta Elétrica", 3500.00, 5, 1);
		Produto bicicleta3 = new Produto("Bicicleta", 200.0, 10, 2); 
		bicicletaDAO.adicionarProduto(bicicleta1);
		bicicletaDAO.adicionarProduto(bicicleta2);
		bicicletaDAO.adicionarProduto(bicicleta3);


		// Aumentando o estoque
		bicicleta1.aumentarEstoque(5);

		// Exibindo a nova quantidade em estoque
		System.out.println("Novo estoque do produto " + bicicleta1.getNome() + ": " + bicicleta1.getQuantidadeEmEstoque());

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



		// Verificando total de vendas do mês
		double totalVendas = minhaLoja.totalVendasDoMes(8, 2024);
		System.out.println("\nTotal de vendas em agosto de 2024: R$" + totalVendas);

		// Verificando o produto mais vendido
		Produto maisVendido = minhaLoja.produtoMaisVendido();
		System.out.println("\nProduto mais vendido: " + maisVendido.getNome());

		// Verificando o melhor cliente
		Cliente melhorCliente = minhaLoja.melhorCliente();
		System.out.println("\nMelhor cliente: " + melhorCliente.getNome());

	}


}



