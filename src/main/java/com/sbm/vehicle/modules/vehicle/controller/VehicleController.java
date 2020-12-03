package com.sbm.vehicle.modules.vehicle.controller;

import com.sbm.vehicle.common.consts.AppConstants;
import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.vehicle.dto.ResultDto;
import com.sbm.vehicle.modules.vehicle.dto.VehicleDto;
import com.sbm.vehicle.modules.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response createVehicle(VehicleDto vehicleDto) throws GenericExceptionMapper{
        vehicleService.saveVehicle(vehicleDto);
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("201");
        resultDto.setMsg("Vehicle is created successfully");
        resultDto.setType("success");
        return Response.status(201).entity(resultDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getVehicleById(@PathParam("id") Long id) throws GenericExceptionMapper{
        return Response.status(200).entity(vehicleService.getVehicleById(id)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/{id}")
    public Response updateVehicle(@PathParam("id") Long id, @Valid VehicleDto vehicleDto) throws GenericExceptionMapper{
        vehicleDto.setId(id);
        vehicleService.updateVehicle(vehicleDto);
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Vehicle is updated successfully");
        resultDto.setType("success");
        return Response.status(200).entity(resultDto).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/{id}")
    public Response deleteVehicle(@PathParam("id") Long id) throws GenericExceptionMapper {
        vehicleService.deleteVehicle(id);
        ResultDto resultDto = new ResultDto();
        resultDto.setCode("200");
        resultDto.setMsg("Vehicle is deleted successfully");
        resultDto.setType("success");
        return Response.status(200).entity(resultDto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
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
