package br.com.restaurantordersystem.models;

import jakarta.persistence.Entity;

@Entity
public class Funcionario extends Usuario{
    private String cargo;
}
