package br.com.restaurantordersystem.models.produto;

import br.com.restaurantordersystem.models.Categoria;

public record ProdutoRecord (String nome, String descricao, double preco, Categoria categoria){
    public Produto toProduto() {
        return new Produto(null, nome, descricao, preco, categoria);
    }
}
