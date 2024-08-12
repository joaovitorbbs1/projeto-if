package projeto.modelosDAO;
import java.util.ArrayList;
import java.util.List;

import projeto.modelos.Cliente;

public class ClienteDAO {
	private List<Cliente> clientes;

	public ClienteDAO() {
		this.clientes = new ArrayList<>();
	}

	// Criar
	public void adicionarCliente(Cliente cliente) {
		cliente.setId(clientes.size() + 1);  // Definindo o ID automaticamente
		clientes.add(cliente);
		System.out.println("Cliente adicionado com sucesso!");
	}

	// Ler
	public Cliente buscarClientePorId(int id) {
		for (Cliente c : clientes) {
			if (c.getId() == id) {
				return c;
			}
		}
		System.out.println("Cliente não encontrado.");
		return null;
	}

	// Atualiza
	public void atualizarCliente(Cliente clienteAtualizado) {
		Cliente clienteExistente = buscarClientePorId(clienteAtualizado.getId());
		if (clienteExistente != null) {
			clienteExistente.setNome(clienteAtualizado.getNome());
			clienteExistente.setEndereco(clienteAtualizado.getEndereco());
			clienteExistente.setTelefone(clienteAtualizado.getTelefone());
			clienteExistente.setEmail(clienteAtualizado.getEmail());
			System.out.println("Cliente atualizado com sucesso!");
		}
	}

	// Remover
	public void removerCliente(int id) {
		Cliente cliente = buscarClientePorId(id);
		if (cliente != null) {
			clientes.remove(cliente);
			System.out.println("Cliente removido com sucesso!");
		}
	}
	
	public List<Cliente> listarClientes() {
		return clientes;
	}
}