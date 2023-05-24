package br.com.restaurantordersystem.repositories;

import br.com.restaurantordersystem.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
