package com.example.mobilephonedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MobileApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return args -> {
			// Create a mobile phone
			Mobile myPhone = new Mobile("AndroidPhone", "1.0");

			// Display current phone details
			System.out.println("Current phone details - Model: " + myPhone.getModel() + ", Version: " + myPhone.getVersion());

			// Simulate a software update
			String newSoftwareVersion = "2.0";
			myPhone.updateSoftware(newSoftwareVersion);
		};
	}
}
