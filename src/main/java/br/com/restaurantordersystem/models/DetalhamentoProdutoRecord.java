package br.com.restaurantordersystem.models;

public record DetalhamentoProdutoRecord(String nome, double preco, Categoria categoria) {
    public DetalhamentoProdutoRecord(Produto produto) {
        this(produto.getNome(), produto.getPreco(), produto.getCategoria());
    }
}
