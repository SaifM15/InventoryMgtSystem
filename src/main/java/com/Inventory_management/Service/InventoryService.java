package com.Inventory_management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventory_management.Entity.Order;
import com.Inventory_management.Entity.Product;
import com.Inventory_management.Repository.OrderRepository;
import com.Inventory_management.Repository.ProductRepository;

@Service
public class InventoryService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    public void processOrders(List<Order> orders) {
        for (Order order : orders) {
            Product product = productRepository.findById(order.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
            if (product.getStockLevel() < order.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }
            product.setStockLevel(product.getStockLevel() - order.getQuantity());
            productRepository.save(product);
            orderRepository.save(order);
            if (product.getStockLevel() < 10) {
                System.out.println("Alert: Restock " + product.getName());
            }
        }
    }

    public void restockItems(List<Product> products) {
        for (Product product : products) {
            Product existingProduct = productRepository.findById(product.getId()).orElseThrow(() -> new RuntimeException("Product not found"));
            existingProduct.setStockLevel(existingProduct.getStockLevel() + product.getStockLevel());
            productRepository.save(existingProduct);
        }
    }
}
