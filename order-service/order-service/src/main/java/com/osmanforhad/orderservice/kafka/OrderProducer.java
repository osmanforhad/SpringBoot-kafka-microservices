package com.osmanforhad.orderservice.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.osmanforhad.basedomains.dto.OrderEvent;

@Service
public class OrderProducer {
	
	/**
	 * Create Logger instance
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);
	
	/**
	 * Inject kafka Topic Dependencies
	 */
	private NewTopic topic;
	
	/**
	 * Inject and Kafka Template to
	 * send our message to kafka
	 */
	private KafkaTemplate<String, OrderEvent> kafkaTemplate;

	/**
	 * Constructor Method
	 * @param topic
	 * @param kafkaTemplate
	 */
	public OrderProducer(NewTopic topic, KafkaTemplate<String, OrderEvent> kafkaTemplate) {
		super();
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}//End Method
	
	/**
	 * Method for Sending Message
	 */
	public void sendMessage(OrderEvent event) {
		//show the event log
		LOGGER.info(String.format("Order evenet => %s", event.toString()));
		//create the message
		Message<OrderEvent> message = MessageBuilder.withPayload(event)
				.setHeader(KafkaHeaders.TOPIC,
						topic.name()).build();
		//send message using kafka template
		kafkaTemplate.send(message);
	}//End Method
	
	
}//End Class
