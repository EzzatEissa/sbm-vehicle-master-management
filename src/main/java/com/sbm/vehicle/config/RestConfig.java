package com.sbm.vehicle.config;

import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.controller.VehicleController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class RestConfig extends ResourceConfig {

	public RestConfig() {

		register(VehicleController.class);
		register(GenericExceptionMapper.class);
	}
}