package projeto.modelos;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Venda {
	private int id;
	private Date data;
	private Cliente cliente;
	private List<Produto> listaDeProdutos;
	private double total;

	public Venda(int id, Date data, Cliente cliente, List<Produto> listaDeProdutos) {
		this.setId(id);
		this.setData(data);
		this.setCliente(cliente);
		this.listaDeProdutos = listaDeProdutos;
		this.calcularTotal(total);
	}

	private void calcularTotal(double total2) {
		// TODO Auto-generated method stub

	}

	public Venda(int vendaId, Cliente cliente2, Object cliente3, List<Produto> calcularTotalCarrinho) {
		// TODO Auto-generated constructor stub
	}

	public Venda(int vendaId, Cliente cliente2, Object cliente3, double calcularTotalCarrinho) {
		// TODO Auto-generated constructor stub
	}

	private void calcularTotal() {
		this.setTotal(0);
		for (Produto p : listaDeProdutos) {
			this.setTotal(this.getTotal() + p.getPreco());
		}
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
		calcularTotal(); // Recalcula o total quando a lista de produtos é atualizada
	}

	// Métodos para inserir, emitir fatura, verificar estoque
	//TEM QUE TERMINAR|!|!|!|!|!|!|!|!|!|!|! 
	public void realizarComprar(List<Produto> carrinho, Cliente cliente) {
		double precoTotal = 0;
		for(Produto p : carrinho) {
			System.out.println(p.toString());
			precoTotal = precoTotal + (p.getPreco() * p.getQuantidadeCompra());
		}
		System.out.println("Preço Total: R$ " + precoTotal);
		System.out.println("Confirma a compra? ");

		// Leitura da entrada do usuário para confirmar a compra
		try (Scanner scanner = new Scanner(System.in)) {
			String resposta = scanner.nextLine().trim().toLowerCase();

			if (resposta.equals("s")) { 
				this.data = new Date();
				this.cliente = cliente;
				this.listaDeProdutos = carrinho;
				calcularTotal();

				atualizarEstoque(carrinho);

				System.out.println("Compra realizada com sucesso!");
			} else {
				System.out.println("Compra cancelada.");
			}
		}
	}

	// Método para atualizar o estoque dos produtos
	private void atualizarEstoque(List<Produto> carrinho) {
		for (Produto p : carrinho) {
			p.reduzirEstoque(p.getQuantidadeCompra());
		}
	}
}





