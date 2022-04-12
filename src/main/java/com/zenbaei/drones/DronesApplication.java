package com.zenbaei.drones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.zenbaei.drones.common.controller.ControllerExceptionHandler;

@SpringBootApplication
public class DronesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DronesApplication.class, args);
	}

}
