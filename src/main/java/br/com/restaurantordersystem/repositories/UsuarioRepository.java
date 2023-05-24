package br.com.restaurantordersystem.repositories;

import br.com.restaurantordersystem.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
