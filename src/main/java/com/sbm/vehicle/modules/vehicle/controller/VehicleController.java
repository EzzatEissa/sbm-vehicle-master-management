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

    @ApiOperation(value = "Get All Vehicles", notes = "Get All Vehicles")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiResponses({ @ApiResponse(code = 200, message = "Get All Vehicles", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = ResultDto.class) })
    public Response getAllVehicles(
    		@ApiParam(value = "pagination page number", required = false) @DefaultValue("0") @QueryParam("page") int page, 
    		@ApiParam(value = "pagination size per page", required = false) @DefaultValue("10") @QueryParam("size") int size) {
    	
    	ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Done");
        resultDto.setType("success");
        resultDto.setValue(vehicleService.getAllVehicles(page, size));
        
        return Response.status(200).entity(resultDto).build();
    }

    @ApiOperation(value = "Create Vehicle details", notes = "Create Vehicle details")
    @POST
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiResponses({ @ApiResponse(code = 200, message = "Vehicle Created Successfully", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = ResultDto.class) })
    public Response createVehicle(@ApiParam(value = "vehicle object used to insert vehicle", required = true) @Valid VehicleDto vehicleDto) throws GenericExceptionMapper{
        vehicleService.saveVehicle(vehicleDto);
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("201");
        resultDto.setMsg("Vehicle is created successfully");
        resultDto.setType("success");
        return Response.status(201).entity(resultDto).build();
    }

    @ApiOperation(value = "Get Vehicle By Id", notes = "Get Vehicle By Id")
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @ApiResponses({ @ApiResponse(code = 200, message = "Get Vehicle Info By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = ResultDto.class) })
    public Response getVehicleById(@ApiParam(value = "id used to get vehicle info", required = true) @PathParam("id") Long id) throws GenericExceptionMapper{
    	
    	ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Done");
        resultDto.setType("success");
        resultDto.setValue(vehicleService.getVehicleById(id));
        
        return Response.status(200).entity(resultDto).build();
    }

    @ApiOperation(value = "Update Vehicle By Id", notes = "Update Vehicle By Id")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/{id}")
    @ApiResponses({ @ApiResponse(code = 200, message = "Update Vehicle Info By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = ResultDto.class) })
    public Response updateVehicle(@ApiParam(value = "id used for update", required = true) @PathParam("id") Long id, @ApiParam(value = "vehicle object used to update vehicle info", required = false) VehicleDto vehicleDto) throws GenericExceptionMapper{
        vehicleDto.setId(id);
        vehicleService.updateVehicle(vehicleDto);
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Vehicle is updated successfully");
        resultDto.setType("success");
        return Response.status(200).entity(resultDto).build();
    }

    @ApiOperation(value = "Delete Vehicle By Id", notes = "Delete Vehicle By Id")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/{id}")
    @ApiResponses({ @ApiResponse(code = 204, message = "Delete Vehicle By Id", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = ResultDto.class) }) })
    public Response deleteVehicle(@ApiParam(value = "id used for delete", required = true) @PathParam("id") Long id) throws GenericExceptionMapper {
        vehicleService.deleteVehicle(id);
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Vehicle is deleted successfully");
        resultDto.setType("success");
        return Response.status(200).entity(resultDto).build();
    }

    @ApiOperation(value = "Search For Vehicles By Any Fields", notes = "Search For Vehicles By Any Fields")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
    @ApiResponses({ @ApiResponse(code = 200, message = "Search For Vehicles By Any Fields", responseHeaders = {
            @ResponseHeader(name = "x-fapi-interaction-id", description = "An RFC4122 UID used as a correlation id.", response = String.class) }, response = ResultDto.class) })
    public Response getVehiclesByFields(@ApiParam(value = "vehicle_maker", required = false) @QueryParam("vehicle_maker") String vehicleMaker,
    		@ApiParam(value = "vehicle_model", required = false) @QueryParam("vehicle_model") String vehicleModel,
    		@ApiParam(value = "country_make", required = false) @QueryParam("country_make") String countryMake,
    		@ApiParam(value = "new_vehicle_body_type", required = false) @QueryParam("new_vehicle_body_type") String newVehicleBodyType,
    		@ApiParam(value = "vehicle_body_type", required = false) @QueryParam("vehicle_body_type") String vehicleBodyType,
    		@ApiParam(value = "vehicle_type", required = false) @QueryParam("vehicle_type") String vehicleType,
    		@ApiParam(value = "vehicle_category", required = false) @QueryParam("vehicle_category") String vehicleCategory,
    		@ApiParam(value = "category50per50", required = false) @QueryParam("category50per50") Boolean category50per50,
    		@ApiParam(value = "used_category", required = false) @QueryParam("used_category") Boolean usedCategory,
    		@ApiParam(value = "cda_input", required = false) @QueryParam("cda_input") Integer cdaInput,
    		@ApiParam(value = "sijil_vehicle_code", required = false) @QueryParam("sijil_vehicle_code") Integer sijilVehicleCode
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
        
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Done");
        resultDto.setType("success");
        resultDto.setValue(vehicleDtos);
        
        return Response.status(200).entity(resultDto).build();
    }

}
