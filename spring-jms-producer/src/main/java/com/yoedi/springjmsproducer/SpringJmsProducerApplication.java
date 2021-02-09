package com.yoedi.springjmsproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
public class SpringJmsProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJmsProducerApplication.class, args);
	}

}
