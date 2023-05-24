package br.com.restaurantordersystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
    @Id
    private String cpf;
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;
    @Embedded
    private Endereco endereco;
    private String telefone;
}
