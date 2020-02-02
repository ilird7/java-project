package com.example.phonesAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PhonesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhonesApiApplication.class, args);
	}

}
