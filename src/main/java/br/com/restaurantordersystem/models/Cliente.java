package br.com.restaurantordersystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente extends Usuario{
    @Id
    private Long id;
}
