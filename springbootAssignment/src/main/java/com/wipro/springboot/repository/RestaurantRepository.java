package com.wipro.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.springboot.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
