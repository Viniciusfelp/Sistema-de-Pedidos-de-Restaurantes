package br.com.restaurantordersystem.models;

public record FuncionarioAtualizarRecord (
        String cpf,
        String nome,
        String email,
        String senha,
        Endereco endereco,
        String telefone,
        String cargo){
}
