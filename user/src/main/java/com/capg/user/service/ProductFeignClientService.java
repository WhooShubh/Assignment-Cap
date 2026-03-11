package com.capg.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("PRODUCT")
public interface ProductFeignClientService {

	@GetMapping("/pro/getproducts")
	public String getProducts();
}
