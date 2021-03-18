package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entity.Order;

/**
 * @author MahenderKasarla
 *
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

	Order findByOrderId(String orderId);

	void deleteByOrderId(String orderId);

}
