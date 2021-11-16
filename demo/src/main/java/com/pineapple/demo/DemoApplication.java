package com.pineapple.demo;

import com.pineapple.demo.models.entity.Product;
import com.pineapple.demo.models.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository;
	@Override
	public void run(String... args) throws Exception {
		this.productRepository.save(new Product("Pinol", "Limpiador de Pisos", 30, 100.0, "pinol.png"));
		this.productRepository.save(new Product("Saba", "Toallas Sanitarias", 20, 80.0, "cosa.jpg"));
		this.productRepository.save(new Product("Maruchan", "Sopa instantánea", 100, 20.0, "maruchan.jpg"));
	}
}
