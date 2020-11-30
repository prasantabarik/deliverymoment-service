package com.example.deliverymoment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DeliverymomentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliverymomentServiceApplication.class, args);
	}

}
