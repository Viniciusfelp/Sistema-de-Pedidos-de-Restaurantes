package br.com.restaurantordersystem.models.funcionario;

import br.com.restaurantordersystem.models.Endereco;

public record FuncionarioAtualizarRecord (
        String cpf,
        String nome,
        String email,
        String senha,
        Endereco endereco,
        String telefone,
        String cargo){
}
