package com.wipro.springboot.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.springboot.model.Food;


public interface FoodRepository extends JpaRepository<Food, Long> {
}
