package br.com.restaurantordersystem.models.pedido;

import br.com.restaurantordersystem.models.cliente.Cliente;
import br.com.restaurantordersystem.models.funcionario.Funcionario;
import br.com.restaurantordersystem.models.produto.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String codigo;
    @ManyToOne
    @JoinColumn(name = "cpf_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "cpf_funcionario")
    private Funcionario funcionario;
    @ManyToMany
    @JoinTable(name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_codigo"),
            inverseJoinColumns = @JoinColumn(name = "produto_codigo"))
    private List<Produto> produtos;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime data;
}
