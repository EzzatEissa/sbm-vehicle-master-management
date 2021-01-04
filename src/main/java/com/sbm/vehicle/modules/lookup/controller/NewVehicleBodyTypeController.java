package com.sbm.vehicle.modules.lookup.controller;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.lookup.dto.NewVehicleBodyTypeDto;
import com.sbm.vehicle.modules.lookup.service.NewVehicleBodyTypeService;
import com.sbm.vehicle.modules.vehicle.dto.ResultDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;


@Api("New Vehicle Body Type")
@Component
@Path("/new_vehicle_body_type")
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
public class NewVehicleBodyTypeController {

    @Autowired
    private NewVehicleBodyTypeService newVehicleBodyTypeService;

    @ApiOperation(value = "Get All New Vehicle Body Type", notes = "Get All New Vehicle Body Type")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiResponses({ @ApiResponse(code = 200, message = "Get All New Vehicle Body Type", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = ResultDto.class) })
    public Response getAll() {
    	ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Done");
        resultDto.setType("success");
        resultDto.setValue(newVehicleBodyTypeService.findAll());
        return Response.status(200).entity(resultDto).build();
    }

    @ApiOperation(value = "Create New Vehicle Body Type details", notes = "Create New Vehicle Body Type details")
    @POST
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiResponses({ @ApiResponse(code = 200, message = "New Vehicle Body Type Created Successfully", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = ResultDto.class) })
    public Response create(@ApiParam(value = "used to insert NewVehicleBodyType", required = true) @Valid NewVehicleBodyTypeDto newVehicleBodyTypeDto) throws GenericExceptionMapper {
        newVehicleBodyTypeService.save(newVehicleBodyTypeDto);
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("201");
        resultDto.setMsg("New Vehicle Body Type is created successfully");
        resultDto.setType("success");
        return Response.status(201).entity(resultDto).build();
    }

    @ApiOperation(value = "Get New Vehicle Body Type By Id", notes = "Get New Vehicle Body Type By Id")
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiResponses({ @ApiResponse(code = 200, message = "Get New Vehicle Body Type Info By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = ResultDto.class) })
    public Response getById(@ApiParam(value = "id used to get info", required = true)  @PathParam("id") Long id) throws GenericExceptionMapper{
    	ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Done");
        resultDto.setType("success");
        resultDto.setValue(newVehicleBodyTypeService.find(id));
        return Response.status(200).entity(resultDto).build();
    }

    @ApiOperation(value = "Update New Vehicle Body Type By Id", notes = "Update New Vehicle Body Type By Id")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/{id}")
    @ApiResponses({ @ApiResponse(code = 200, message = "Update New Vehicle Body Type Info By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = ResultDto.class) })
    public Response update(@ApiParam(value = "id used for update", required = true) @PathParam("id") Long id, @ApiParam(value = "payload used for update", required = true)@Valid NewVehicleBodyTypeDto newVehicleBodyTypeDto) throws GenericExceptionMapper{
        newVehicleBodyTypeDto.setId(id);
        newVehicleBodyTypeService.update(newVehicleBodyTypeDto);
        
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("New Vehicle Body Type is updated successfully");
        resultDto.setType("success");
        
        return Response.status(200).entity(resultDto).build();
    }

    @ApiOperation(value = "Delete New Vehicle Body Type By Id", notes = "Delete New Vehicle Body Type By Id")
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiResponses({ @ApiResponse(code = 204, message = "Delete New Vehicle Body Type By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = ResultDto.class) })
    public Response delete(@ApiParam(value = "id used to delete", required = true) @PathParam("id") Long id) throws GenericExceptionMapper {
        newVehicleBodyTypeService.delete(id);
        
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("New Vehicle Body Type is deleted successfully");
        resultDto.setType("success");
        
        return Response.status(200).entity(resultDto).build();
    }
}
