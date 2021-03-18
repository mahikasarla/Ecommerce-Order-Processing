package com.example.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.OrderDto;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.model.OrderVO;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.util.RandomGeneratorService;

@Service
public class OrderService {

	@Autowired
	public OrderService(OrderRepository orderRepository, OrderDto orderDto, RandomGeneratorService rgService) {
		super();
		this.orderRepository = orderRepository;
		this.orderDto = orderDto;
		this.rgService = rgService;
	}

	private final OrderRepository orderRepository;

	private final OrderDto orderDto;

	private final RandomGeneratorService rgService;

	public List<OrderVO> findAll() {
		return orderDto.getOrderVOs(orderRepository.findAll());
	}

	public OrderVO findById(String orderId) {
		return orderDto.getOrderVO(orderRepository.findByOrderId(orderId));
	}

	public OrderVO save(OrderVO order) {
		Order orderEntity = orderDto.getEntityOrder(order);
		orderEntity.setOrderId(rgService.generateRandomString());
		return orderDto.getOrderVO(orderRepository.save(orderEntity));
	}

	public OrderVO updateOrder(OrderVO order, String orderId) {
		Order entityOrder = orderRepository.findByOrderId(orderId);
		return orderDto.getOrderVO(orderRepository.saveAndFlush(orderDto.getEntityOrder(entityOrder, order)));
	}

	public void deleteByOrderId(String orderId) {
		orderRepository.deleteByOrderId(orderId);
	}

	public List<OrderVO> saveAll(List<OrderVO> orders) {
		return orderDto.getOrderVOs(orderRepository.saveAll(orderDto.getEntityOrders(orders)));
	}

	public List<OrderVO> updateBatchOrders(List<OrderVO> orders) {
		List<Order> entityOrders = new ArrayList<Order>();
		for (OrderVO order : orders) {
			Order entityOrder = orderRepository.findByOrderId(order.getOrderId());
			entityOrder = orderDto.getEntityOrder(entityOrder, order);
			entityOrders.add(entityOrder);
		}
		return orderDto.getOrderVOs(orderRepository.saveAll(entityOrders));
	}

}
