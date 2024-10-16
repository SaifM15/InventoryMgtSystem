package com.Inventory_management.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Inventory_management.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
