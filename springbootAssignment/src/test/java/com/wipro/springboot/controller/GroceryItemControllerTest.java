package com.wipro.springboot.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.wipro.springboot.model.GroceryItem;
import com.wipro.springboot.service.GroceryItemService;

@WebMvcTest(GroceryItemController.class)
public class GroceryItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroceryItemService service;

    private GroceryItem item;

    @BeforeEach
    void setup() {
        item = new GroceryItem();
        item.setId(1L);
        item.setName("Rice");
        item.setQuantity(5);
        item.setPrice(50.0);
    }

    @Test
    void testGetAllItems() throws Exception {
        when(service.getAllItems()).thenReturn(List.of(item));

        mockMvc.perform(get("/api/grocery"))
               .andDo(print())  // 👈 Add this to debug response
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].name").value("Rice"));
    }

}