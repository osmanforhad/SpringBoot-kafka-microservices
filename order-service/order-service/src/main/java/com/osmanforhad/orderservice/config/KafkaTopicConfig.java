package com.osmanforhad.orderservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	/**
	 * Retrieve topic name
	 */
	@Value("${spring.kafka.topic.name}")
	private String topicName;
	
	/**
	 * configure spring Bean for
	 * kafka topic
	 */
	@Bean
	public NewTopic topic() {
		return TopicBuilder.name(topicName).build();
	}//End Method
	
	
}//End Class
