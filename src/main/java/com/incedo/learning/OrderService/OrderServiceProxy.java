package com.incedo.learning.OrderService;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="Process-Service")
@RibbonClient(name="Process-Service")
public interface OrderServiceProxy {
	@RequestMapping(value="/process")
	public String getprocess();

}
