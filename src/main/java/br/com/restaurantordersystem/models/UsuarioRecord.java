package br.com.restaurantordersystem.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public record UsuarioRecord(
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
        String telefone
) {
    public Usuario toUsuario() {
        return new Usuario(cpf(), nome(), email(), senha(), endereco(), telefone());
    }
}
