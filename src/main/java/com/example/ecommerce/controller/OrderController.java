package com.example.ecommerce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.OrderVO;
import com.example.ecommerce.service.OrderService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Order resources")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/orders")
	public ResponseEntity<List<OrderVO>> getOrders() {
		return ResponseEntity.ok().body(orderService.findAll());
	}

	@GetMapping("/orders/{order-id}")
	public ResponseEntity<OrderVO> getOrderById(@PathVariable(value = "order-id") String orderId) {
		OrderVO Order = orderService.findById(orderId);
		return ResponseEntity.ok().body(Order);
	}

	@PostMapping("/orders")
	@ResponseBody
	public OrderVO createOrder(@RequestBody OrderVO order) {
		return orderService.save(order);
	}

	@PutMapping("/orders/{id}")
	public ResponseEntity<OrderVO> updateOrder(@PathVariable(value = "id") String orderId,
			@RequestBody OrderVO orderDetails) {
		OrderVO order = orderService.updateOrder(orderDetails, orderId);
		return ResponseEntity.ok(order);
	}

	@DeleteMapping("/orders/{id}")
	@ResponseBody
	public Map<String, Boolean> deleteOrder(@PathVariable(value = "id") String orderId) {
		orderService.deleteByOrderId(orderId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("cancelled", Boolean.TRUE);
		return response;
	}

	@PostMapping("/orders")
	@ResponseBody
	public List<OrderVO> createBatchOrders(@RequestBody List<OrderVO> orders) {
		return orderService.saveAll(orders);
	}

	@PutMapping("/orders/{id}")
	public ResponseEntity<List<OrderVO>> updatebatchOrders(@PathVariable(value = "id") Long orderId,
			@RequestBody List<OrderVO> orderDetails) {
		List<OrderVO> order = orderService.updateBatchOrders(orderDetails);
		return ResponseEntity.ok(order);
	}

}
