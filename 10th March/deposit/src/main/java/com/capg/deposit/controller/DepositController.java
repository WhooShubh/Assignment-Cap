package com.capg.deposit.controller;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
public class DepositController {
	
	@GetMapping("/dep")
	public String show() {
		return "Return!!!!";
	}
}
