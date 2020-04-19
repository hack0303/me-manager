package com.creating.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Bootstart {

	public static void main(String[] args) {
		SpringApplication.run(Bootstart.class, args);
	}

}
