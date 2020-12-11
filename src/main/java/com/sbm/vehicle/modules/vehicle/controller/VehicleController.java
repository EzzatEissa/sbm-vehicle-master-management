package com.sbm.vehicle.modules.vehicle.controller;

import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.vehicle.dto.ResultDto;
import com.sbm.vehicle.modules.vehicle.dto.VehicleDto;
import com.sbm.vehicle.modules.vehicle.service.VehicleService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api("Vehicles")
@Component
@Path("/vehicle")
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
public class VehicleController {


    @Autowired
    private VehicleService vehicleService;

    @ApiOperation("Get All Vehicles")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiResponses({ @ApiResponse(code = 200, message = "Get All Vehicles", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = List.class) })
    public Response getAllVehicles() {
        return Response.status(200).entity(vehicleService.getAllVehicles()).build();
    }

    @ApiOperation("Create Vehicle details")
    @POST
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiResponses({ @ApiResponse(code = 200, message = "Vehicle Created Successfully", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = ResultDto.class) })
    public Response createVehicle(@Valid VehicleDto vehicleDto) throws GenericExceptionMapper{
        vehicleService.saveVehicle(vehicleDto);
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("201");
        resultDto.setMsg("Vehicle is created successfully");
        resultDto.setType("success");
        return Response.status(201).entity(resultDto).build();
    }

    @ApiOperation("Get Vehicle By Id")
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiResponses({ @ApiResponse(code = 200, message = "Get Vehicle Info By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = VehicleDto.class) })
    public Response getVehicleById(@PathParam("id") Long id) throws GenericExceptionMapper{
        return Response.status(200).entity(vehicleService.getVehicleById(id)).build();
    }

    @ApiOperation("Update Vehicle By Id")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/{id}")
    @ApiResponses({ @ApiResponse(code = 200, message = "Update Vehicle Info By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = ResultDto.class) })
    public Response updateVehicle(@PathParam("id") Long id, VehicleDto vehicleDto) throws GenericExceptionMapper{
        vehicleDto.setId(id);
        vehicleService.updateVehicle(vehicleDto);
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Vehicle is updated successfully");
        resultDto.setType("success");
        return Response.status(200).entity(resultDto).build();
    }

    @ApiOperation("Delete Vehicle By Id")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/{id}")
    @ApiResponses({ @ApiResponse(code = 204, message = "Delete Vehicle By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = ResultDto.class) }) })
    public Response deleteVehicle(@PathParam("id") Long id) throws GenericExceptionMapper {
        vehicleService.deleteVehicle(id);
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Vehicle is deleted successfully");
        resultDto.setType("success");
        return Response.status(200).entity(resultDto).build();
    }

    @ApiOperation("Search For Vehicles By Any Fields")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
    @ApiResponses({ @ApiResponse(code = 200, message = "Search For Vehicles By Any Fields", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = List.class) })
    public Response getVehiclesByFields(@QueryParam("vehicleMaker") String vehicleMaker,
                                        @QueryParam("vehicleModel") String vehicleModel,
                                        @QueryParam("countryMake") String countryMake,
                                        @QueryParam("newVehicleBodyType") String newVehicleBodyType,
                                        @QueryParam("vehicleBodyType") String vehicleBodyType,
                                        @QueryParam("vehicleType") String vehicleType,
                                        @QueryParam("vehicleCategory") String vehicleCategory,
                                        @QueryParam("category50per50") Boolean category50per50,
                                        @QueryParam("usedCategory") Boolean usedCategory,
                                        @QueryParam("cdaInput") Integer cdaInput,
                                        @QueryParam("sijilVehicleCode") Integer sijilVehicleCode
                                        ) throws GenericExceptionMapper {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setVehicleMaker(vehicleMaker);
        vehicleDto.setVehicleModel(vehicleModel);
        vehicleDto.setCountryMake(countryMake);
        vehicleDto.setNewVehicleBodyType(newVehicleBodyType);
        vehicleDto.setVehicleBodyType(vehicleBodyType);
        vehicleDto.setVehicleType(vehicleType);
        vehicleDto.setVehicleCategory(vehicleCategory);
        vehicleDto.setUsedCategory(usedCategory);
        vehicleDto.setCategory50per50(category50per50);
        vehicleDto.setCdaInput(cdaInput);
        vehicleDto.setSijilVehicleCode(sijilVehicleCode);

        List<VehicleDto> vehicleDtos = vehicleService.getVehiclesByFields(vehicleDto);
        return Response.status(200).entity(vehicleDtos).build();
    }

}
