package projeto.modelos;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private int id;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private String senha; 
	private List<Produto> carrinho = null;  

	public Cliente(String nome, String endereco, String telefone, String email) {
		this.id = 0;  
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.senha = "";
		this.carrinho = new ArrayList<>();
	}

	// Getters e setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Produto> getCarrinho() {
		return carrinho;
	}


	// Métodos para inserir, modificar, apagar, consultar e listar

	public void adicionarAoCarrinho(Produto p) {
		if(carrinho == null) {
			carrinho = new ArrayList<>();
		}

		if (p.getQuantidadeCompra() + 1 > p.getQuantidadeEmEstoque()) {
			System.out.println("Produto insuficiente no estoque!");
		} else  {
			carrinho.add(p);
			p.setQuantidadeCompra(p.getQuantidadeCompra() + 1);
			System.out.println("Produto adicionado ao carrinho  com sucesso!");

		}
	}     



	public void removerDoCarrinho(Produto p) {
		/*checagem da lista de produtos para compra*/
		if(carrinho == null || carrinho.isEmpty()) {
			System.out.println("Este produto não existe no carrinho!");
		} else {
			/*percorrendo a lista de produtos para encontrar o objeto/produto e verificar a quantidade*/
			for(Produto p1 : carrinho) {
				if(p1 == p) {
					p1.setQuantidadeCompra(p1.getQuantidadeCompra() - 1);
					if (p1.getQuantidadeCompra() <= 0) {
						carrinho.remove(p1); 
					} 
					System.out.println("Produto removido com sucesso!");
				}
			}
		}
	}

	public List<Produto> exibirCarrinhoDeCompras(){
		return carrinho;
	} 
              
	public void Comprar() {
		double precoTotal = calcularTotalCarrinho();
		System.out.println("Preço Total: R$" + precoTotal);

		emitirNotaFiscal(precoTotal);
		criarVenda();

		carrinho.clear();
	}

	private double calcularTotalCarrinho() {
		double total = 0;
		for (Produto p : carrinho) {
			total += p.getPreco() * p.getQuantidadeCompra();
		}
		return total;
	}

	private void criarVenda() {

		// Gera um ID para a venda (pode ser incremental, mas aqui está simplificado)
		int vendaId = Loja.getInstance().getListaDeVendas().size() + 1;

		Venda venda = new Venda(vendaId, this, new ArrayList<>(carrinho), calcularTotalCarrinho());

		// Adiciona a venda à lista de vendas da loja
		Loja.getInstance().adicionarVenda(venda);
		System.out.println("Venda criada com sucesso!");

	}

	private void emitirNotaFiscal(double precoTotal) {
		System.out.println("===== NOTA FISCAL =====");
		System.out.println("Cliente: " + this.nome);
		System.out.println("Endereço: " + this.endereco);
		System.out.println("Telefone: " + this.telefone);
		System.out.println("Email: " + this.email);
		System.out.println("----------------------");
		for (Produto p : carrinho) {
			System.out.println("Produto: " + p.getNome() + " - Quantidade: " + p.getQuantidadeCompra() + " - Preço Unitário: R$" + p.getPreco());
		}
		System.out.println("----------------------");
		System.out.println("Total: R$" + precoTotal);
		System.out.println("======================");
	}   
}

