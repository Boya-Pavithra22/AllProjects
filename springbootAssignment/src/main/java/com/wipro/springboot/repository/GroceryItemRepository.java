package com.wipro.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.springboot.model.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
}
