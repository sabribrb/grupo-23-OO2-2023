package com.unla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.unla")
public class Grupo23Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo23Application.class, args);
	}

}
