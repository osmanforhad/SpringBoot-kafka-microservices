package com.osmanforhad.stockservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.osmanforhad.basedomains.dto.OrderEvent;

@Service
public class OrderConsumer {

	/**
	 * Create LOGGER Instance
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);
	
	/**
	 * Method for consume order
	 */
	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent event) {
		//log the event
		LOGGER.info(String.format("Order event received in stock service => %s", event.toString()));
		//save order event data into database
	}//End Method
	
}//End Class
