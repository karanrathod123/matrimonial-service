package com.hcl.matrimonial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class MatrimonialServiceApplication {

	public static void main(String[] args) {
		log.info("Starting Matrimonial Service...");
		SpringApplication.run(MatrimonialServiceApplication.class, args);
		log.info("Started Matrimonial Service...");
	}

}
