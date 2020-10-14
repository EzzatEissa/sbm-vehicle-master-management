package com.sbm.vehicle.modules.lookup.controller;

import com.sbm.vehicle.common.consts.AppConstants;
import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.lookup.dto.CountryMadeDto;
import com.sbm.vehicle.modules.lookup.service.CountryMadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@Path("/countryMade")
public class CountryMadeController {

    @Autowired
    private CountryMadeService countryMadeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getAll() {
        return Response.status(200).entity(countryMadeService.findAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(CountryMadeDto countryMadeDto) throws GenericExceptionMapper {
        countryMadeService.save(countryMadeDto);
        return Response.status(201).entity(AppConstants.HTTP_STATUS_CREATED).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getById(@PathParam("id") Long id) throws GenericExceptionMapper{
        return Response.status(200).entity(countryMadeService.find(id)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid CountryMadeDto countryMadeDto) throws GenericExceptionMapper{
        countryMadeDto.setId(id);
        countryMadeService.update(countryMadeDto);
        return Response.status(200).entity(AppConstants.HTTP_STATUS_UPDATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws GenericExceptionMapper {
        countryMadeService.delete(id);
        return Response.status(200).entity(AppConstants.HTTP_STATUS_DELETED).build();
    }
}
