package com.incedo.learning.OrderService;

import java.util.Hashtable;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;


@Component
@Service
public class OrderService {
	Hashtable<String,Product> product=new Hashtable<String,Product>();
	/*@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;*/
	@Autowired
	private KafkaTemplate<String, Product> kafkaTemplate;
	String kafkaTopic = "myfirst-topic";
	
/*	public void send(String message) {
	    
	    kafkaTemplate.send(kafkaTopic, message);
	}*/

	public String retrieveMessage() {
		return "Hello!its Order page ";
	}
	public Hashtable<String,Product> getAll() {
		return product;
	}
}
