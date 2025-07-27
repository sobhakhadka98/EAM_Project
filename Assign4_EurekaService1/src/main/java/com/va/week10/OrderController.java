package com.va.week10;

import com.va.week10.Order;
import com.va.week10.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping
	public ResponseEntity<String> placeOrder(@RequestBody Order order) {
	    try {
	        orderService.saveOrder(order);
	        return ResponseEntity.ok("Order placed successfully");
	    } catch (IllegalArgumentException ex) {
	        return ResponseEntity.badRequest().body(ex.getMessage());
	    }
	}

	@GetMapping("/user/{userId}")
	public List<Order> getOrdersByUser(@PathVariable String userId) {
	    return orderService.getOrdersByUser(userId);
	}

}
