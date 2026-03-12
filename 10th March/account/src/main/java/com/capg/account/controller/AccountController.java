package com.capg.account.controller;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
public class AccountController {

	@GetMapping("/acc")
	public String show() {
		return "Return!!!!";
	}
}
