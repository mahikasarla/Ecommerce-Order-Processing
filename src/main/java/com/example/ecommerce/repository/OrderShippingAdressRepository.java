package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entity.OrderShippingAdress;

public interface OrderShippingAdressRepository extends JpaRepository<OrderShippingAdress, Long> {

}
