package com.sbm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.sbm.vehicle")
@EnableJpaRepositories(basePackages = "com.sbm.vehicle")
public class SbmVehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbmVehicleApplication.class, args);
	}

}
