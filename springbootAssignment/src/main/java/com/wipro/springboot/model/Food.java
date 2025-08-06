package com.wipro.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Food name is mandatory")
    private String name;

    @NotNull(message = "Price is mandatory")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore  // Prevent infinite recursion in JSON
    private Restaurant restaurant;

    // ----- Getters -----
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    // ----- Setters -----
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
