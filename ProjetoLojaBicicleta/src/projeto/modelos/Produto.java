package projeto.modelos;
public class Produto implements Comparable<Produto>{
    private int id;
    private String nome;
    private double preco;
    private int quantidadeCompra = 0;
    private int quantidadeEmEstoque;
    private int estoqueMinimo;

    public Produto(String nome, double preco, int quantidadeEmEstoque, int estoqueMinimo) {
        this.setNome(nome);
        this.setPreco(preco);
        this.setQuantidadeEmEstoque(quantidadeEmEstoque);
        this.setEstoqueMinimo(estoqueMinimo);
    }
    
    // Getters e setters

	public int getId() {
		return id;
	}

	public int getQuantidadeCompra() {
		return quantidadeCompra;
	}

	public void setQuantidadeCompra(int quantidadeCompra) {
		this.quantidadeCompra = quantidadeCompra;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	@Override
	public int compareTo(Produto p) {
		// TODO Auto-generated method stub
		return this.nome.compareToIgnoreCase(p.nome);
	}

	@Override
	public String toString() {
		return "\n" + nome + " Preco= R$ "+ preco;
	}

	
	
    // Métodos para inserir, modificar, apagar, consultar e listar
	
	
	
}


