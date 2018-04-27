package com.hoi1102;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({ "com.hoi1102"})
public class SpringJdbcRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcRestApplication.class, args);
	}
}
