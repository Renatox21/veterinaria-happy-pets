package com.happypets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = "com.happypets")
@EnableJpaRepositories(basePackages = "com.happypets")
@SpringBootApplication(scanBasePackages = {"com.happypets"})
public class VeterinariaHappyPetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinariaHappyPetsApplication.class, args);
		System.out.println("---INICIO LA APLICACION");
	}

}
