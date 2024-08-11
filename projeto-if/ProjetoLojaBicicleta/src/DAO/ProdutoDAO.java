package DAO;

import java.util.ArrayList;
import java.util.List;

import projeto.modelos.Produto;

public class ProdutoDAO {
    private List<Produto> produtos;

    public ProdutoDAO() {
        this.produtos = new ArrayList<>();
    }

    // Criar
    public void adicionarProduto(Produto produto) {
        produto.setId(produtos.size() + 1);  // Definindo o ID automaticamente
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    // Ler
    public Produto buscarProdutoPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        System.out.println("Produto não encontrado.");
        return null;
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    // Atualizar
    public void atualizarProduto(Produto produtoAtualizado) {
        Produto produtoExistente = buscarProdutoPorId(produtoAtualizado.getId());
        if (produtoExistente != null) {
            produtoExistente.setNome(produtoAtualizado.getNome());
            produtoExistente.setPreco(produtoAtualizado.getPreco());
            produtoExistente.setQuantidadeEmEstoque(produtoAtualizado.getQuantidadeEmEstoque());
            produtoExistente.setEstoqueMinimo(produtoAtualizado.getEstoqueMinimo());
            System.out.println("Produto atualizado com sucesso!");
        }
    }

    // Remover
    public void removerProduto(int id) {
        Produto produto = buscarProdutoPorId(id);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto removido com sucesso!");
        }
    }
}