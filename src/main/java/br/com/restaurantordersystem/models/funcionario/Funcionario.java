package br.com.restaurantordersystem.models.funcionario;

import br.com.restaurantordersystem.models.Endereco;
import br.com.restaurantordersystem.models.abstrata.Pessoa;
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

    public Funcionario(String cpf, String nome, String email, Endereco endereco, String telefone, String cargo) {
        super(cpf, nome, email, endereco, telefone);
        this.cargo = cargo;
    }
}
