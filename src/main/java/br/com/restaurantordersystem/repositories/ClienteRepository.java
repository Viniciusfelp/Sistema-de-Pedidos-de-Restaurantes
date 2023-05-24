package br.com.restaurantordersystem.repositories;

import br.com.restaurantordersystem.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
