package com.wipro.springboot.service;



import com.wipro.springboot.model.*;
import com.wipro.springboot.exception.*;
import com.wipro.springboot.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepo;
    private final FoodRepository foodRepo;

    public RestaurantService(RestaurantRepository restaurantRepo, FoodRepository foodRepo) {
        this.restaurantRepo = restaurantRepo;
        this.foodRepo = foodRepo;
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id " + id));
    }

    public void deleteRestaurant(Long id) {
        Restaurant res = getRestaurantById(id);
        restaurantRepo.delete(res);
    }

    public Food addFoodToRestaurant(Long restaurantId, Food food) {
        Restaurant res = getRestaurantById(restaurantId);
        food.setRestaurant(res);
        return foodRepo.save(food);
    }

    public void deleteFoodById(Long foodId) {
        Food food = foodRepo.findById(foodId)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with id " + foodId));
        foodRepo.delete(food);
    }
    
    public Restaurant updateRestaurant(Long id, Restaurant updatedRestaurant) {
        Restaurant restaurant = getRestaurantById(id);
        restaurant.setName(updatedRestaurant.getName());
        restaurant.setLocation(updatedRestaurant.getLocation());
        return restaurantRepo.save(restaurant);
    }

}
