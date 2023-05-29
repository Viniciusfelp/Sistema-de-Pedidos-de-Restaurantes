package br.com.restaurantordersystem.models.produto;

import br.com.restaurantordersystem.models.Categoria;

public record DetalhamentoProdutoRecord(String nome, double preco, Categoria categoria) {
    public DetalhamentoProdutoRecord(Produto produto) {
        this(produto.getNome(), produto.getPreco(), produto.getCategoria());
    }
}
