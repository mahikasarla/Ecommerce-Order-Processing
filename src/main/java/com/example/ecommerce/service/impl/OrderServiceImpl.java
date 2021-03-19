package com.example.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.OrderDto;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.exceptions.OrderNotfoundException;
import com.example.ecommerce.model.OrderVO;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.service.OrderService;
import com.example.ecommerce.util.RandomGeneratorService;

/**
 * @author MahenderKasarla
 *
 */
/**
 * @author MahenderKasarla
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository, OrderDto orderDto, RandomGeneratorService rgService) {
		super();
		this.orderRepository = orderRepository;
		this.orderDto = orderDto;
		this.rgService = rgService;
	}

	private final OrderRepository orderRepository;

	private final OrderDto orderDto;

	private final RandomGeneratorService rgService;

	@Override
	public List<OrderVO> findAll() {
		LOGGER.debug("getting orders from db");
		return orderDto.getOrderVOs(orderRepository.findAll());
	}

	@Override
	public OrderVO findById(String orderId) {
		LOGGER.debug("getting single order from db");
		Order order = orderRepository.findByOrderId(orderId);
		if (order == null) {
			throw new OrderNotfoundException("Order " + orderId + " not found");
		}
		return orderDto.getOrderVO(order);
	}

	@Override
	public OrderVO updateOrder(OrderVO order, String orderId) {
		Order entityOrder = orderRepository.findByOrderId(orderId);
		LOGGER.debug("updating single order from db");
		if (order == null) {
			throw new OrderNotfoundException("Order " + orderId + " not found");
		}
		return orderDto.getOrderVO(orderRepository.saveAndFlush(orderDto.getEntityOrder(entityOrder, order)));
	}

	@Override
	public void deleteByOrderId(String orderId) {
		LOGGER.debug("delete single order from db");
		orderRepository.deleteByOrderId(orderId);
	}

	@Override
	public List<OrderVO> saveAll(List<OrderVO> orders) {
		LOGGER.debug("saving batch the orders");
		return orderDto.getOrderVOs(orderRepository.saveAll(orderDto.getEntityOrders(orders)));
	}

	@Override
	public List<OrderVO> updateBatchOrders(List<OrderVO> orders) {
		LOGGER.debug("updating batch the orders");
		List<Order> entityOrders = new ArrayList<Order>();
		for (OrderVO order : orders) {
			Order entityOrder = orderRepository.findByOrderId(order.getOrderId());
			entityOrder = orderDto.getEntityOrder(entityOrder, order);
			entityOrders.add(entityOrder);
		}
		return orderDto.getOrderVOs(orderRepository.saveAll(entityOrders));
	}

	@Override
	public OrderVO createOrder(OrderVO order) {
		LOGGER.debug("saving single order");
		Order orderEntity = orderDto.getEntityOrder(order);
		orderEntity.setOrderId(rgService.generateRandomString(6));
		return orderDto.getOrderVO(orderRepository.save(orderEntity));
	}

}
