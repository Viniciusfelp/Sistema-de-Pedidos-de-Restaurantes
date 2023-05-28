package br.com.restaurantordersystem.models;

import java.util.List;

public record DetalhamentoPedidoRecord(String codigo, String nomeCliente, String nomeFuncionario, List<Produto> produtos) {
    public DetalhamentoPedidoRecord(Pedido pedido) {
        this(pedido.getCodigo(), pedido.getCliente().getNome(), pedido.getFuncionario().getNome(), pedido.getProdutos());
    }
}
