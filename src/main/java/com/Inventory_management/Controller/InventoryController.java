package com.Inventory_management.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory_management.Entity.Order;
import com.Inventory_management.Entity.Product;
import com.Inventory_management.Service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/processOrders")
    public ResponseEntity<String> processOrders(@RequestBody List<Order> orders) {
        inventoryService.processOrders(orders);
        return ResponseEntity.ok("Orders processed successfully.");
    }

    @PostMapping("/restock")
    public ResponseEntity<String> restockItems(@RequestBody List<Product> products) {
        inventoryService.restockItems(products);
        return ResponseEntity.ok("Items restocked successfully.");
    }
}

