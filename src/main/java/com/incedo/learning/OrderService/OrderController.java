package com.incedo.learning.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {
	//Autowiring--Injected here
	@Autowired
	 OrderService service ;
	@Autowired
	OrderServiceProxy proxy;
	@Autowired
	private KafkaTemplate<String, Product> kafkaTemplate;
	String kafkaTopic = "myfirst-topic";
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	/*@GetMapping(value = "/producer")
	public String producer(@RequestParam("message") String message) {
		service.send(message);

		return "Message sent to the Kafka Topic myfirst_topic Successfully";
	}*/
	@GetMapping(value = "/publish/{prodName}")
	public String post(@PathVariable("prodName") String prodName) {
		/*service.send(prodName);*/
		kafkaTemplate.send(kafkaTopic, new Product(01,"Book",250));
		return "Published Successfully";
	}
	@RequestMapping("/welcometoorder")
	public String welcome() {
		System.out.println("welcome called");
		logger.info("message"+service.retrieveMessage());
		return service.retrieveMessage();
	}
	@RequestMapping(value="/Order")
	public String getOrder(){
		
		String response = proxy.getprocess();
		logger.info("{}",response);
		return "Order page  calls Process microservices ==>response ="+response;
	}
}
