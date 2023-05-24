package br.com.restaurantordersystem.services;

import br.com.restaurantordersystem.models.Usuario;
import br.com.restaurantordersystem.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuarioPorId(String cpf) {
        Optional<Usuario> usuario = usuarioRepository.findById(cpf);
        return usuario.orElse(null);
    }

    public Usuario atualizar (Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletar (String cpf) {
        usuarioRepository.deleteById(cpf);
    }

    public boolean usuarioExiste (String cpf) {
        return !usuarioRepository.existsById(cpf);
    }
}
