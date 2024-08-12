package projeto.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Loja {
	private List<Produto> listaDeProdutos;
	private List<Cliente> listaDeClientes;
	private List<Venda> listaDeVendas;

	public Loja() {
		this.listaDeProdutos = new ArrayList<>();
		this.listaDeClientes = new ArrayList<>();
		this.listaDeVendas = new ArrayList<>();
	}

	// Getters e setters

	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}
	public void setListaDeProdutos(List<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}
	public List<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}
	public void setListaDeClientes(List<Cliente> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}
	public List<Venda> getListaDeVendas() {
		return listaDeVendas;
	}
	public void setListaDeVendas(List<Venda> listaDeVendas) {
		this.listaDeVendas = listaDeVendas;
	}

	public void adicionarVenda(Venda venda) {
		listaDeVendas.add(venda);

	}
	public static Loja getInstance() {
		Object instance = null;
		if (instance == null) {
			instance = new Loja();
		}
		return getInstance ();
	}

	// Métodos para adicionar, remover produtos e clientes, realizar venda, obter informações da loja

	// Métodos para obter informações sobre vendas
	@SuppressWarnings({ "deprecation", "null" })
	public double totalVendasDoMes(int mes, int ano) {
		double total = 0;
		Venda[] vendasPorDia = null;
		for (Venda v : vendasPorDia) {
			Date data = v.getData();
			if (data.getMonth() + 1 == mes && (data.getYear() + 1900) == ano) {
				total += v.getTotal();
			}
		}
		return total;
	}

	@SuppressWarnings("null")
	public Produto produtoMaisVendido() {
		Map<Produto, Integer> vendasPorProduto = new HashMap<>();
		Venda[] vendasPorDia = null;
		for (Venda v : vendasPorDia) {
			for (Produto p : v.getListaDeProdutos()) {
				vendasPorProduto.put(p, vendasPorProduto.getOrDefault(p, 0) + 1);
			}
		}
		Produto maisVendido = null;
		int maxVendas = 0;
		for (Map.Entry<Produto, Integer> entry : vendasPorProduto.entrySet()) {
			if (entry.getValue() > maxVendas) {
				maisVendido = entry.getKey();
				maxVendas = entry.getValue();
			}
		}
		return maisVendido;
	}

	@SuppressWarnings("null")
	public Cliente melhorCliente() {
		Map<Cliente, Double> totalGastoPorCliente = new HashMap<>();
		Venda[] vendasPorDia = null;
		for (Venda v : vendasPorDia) {
			Cliente cliente = v.getCliente();
			totalGastoPorCliente.put(cliente, totalGastoPorCliente.getOrDefault(cliente, 0.0) + v.getTotal());
		}
		Cliente melhorCliente = null;
		double maxGasto = 0;
		for (Map.Entry<Cliente, Double> entry : totalGastoPorCliente.entrySet()) {
			if (entry.getValue() > maxGasto) {
				melhorCliente = entry.getKey();
				maxGasto = entry.getValue();
			}
		}
		return melhorCliente;
	}

	@SuppressWarnings("null")
	public Produto produtoMenosVendido() {
		Map<Produto, Integer> vendasPorProduto = new HashMap<>();
		Venda[] vendas = null;
		for (Venda v : vendas) {
			for (Produto p : v.getListaDeProdutos()) {
				vendasPorProduto.put(p, vendasPorProduto.getOrDefault(p, 0) + 1);
			}
		}
		Produto menosVendido = null;
		int minVendas = Integer.MAX_VALUE;
		for (Map.Entry<Produto, Integer> entry : vendasPorProduto.entrySet()) {
			if (entry.getValue() < minVendas) {
				menosVendido = entry.getKey();
				minVendas = entry.getValue();
			}
		}
		return menosVendido;
	}

	@SuppressWarnings("null")
	public String diaComMaisVendas() {
		Map<String, Integer> vendasPorDia = new HashMap<>();
		Venda[] vendas = null;
		for (Venda v : vendas) {
			String data = v.getData().toString();
			vendasPorDia.put(data, vendasPorDia.getOrDefault(data, 0) + 1);
		}
		String diaMaisVendas = null;
		int maxVendas = 0;
		for (Map.Entry<String, Integer> entry : vendasPorDia.entrySet()) {
			if (entry.getValue() > maxVendas) {
				diaMaisVendas = entry.getKey();
				maxVendas = entry.getValue();
			}
		}
		return diaMaisVendas;

	}

	public List<Produto> listarProdutos() {
		// TODO Auto-generated method stub
		return listaDeProdutos;
	}

	public void removerProduto(int idRemover) {
		// TODO Auto-generated method stub
		boolean removido = listaDeProdutos.removeIf(p -> p.getId() == idRemover);
		if (removido) {
			System.out.println("Produto removido com sucesso!");
		} else {
			System.out.println("Produto não encontrado.");
		}
	}

	public void atualizarProduto(int idAtualizar, Produto produtoAtualizado) {
		// TODO Auto-generated method stub
		for (Produto p : listaDeProdutos) {
			if (p.getId() == idAtualizar) {
				p.setNome(produtoAtualizado.getNome());
				p.setPreco(produtoAtualizado.getPreco());
				p.setQuantidadeEmEstoque(produtoAtualizado.getQuantidadeEmEstoque());
				p.setEstoqueMinimo(produtoAtualizado.getEstoqueMinimo());
				System.out.println("Produto atualizado com sucesso!");
				return;
			}
		}
	}

	public void adicionarProduto(Produto novoProduto) {
		// TODO Auto-generated method stub
		listaDeProdutos.add(novoProduto);
		System.out.println("Produto adicionado com sucesso!");
	}


}
