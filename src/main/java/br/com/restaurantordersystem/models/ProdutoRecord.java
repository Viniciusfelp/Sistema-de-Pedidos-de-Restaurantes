package br.com.restaurantordersystem.models;

public record ProdutoRecord (String nome, String descricao, double preco, Categoria categoria){
    public Produto toProduto() {
        return new Produto(null, nome, descricao, preco, categoria);
    }
}
