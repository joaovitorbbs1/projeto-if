package projeto.modelos;
import java.util.List;

public class Loja {
    private static Loja instance;
	private List<Produto> listaDeProdutos;
    private List<Cliente> listaDeClientes;
    private List<Venda> listaDeVendas;
    
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
		 if (instance == null) {
	            instance = new Loja();
	        }
	        return getInstance ();
	}

    // Métodos para adicionar, remover produtos e clientes, realizar venda, obter informações da loja
	   
}
