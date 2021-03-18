package com.example.ecommerce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.OrderVO;
import com.example.ecommerce.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Order controller")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/orders")
	@ApiOperation(value = "gets the all the orders", response = HttpResponse.class)
	public ResponseEntity<List<OrderVO>> getOrders() {
		return ResponseEntity.ok().body(orderService.findAll());
	}

	@GetMapping("/orders/{order-id}")
	@ApiOperation(value = "gets the order based on order-id", response = HttpResponse.class)
	public ResponseEntity<OrderVO> getOrderById(@PathVariable(value = "order-id") String orderId) {
		OrderVO order = orderService.findById(orderId);
		return ResponseEntity.ok().body(order);
	}

	@PostMapping("/orders")
	@ApiOperation(value = "creates the order", response = HttpResponse.class)
	public ResponseEntity<OrderVO> createOrder(@RequestBody OrderVO order) {
		return ResponseEntity.ok().body(orderService.createOrder(order));
	}

	@PutMapping("/orders/{id}")
	@ApiOperation(value = "updates the order based on order-id", response = HttpResponse.class)
	public ResponseEntity<OrderVO> updateOrder(@PathVariable(value = "id") String orderId,
			@RequestBody OrderVO orderDetails) {
		OrderVO order = orderService.updateOrder(orderDetails, orderId);
		return ResponseEntity.ok().body(order);
	}

	@DeleteMapping("/orders/{id}")
	@ApiOperation(value = "deletes the order based on order-id", response = HttpResponse.class)
	public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable(value = "id") String orderId) {
		orderService.deleteByOrderId(orderId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("cancelled", Boolean.TRUE);
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/batch-orders")
	@ApiOperation(value = "creates the batch orders", response = HttpResponse.class)
	public ResponseEntity<List<OrderVO>> createBatchOrders(@RequestBody List<OrderVO> orders) {
		return ResponseEntity.ok().body(orderService.saveAll(orders));
	}

	@PutMapping("/batch-orders")
	@ApiOperation(value = "updates the batch orders", response = HttpResponse.class)
	public ResponseEntity<List<OrderVO>> updatebatchOrders(@RequestBody List<OrderVO> orderDetails) {
		List<OrderVO> order = orderService.updateBatchOrders(orderDetails);
		return ResponseEntity.ok().body(order);
	}

}
