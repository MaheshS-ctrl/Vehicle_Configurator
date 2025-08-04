package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
<<<<<<< HEAD
=======
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
>>>>>>> Vehicle_Conf_Controller

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
@EntityScan(basePackages = "com.example.entity")
@EnableJpaRepositories(basePackages = "com.example.repository")
public class ProjectApplication {

	public static void main(String[] args) {
<<<<<<< HEAD
=======
		String rawPass = "Ezio";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashedPassword = encoder.encode(rawPass);
		System.out.println("Hashed Password: " + hashedPassword);
>>>>>>> Vehicle_Conf_Controller
		SpringApplication.run(ProjectApplication.class, args);
	}

}
