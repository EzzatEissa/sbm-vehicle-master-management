package com.sbm.vehicle.modules.vehicle.service;

import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.vehicle.dto.PageResultDto;
import com.sbm.vehicle.modules.vehicle.dto.VehicleDto;

import java.util.List;

public interface VehicleService {

    VehicleDto getVehicleById(Long id) throws GenericExceptionMapper;

    PageResultDto getAllVehicles(int page, int size) ;

    VehicleDto saveVehicle(VehicleDto vehicleDto) throws GenericExceptionMapper;

    VehicleDto updateVehicle(VehicleDto vehicleDto) throws GenericExceptionMapper;

    void deleteVehicle(Long id) throws GenericExceptionMapper;

    List<VehicleDto> getVehiclesByFields(VehicleDto vehicleDto) throws GenericExceptionMapper;
}
