package br.com.restaurantordersystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
