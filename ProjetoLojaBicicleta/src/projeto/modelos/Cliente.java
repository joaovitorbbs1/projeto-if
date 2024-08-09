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
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
        this.setEmail(email);
    }
    
    // Getters e setters
    
	public int getId() {
		return id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setId(int id) {
		this.id = id;
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



    // Métodos para inserir, modificar, apagar, consultar e listar
	
	public void adicionarAoCarrinho(Produto p) {
		if(carrinho == null) {
			carrinho = new ArrayList<>();
		}
		
		if (p.getQuantidadeCompra() + 1 > p.getQuantidadeEmEstoque()) {
			System.out.println("Produto insuficiente no estoque!");
		} else {
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
	
	//falta emitir a nota fiscal e adicionar na lista de venda               
	public void Comprar() {
		double precoTotal = 0;
		for(Produto p : carrinho) {
			System.out.println(p.toString());
			precoTotal = precoTotal + (p.getPreco() * p.getQuantidadeCompra());
		}
		System.out.println("Preço Total: R$" + precoTotal);
		
	}   
}

