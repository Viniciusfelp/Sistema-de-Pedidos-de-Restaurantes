package br.com.restaurantordersystem.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario(String cpf, String nome, String email, String senha, Endereco endereco, String telefone, String cargo) {
        super(cpf, nome, email, senha, endereco, telefone);
        this.cargo = cargo;
    }
}
