package com.incedo.learning.OrderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.incedo.learning.OrderService")
@ComponentScan({"com.incedo.learning.OrderService","configuration"})
public class OrderServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE; // ALWAYS_SAMPLE is to trace all the requests(to create
										// unique id =>>sleuth is used)

	}

}
