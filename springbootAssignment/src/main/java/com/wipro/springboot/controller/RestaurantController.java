package com.wipro.springboot.controller;

import com.wipro.springboot.model.*;
import com.wipro.springboot.service.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    // ✅ Get restaurant by ID
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getRestaurantById(id), HttpStatus.OK);
    }

    // ✅ Create restaurant
    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@Valid @RequestBody Restaurant restaurant) {
        return new ResponseEntity<>(service.createRestaurant(restaurant), HttpStatus.CREATED);
    }

    // ✅ Get all restaurants
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return service.getAllRestaurants();
    }

    // ✅ Delete restaurant by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        service.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @Valid @RequestBody Restaurant updatedRestaurant) {
        return new ResponseEntity<>(service.updateRestaurant(id, updatedRestaurant), HttpStatus.OK);
    }

    // ✅ Add food to a restaurant
    @PostMapping("/{id}/food")
    public ResponseEntity<Food> addFood(@PathVariable Long id, @Valid @RequestBody Food food) {
        return new ResponseEntity<>(service.addFoodToRestaurant(id, food), HttpStatus.CREATED);
    }

    // ✅ Delete food by ID
    @DeleteMapping("/foods/{foodId}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long foodId) {
        service.deleteFoodById(foodId);
        return ResponseEntity.noContent().build();
    }
}
