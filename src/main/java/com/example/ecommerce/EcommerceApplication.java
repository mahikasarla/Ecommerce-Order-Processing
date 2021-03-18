package com.example.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author MahenderKasarla
 *
 */
@SpringBootApplication
public class EcommerceApplication {

	/**
	 * starts the application
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
		System.out.println("application started");
	}
}
