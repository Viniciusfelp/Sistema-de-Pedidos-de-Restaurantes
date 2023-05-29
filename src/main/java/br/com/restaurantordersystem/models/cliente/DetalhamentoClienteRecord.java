package br.com.restaurantordersystem.models.cliente;

import br.com.restaurantordersystem.models.Endereco;
import br.com.restaurantordersystem.models.cliente.Cliente;

public record DetalhamentoClienteRecord(String nome, String email, String telefone, Endereco endereco) {
    public DetalhamentoClienteRecord(Cliente cliente) {
        this(cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco());
    }
}
