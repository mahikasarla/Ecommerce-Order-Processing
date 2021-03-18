package com.example.ecommerce.service;

import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.ecommerce.dto.OrderDto;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.model.OrderVO;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.service.impl.OrderServiceImpl;
import com.example.ecommerce.util.RandomGeneratorService;

@DisplayName("Order Service Test")
public class OrderServiceImplTest {

	private OrderService orderService;

	@Mock
	private OrderDto orderDto;
	@Mock
	private OrderRepository orderRepository;
	@Mock
	private RandomGeneratorService rgService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		orderService = new OrderServiceImpl(orderRepository, orderDto, rgService);
	}

	@Test
	public void findById() {

		doReturn(new Order()).when(orderRepository).findByOrderId(ArgumentMatchers.anyString());
		doReturn(getOrderVO()).when(orderDto).getOrderVO(ArgumentMatchers.any(Order.class));

		// Execute the service call
		OrderVO orderVO = orderService.findById("txnId");

		// Assert the response
		Assertions.assertEquals(orderVO.getOrderItemName(), "process");
	}

	private OrderVO getOrderVO() {
		OrderVO orderVO = new OrderVO();
		orderVO.setOrderItemName("process");
		return orderVO;
	}
}
