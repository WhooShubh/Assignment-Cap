package com.capg.processing_service.service;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.capg.processing_service.config.RabbitConfig;
import com.capg.processing_service.dto.RequestMessageDto;

@Service
public class ProcessingService {

	@RabbitListener(queues = RabbitConfig.Recharge_Queue)
	public void recieveMessage(RequestMessageDto message) {
		System.out.println("Recharge Message recieved for "+message.getMobileNumber());
	}
	
	@RabbitListener(queues = RabbitConfig.Payment_Queue)
	public void recievePaymentMessage(String message) {
		System.out.println("Payment processing with amount "+message);
		
		if(!message.equalsIgnoreCase("100")) {
//			throw new AmqpRejectAndDontRequeueException("Amount is not valid 100");
			throw new RuntimeException("Amount is not valid 100"); //it will run for 10 seconds as we have mentioned 10000
		}
		
		System.out.println("Payment done with amount "+message);
	}
}
