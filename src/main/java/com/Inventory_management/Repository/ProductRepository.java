package com.Inventory_management.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Inventory_management.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

