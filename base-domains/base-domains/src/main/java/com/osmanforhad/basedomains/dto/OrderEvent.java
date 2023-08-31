package com.osmanforhad.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * by using this class
 * we are going to transfer Data
 * between Producer and Consumers
 * using Apache Kafka 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
	
	private String message;
	private String status;
	
	//instance of Order class
	private Order order;

}//End Class
