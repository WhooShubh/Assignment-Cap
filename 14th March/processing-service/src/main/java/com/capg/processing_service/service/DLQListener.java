package com.capg.processing_service.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.capg.processing_service.config.RabbitConfig;

@Component
public class DLQListener {

	@RabbitListener(queues = RabbitConfig.DLQ_Name)
	public void dlqMessage(String message) {
		System.out.println("Amount value is invalid "+message);
	}
}
