package com.va.week10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Assign4EurekaService2Application {

	public static void main(String[] args) {
		SpringApplication.run(Assign4EurekaService2Application.class, args);
		System.out.println("Testing the Client");
	}

}
