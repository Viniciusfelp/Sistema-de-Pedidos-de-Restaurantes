package br.com.restaurantordersystem.models.funcionario;

import br.com.restaurantordersystem.models.Endereco;
import jakarta.validation.constraints.*;

public record FuncionarioRecord (
        @NotNull
        @NotBlank
        @Size(min = 11, max = 11)
        @Pattern(regexp = "\\d{11}")
        String cpf,

        @NotNull
        @NotBlank
        @Size(max = 100)
        String nome,

        @NotNull
        @NotBlank
        @Email
        @Size(max = 100)
        String email,

        @NotNull
        @NotBlank
        @Size(min = 6, max = 100)
        String senha,

        @NotNull
        Endereco endereco,

        @NotNull
        @NotBlank
        @Size(max = 20)
        String telefone,

        @NotNull
        @NotBlank
        String cargo
){
    public Funcionario toFuncionario() {
        return new Funcionario(cpf(), nome(), email(), endereco(), telefone(), cargo());
    }
}
