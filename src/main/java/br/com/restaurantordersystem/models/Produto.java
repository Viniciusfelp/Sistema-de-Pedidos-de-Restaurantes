package br.com.restaurantordersystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {
    @Id
    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}
