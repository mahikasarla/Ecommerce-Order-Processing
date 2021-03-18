package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entity.OrderShippingAdress;

/**
 * @author MahenderKasarla
 *
 */
public interface OrderShippingAdressRepository extends JpaRepository<OrderShippingAdress, Long> {

}
