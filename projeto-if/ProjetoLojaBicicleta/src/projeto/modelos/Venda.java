package projeto.modelos;
import java.util.Date;
import java.util.List;

public class Venda {
	private int id;
	private Date data;
	private Cliente cliente;
	private List<Produto> listaDeProdutos;
	private double total;

	public Venda(int id, Date data, Cliente cliente, List<Produto> listaDeProdutos) {
		this.id = id;
	    this.data = new Date();
        this.cliente = cliente;;
		this.listaDeProdutos = listaDeProdutos;
		this.calcularTotal(total);
	}

	private void calcularTotal(double total2) {
		// TODO Auto-generated method stub
		 this.total = 0;
	        for (Produto p : listaDeProdutos) {
	            this.total += p.getPreco();
	            p.reduzirEstoque(1);  // Assume que uma unidade de cada produto é vendida
	        }
	}

	public Venda(int vendaId, Cliente cliente2, Object cliente3, List<Produto> calcularTotalCarrinho) {
		// TODO Auto-generated constructor stub
	}

	public Venda(int vendaId, Cliente cliente2, Object cliente3, double calcularTotalCarrinho) {
		// TODO Auto-generated constructor stub
	}

	// Getters e setters


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public void setListaDeProdutos(List<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
		calcularTotal(total); // Recalcula o total quando a lista de produtos é atualizada
	}

	// Métodos para inserir, emitir fatura, verificar estoque
    // Adiciona um produto à venda e recalcula o total
    public void adicionarProduto(Produto produto) {
        this.listaDeProdutos.add(produto);
        this.total += produto.getPreco();
        produto.reduzirEstoque(1);
    }

    // Remove um produto da venda e recalcula o total
    public void removerProduto(Produto produto) {
        if (this.listaDeProdutos.remove(produto)) {
            this.total -= produto.getPreco();
            produto.aumentarEstoque(1);
        }
    }

    // Método para imprimir o resumo da venda
    public void imprimirResumo() {
        System.out.println("Venda ID: " + id);
        System.out.println("Data: " + data);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Produtos:");
        for (Produto p : listaDeProdutos) {
            System.out.println(" - " + p.getNome() + " (Preço: " + p.getPreco() + ")");
        }
        System.out.println("Total: " + total);
    }

}






