package com.capg.processing_service.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.capg.processing_service.config.RabbitConfig;
import com.capg.processing_service.dto.RequestMessageDto;

@Service
public class ProcessingService {

	@RabbitListener(queues = RabbitConfig.QUEUE_NAME)
	public void recieveMessage(RequestMessageDto message) {
		System.out.println("Recharge Message recieved for "+message.getMobileNumber());
	}
}
