package br.com.restaurantordersystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {
    @Id
    private String cpf;
    private String nome;
    @Column(unique = true)
    private String email;
    @Embedded
    private Endereco endereco;
    private String telefone;
}
