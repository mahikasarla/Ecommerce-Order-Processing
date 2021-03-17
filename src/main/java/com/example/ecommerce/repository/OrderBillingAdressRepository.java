package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entity.OrderBillingAdress;

public interface OrderBillingAdressRepository extends JpaRepository<OrderBillingAdress, Long> {
	void findAllByOrderId();

}
