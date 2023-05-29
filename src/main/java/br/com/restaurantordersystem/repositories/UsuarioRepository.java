package br.com.restaurantordersystem.repositories;

import br.com.restaurantordersystem.models.autenticacao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);
}
