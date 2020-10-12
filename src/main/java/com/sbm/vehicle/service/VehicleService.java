package com.sbm.vehicle.service;

import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.dto.VehicleDto;

import java.util.List;

public interface VehicleService {

    VehicleDto getVehicleById(Long id) throws GenericExceptionMapper;

    List<VehicleDto> getAllVehicles() ;

    VehicleDto saveVehicle(VehicleDto vehicleDto) throws GenericExceptionMapper;

    VehicleDto updateVehicle(VehicleDto vehicleDto) throws GenericExceptionMapper;

    void deleteVehicle(Long id) throws GenericExceptionMapper;
}
