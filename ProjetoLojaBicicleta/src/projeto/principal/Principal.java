package projeto.principal;

import projeto.modelos.Cliente;
import projeto.modelos.Produto;

public class Principal {

	public static void main(String[] args) {
		Cliente cliente = new Cliente("Marquinos", "Rua 2", "99988776655", "marquinhos@email.com");
		
		Produto bicicleta = new Produto("Bicicleta", 200.0, 10, 2); 
		
		cliente.adicionarAoCarrinho(bicicleta);
		
		System.out.println(cliente.exibirCarrinhoDeCompras());
	}

}
