package com.example.cb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CbApplication {

	public static void main(String[] args) {

		SpringApplication.run(CbApplication.class, args);
	}

}
