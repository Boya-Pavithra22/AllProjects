package com.wipro.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import com.wipro.springboot.model.GroceryItem;
import com.wipro.springboot.repository.GroceryItemRepository;

@ExtendWith(MockitoExtension.class)
public class GroceryItemServiceTest {

    @Mock
    private GroceryItemRepository repository;

    @InjectMocks
    private GroceryItemService service;

    private GroceryItem item;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        item = new GroceryItem();
        item.setId(1L);
        item.setName("Milk");
        item.setQuantity(2);
        item.setPrice(30.0);
    }

    @Test
    void testCreateItem() {
        when(repository.save(any())).thenReturn(item);
        GroceryItem saved = service.createItem(item);
        assertEquals("Milk", saved.getName());
    }

    @Test
    public void testGetAllItems() {
        when(repository.findAll()).thenReturn(Arrays.asList(item));

        List<GroceryItem> items = service.getAllItems();

        assertEquals(1, items.size());
        assertEquals("Milk", items.get(0).getName());
    }

    @Test
    public void testGetItemById() {
        when(repository.findById(1L)).thenReturn(Optional.of(item));

        Optional<GroceryItem> item = Optional.of(service.getItemById(1L));

        assertTrue(item.isPresent());
        assertEquals("Milk", item.get().getName());
    }

    

    
    
}
