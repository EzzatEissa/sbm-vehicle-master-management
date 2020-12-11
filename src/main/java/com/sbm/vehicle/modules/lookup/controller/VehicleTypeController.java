package com.sbm.vehicle.modules.lookup.controller;

import com.sbm.vehicle.common.consts.AppConstants;
import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.lookup.dto.VehicleTypeDto;
import com.sbm.vehicle.modules.lookup.service.VehicleTypeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api("Vehicle Type")
@Component
@Path("/vehicleType")
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
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @ApiOperation("Get All Vehicle Type")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiResponses({ @ApiResponse(code = 200, message = "Get All Vehicle Type", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = List.class) })
    public Response getAll() {
        return Response.status(200).entity(vehicleTypeService.findAll()).build();
    }

    @ApiOperation("Create Vehicle Type details")
    @POST
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.TEXT_PLAIN)
    @ApiResponses({ @ApiResponse(code = 200, message = "Vehicle Type Created Successfully", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = String.class) })
    public Response create(VehicleTypeDto vehicleTypeDto) throws GenericExceptionMapper {
        vehicleTypeService.save(vehicleTypeDto);
        return Response.status(201).entity(AppConstants.HTTP_STATUS_CREATED).build();
    }

    @ApiOperation("Get Vehicle Type By Id")
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiResponses({ @ApiResponse(code = 200, message = "Get Vehicle Type Info By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = VehicleTypeDto.class) })
    public Response getById(@PathParam("id") Long id) throws GenericExceptionMapper{
        return Response.status(200).entity(vehicleTypeService.find(id)).build();
    }

    @ApiOperation("Update Vehicle Type By Id")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @ApiResponses({ @ApiResponse(code = 200, message = "Update Vehicle Type Info By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = String.class) })
    public Response update(@PathParam("id") Long id, @Valid VehicleTypeDto vehicleTypeDto) throws GenericExceptionMapper{
        vehicleTypeDto.setId(id);
        vehicleTypeService.update(vehicleTypeDto);
        return Response.status(200).entity(AppConstants.HTTP_STATUS_UPDATED).build();
    }

    @ApiOperation("Delete Vehicle Type By Id")
    @DELETE
    @Path("/{id}")
    @ApiResponses({ @ApiResponse(code = 204, message = "Delete Vehicle Type By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }) })
    public Response delete(@PathParam("id") Long id) throws GenericExceptionMapper {
        vehicleTypeService.delete(id);
        return Response.status(200).entity(AppConstants.HTTP_STATUS_DELETED).build();
    }
}
