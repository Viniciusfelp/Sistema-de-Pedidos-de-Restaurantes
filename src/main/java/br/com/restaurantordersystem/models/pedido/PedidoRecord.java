package br.com.restaurantordersystem.models.pedido;

import br.com.restaurantordersystem.models.cliente.Cliente;
import br.com.restaurantordersystem.models.funcionario.Funcionario;
import br.com.restaurantordersystem.models.produto.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public record PedidoRecord(
        @NotBlank(message = "O campo 'codigo' não pode estar em branco")
        String codigo,
        @NotNull(message = "O campo 'usuario' é obrigatório")
        Cliente usuario,
        @NotNull(message = "O campo 'funcionario' é obrigatório")
        Funcionario funcionario,
        @NotNull(message = "A lista de produtos não pode ser nula")
        @Size(min = 1, message = "A lista de produtos deve conter pelo menos um item")
        List<Produto> produtos
) {
    public Pedido toPedido() {
        return new Pedido(codigo(), usuario(), funcionario(), produtos());
    }
}
