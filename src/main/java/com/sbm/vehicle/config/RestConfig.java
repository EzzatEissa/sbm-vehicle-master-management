package com.sbm.vehicle.config;

import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.lookup.controller.*;
import com.sbm.vehicle.modules.vehicle.controller.VehicleController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class RestConfig extends ResourceConfig {

	public RestConfig() {

		register(VehicleController.class);
		register(CountryMakeController.class);
		register(NewVehicleBodyTypeController.class);
		register(VehicleBodyTypeController.class);
		register(VehicleCategoryController.class);
		register(VehicleTypeController.class);
		register(GenericExceptionMapper.class);
	}
}