package com.capg.recharge_service.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.recharge_service.dto.RequestMessageDto;
import com.capg.recharge_service.service.RechargeService;

@RequestMapping("/recharge")
@RestController
public class RechargeController {

	private final RechargeService service;

	public RechargeController(RechargeService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/sendMessage")
	public String sendRequest(@RequestBody RequestMessageDto message) {
		return service.sendRequest(message);
	}
	//client(message)-> controller(message)-> service(message)-> rabbitMq(message)-> consumer(message)
	
	@PostMapping("/sendPayment/{amount}")
	public String getPayment(@PathVariable String amount) {
		return service.sendRequest2(amount);
	}
}
