package com.sbm.vehicle.modules.lookup.controller;

import com.sbm.vehicle.common.consts.AppConstants;
import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.lookup.dto.VehicleTypeDto;
import com.sbm.vehicle.modules.lookup.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@Path("/vehicleType")
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAll() {
        return Response.status(200).entity(vehicleTypeService.findAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(VehicleTypeDto vehicleTypeDto) throws GenericExceptionMapper {
        vehicleTypeService.save(vehicleTypeDto);
        return Response.status(201).entity(AppConstants.HTTP_STATUS_CREATED).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getById(@PathParam("id") Long id) throws GenericExceptionMapper{
        return Response.status(200).entity(vehicleTypeService.find(id)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid VehicleTypeDto vehicleTypeDto) throws GenericExceptionMapper{
        vehicleTypeDto.setId(id);
        vehicleTypeService.update(vehicleTypeDto);
        return Response.status(200).entity(AppConstants.HTTP_STATUS_UPDATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws GenericExceptionMapper {
        vehicleTypeService.delete(id);
        return Response.status(200).entity(AppConstants.HTTP_STATUS_DELETED).build();
    }
}
