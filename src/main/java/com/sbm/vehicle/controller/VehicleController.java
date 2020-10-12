package com.sbm.vehicle.controller;

import com.sbm.vehicle.common.consts.AppConstants;
import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.dto.VehicleDto;
import com.sbm.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@Path("/vehicle")
public class VehicleController {


    @Autowired
    private VehicleService vehicleService;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAllVehicles() {
        return Response.status(200).entity(vehicleService.getAllVehicles()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.TEXT_PLAIN)
    public Response createVehicle(VehicleDto vehicleDto) throws GenericExceptionMapper{
        vehicleService.saveVehicle(vehicleDto);
        return Response.status(201).entity(AppConstants.HTTP_STATUS_CREATED).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getVehicleById(@PathParam("id") Long id) throws GenericExceptionMapper{
        return Response.status(200).entity(vehicleService.getVehicleById(id)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateVehicle(@PathParam("id") Long id, @Valid VehicleDto vehicleDto) throws GenericExceptionMapper{
        vehicleDto.setId(id);
        vehicleService.updateVehicle(vehicleDto);
        return Response.status(200).entity(AppConstants.HTTP_STATUS_UPDATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteVehicle(@PathParam("id") Long id) throws GenericExceptionMapper {
        vehicleService.deleteVehicle(id);
        return Response.status(200).entity(AppConstants.HTTP_STATUS_DELETED).build();
    }
}
