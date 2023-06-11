package br.com.restaurantordersystem.services;

import br.com.restaurantordersystem.models.cliente.Cliente;
import br.com.restaurantordersystem.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criar(Cliente usuario) {
        return clienteRepository.save(usuario);
    }

    public Cliente buscarPorId(String cpf) {
        Optional<Cliente> usuario = clienteRepository.findById(cpf);
        return usuario.orElse(null);
    }

    public Page<Cliente> findAll(Pageable pageable){
        return clienteRepository.findAll(pageable);
    }

    public Cliente atualizar (Cliente usuario) {
        return clienteRepository.save(usuario);
    }

    public void deletar (String cpf) {
        clienteRepository.deleteById(cpf);
    }

    public boolean existe(String cpf) {
        return !clienteRepository.existsById(cpf);
    }
}
