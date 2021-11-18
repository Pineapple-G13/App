package com.pineapple.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Start implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Start.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
