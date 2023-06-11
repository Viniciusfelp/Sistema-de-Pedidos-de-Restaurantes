package br.com.restaurantordersystem.models.produto;

import br.com.restaurantordersystem.models.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "produtos")
public class Produto {
    @Id
    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}
