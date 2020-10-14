package com.sbm.vehicle.modules.lookup.controller;

import com.sbm.vehicle.common.consts.AppConstants;
import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.lookup.dto.VehicleCategoryDto;
import com.sbm.vehicle.modules.lookup.service.VehicleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@Path("/vehicleCategory")
public class VehicleCategoryController {

    @Autowired
    private VehicleCategoryService vehicleCategoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAll() {
        return Response.status(200).entity(vehicleCategoryService.findAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(VehicleCategoryDto vehicleCategoryDto) throws GenericExceptionMapper {
        vehicleCategoryService.save(vehicleCategoryDto);
        return Response.status(201).entity(AppConstants.HTTP_STATUS_CREATED).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getById(@PathParam("id") Long id) throws GenericExceptionMapper{
        return Response.status(200).entity(vehicleCategoryService.find(id)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid VehicleCategoryDto vehicleCategoryDto) throws GenericExceptionMapper{
        vehicleCategoryDto.setId(id);
        vehicleCategoryService.update(vehicleCategoryDto);
        return Response.status(200).entity(AppConstants.HTTP_STATUS_UPDATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws GenericExceptionMapper {
        vehicleCategoryService.delete(id);
        return Response.status(200).entity(AppConstants.HTTP_STATUS_DELETED).build();
    }
}
