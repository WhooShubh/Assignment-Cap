package com.lpu.circuit_breaker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class TestService {
	
	int count = 0;
	
	@GetMapping("/test")
	@CircuitBreaker(name = "demoService" , fallbackMethod="fallbackMethod" )
	public String testServices() {
		count++;
		System.out.println("SErvice called : "+count);
		
		//first 3 req succeed
		
		if(count<= 3) {
			return "Request successful : "+count;
		}
		if(count == 9) {
			count = 0;
		}
		throw new RuntimeException("Service failed "+count);
	}
	
	public String fallbackMethod(RuntimeException ex) {
		
		System.out.println("falback executed!!!");
		return "fallback done :wait";
	}

}
