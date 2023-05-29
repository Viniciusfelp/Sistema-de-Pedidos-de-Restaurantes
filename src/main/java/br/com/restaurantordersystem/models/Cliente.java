package br.com.restaurantordersystem.models;

import jakarta.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Cliente extends Pessoa {

    public Cliente(String cpf, String nome, String email, Endereco endereco, String telefone) {
        super(cpf, nome, email, endereco, telefone);
    }
}
