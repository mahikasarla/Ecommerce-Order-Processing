package com.example.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.OrderDto;
import com.example.ecommerce.entity.Order;
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
		return orderDto.getOrderVOs(orderRepository.findAll());
	}

	@Override
	public OrderVO findById(String orderId) {
		return orderDto.getOrderVO(orderRepository.findByOrderId(orderId));
	}

	@Override
	public OrderVO updateOrder(OrderVO order, String orderId) {
		Order entityOrder = orderRepository.findByOrderId(orderId);
		return orderDto.getOrderVO(orderRepository.saveAndFlush(orderDto.getEntityOrder(entityOrder, order)));
	}

	@Override
	public void deleteByOrderId(String orderId) {
		orderRepository.deleteByOrderId(orderId);
	}

	@Override
	public List<OrderVO> saveAll(List<OrderVO> orders) {
		return orderDto.getOrderVOs(orderRepository.saveAll(orderDto.getEntityOrders(orders)));
	}

	@Override
	public List<OrderVO> updateBatchOrders(List<OrderVO> orders) {
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
		Order orderEntity = orderDto.getEntityOrder(order);
		orderEntity.setOrderId(rgService.generateRandomString(6));
		return orderDto.getOrderVO(orderRepository.save(orderEntity));
	}

}
