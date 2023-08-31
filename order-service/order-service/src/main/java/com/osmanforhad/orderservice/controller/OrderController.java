package com.osmanforhad.orderservice.controller;

import org.apache.kafka.common.Uuid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osmanforhad.basedomains.dto.Order;
import com.osmanforhad.basedomains.dto.OrderEvent;
import com.osmanforhad.orderservice.kafka.OrderProducer;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	/**
	 * Inject OrderProducer Class
	 */
	private OrderProducer orderProducer;

	/**
	 * Constructor Method
	 * @param orderProducer
	 */
	public OrderController(OrderProducer orderProducer) {
		super();
		this.orderProducer = orderProducer;
	}//End Method
	
	/**
	 * Order Place API
	 */
	@PostMapping("/orders")
	public String placeOrder(@RequestBody Order order) {
		//assign unique order id 
		order.setOrderId(Uuid.randomUuid().toString());
		//Create OrderEvent Instance
		OrderEvent orderEvent = new OrderEvent();
		//Set Initial Order status
		orderEvent.setStatus("PENDING");
		//show message for order status
		orderEvent.setMessage("order status is in pending state");
		//send an order
		orderEvent.setOrder(order);
		//send message to kafka
		orderProducer.sendMessage(orderEvent);
		
		return "Order Place Successfully...";
	}//End Method
	
	
	
	
}//End Class
