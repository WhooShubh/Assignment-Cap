package com.capg.recharge_service.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.capg.recharge_service.config.RabbitConfig;
import com.capg.recharge_service.dto.RequestMessageDto;

@Service
public class RechargeService {

	private final RabbitTemplate rabbitTemplate; // iski wajhe se message jaega RabbitMQ ko

	public RechargeService(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}

	public String sendRequest(RequestMessageDto message) {
		rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, message);
		return "Recharge Request Sent to Queue";
	}
}
