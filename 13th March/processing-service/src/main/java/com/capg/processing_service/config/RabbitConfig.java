package com.capg.processing_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	
	public static final String QUEUE_NAME = "Recharge_Queue";
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME, true); // false ka mtlb hai jb payemnt on ho jaega tab jaega message, agr true hota toh bina on hue bhi message jata usse
	}
	
	@Bean
	public MessageConverter jsonMessageConverter() { // it will convert producer java message to json and save it to queue. And same happens when it will reach consumer.
		return new Jackson2JsonMessageConverter();
	}

}
