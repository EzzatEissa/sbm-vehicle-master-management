package com.sbm.vehicle.modules.lookup.controller;

import com.sbm.vehicle.common.consts.AppConstants;
import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.lookup.dto.CountryMakeDto;
import com.sbm.vehicle.modules.lookup.service.CountryMakeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api("CountryMake")
@Component
@Path("/countryMake")
@ApiResponses({
        @ApiResponse(code = 400, message = "Bad request", responseHeaders = { @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = GenericExceptionMapper.class),
        @ApiResponse(code = 401, message = "Unauthorized", responseHeaders = { @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }),
        @ApiResponse(code = 403, message = "Forbidden", responseHeaders = { @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = GenericExceptionMapper.class),
        @ApiResponse(code = 404, message = "Not found", responseHeaders = { @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }),
        @ApiResponse(code = 405, message = "Method Not Allowed", responseHeaders = { @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = GenericExceptionMapper.class),
        @ApiResponse(code = 406, message = "Not Acceptable", responseHeaders = { @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }),
        @ApiResponse(code = 415, message = "Unsupported Media Type", responseHeaders = { @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }),
        @ApiResponse(code = 429, message = "Too Many Requests", responseHeaders = { @ResponseHeader(name = "Retry-After", description = "Number in seconds to wait", response = Integer.class),
                @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }),
        @ApiResponse(code = 500, message = "Internal Server Error", responseHeaders = {
                @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = GenericExceptionMapper.class),
        @ApiResponse(code = 503, message = "Service Unavailable", responseHeaders = {
                @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = GenericExceptionMapper.class), })
public class CountryMakeController {

    @Autowired
    private CountryMakeService countryMakeService;

    @ApiOperation("Get All Country Make")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiResponses({ @ApiResponse(code = 200, message = "Get All Country Make", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = List.class) })
    public Response getAll() {
        return Response.status(200).entity(countryMakeService.findAll()).build();
    }

    @ApiOperation("Create Country Make details")
    @POST
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.TEXT_PLAIN)
    @ApiResponses({ @ApiResponse(code = 200, message = "Country Make Created Successfully", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = String.class) })
    public Response create(CountryMakeDto countryMakeDto) throws GenericExceptionMapper {
        countryMakeService.save(countryMakeDto);
        return Response.status(201).entity(AppConstants.HTTP_STATUS_CREATED).build();
    }

    @ApiOperation("Get Country Make By Id")
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiResponses({ @ApiResponse(code = 200, message = "Get Country Make Info By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = CountryMakeDto.class) })
    public Response getById(@PathParam("id") Long id) throws GenericExceptionMapper{
        return Response.status(200).entity(countryMakeService.find(id)).build();
    }

    @ApiOperation("Update Country Make By Id")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @ApiResponses({ @ApiResponse(code = 200, message = "Update Country Make Info By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = String.class) })
    public Response update(@PathParam("id") Long id, @Valid CountryMakeDto countryMakeDto) throws GenericExceptionMapper{
        countryMakeDto.setId(id);
        countryMakeService.update(countryMakeDto);
        return Response.status(200).entity(AppConstants.HTTP_STATUS_UPDATED).build();
    }

    @ApiOperation("Delete Country Make By Id")
    @DELETE
    @Path("/{id}")
    @ApiResponses({ @ApiResponse(code = 204, message = "Delete Country Make By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }) })
    public Response delete(@PathParam("id") Long id) throws GenericExceptionMapper {
        countryMakeService.delete(id);
        return Response.status(200).entity(AppConstants.HTTP_STATUS_DELETED).build();
    }
}
