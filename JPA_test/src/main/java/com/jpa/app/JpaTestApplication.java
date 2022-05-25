package com.jpa.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages= {"com.jpa.app"})
@SpringBootApplication
public class JpaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaTestApplication.class, args);
	}

}
