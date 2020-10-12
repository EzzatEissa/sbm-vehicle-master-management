package com.sbm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sbm.vehicle")
public class SbmVehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbmVehicleApplication.class, args);
	}

}
