package br.com.restaurantordersystem.models.pedido;

import br.com.restaurantordersystem.models.produto.Produto;

import java.time.LocalDateTime;
import java.util.List;

public record DetalhamentoPedidoRecord(String codigo, String nomeCliente, String nomeFuncionario, List<Produto> produtos, LocalDateTime data) {
    public DetalhamentoPedidoRecord(Pedido pedido) {
        this(pedido.getCodigo(), pedido.getCliente().getNome(), pedido.getFuncionario().getNome(), pedido.getProdutos(), pedido.getData());
    }
}
