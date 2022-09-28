package com.softwareoffice.proyect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = {"com.softwareoffice.proyect.controller","com.softwareoffice.proyect.repository","com.softwareoffice.proyect.service"})
public class ProyectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectApplication.class, args);
	}

}
