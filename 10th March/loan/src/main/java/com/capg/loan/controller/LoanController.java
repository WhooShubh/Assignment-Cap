package com.capg.loan.controller;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
public class LoanController {

	@GetMapping("/loan")
	public String show() {
		return "Return!!!!";
	}
}
