package com.example.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecommerce.model.OrderVO;

/**
 * @author MahenderKasarla
 *
 */
@Service
public interface OrderService {

	/**
	 * gets all the records
	 *
	 * @return
	 */
	List<OrderVO> findAll();

	/**
	 * gets the order record based on orderId
	 *
	 * @param orderId
	 * @return
	 */
	OrderVO findById(String orderId);

	/**
	 * creates order record
	 *
	 * @param order
	 * @return
	 */
	OrderVO createOrder(OrderVO order);

	/**
	 * updates given record based on orderId
	 *
	 * @param order
	 * @param orderId
	 * @return
	 */
	OrderVO updateOrder(OrderVO order, String orderId);

	/**
	 * deletes order record based on orderId
	 *
	 * @param orderId
	 */
	void deleteByOrderId(String orderId);

	/**
	 * saves batch of order records
	 *
	 * @param orders
	 * @return
	 */
	List<OrderVO> saveAll(List<OrderVO> orders);

	/**
	 * updates batch of order records
	 *
	 * @param orders
	 * @return
	 */
	List<OrderVO> updateBatchOrders(List<OrderVO> orders);
}
