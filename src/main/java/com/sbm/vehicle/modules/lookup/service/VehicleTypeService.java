package com.sbm.vehicle.modules.lookup.service;

import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.lookup.dto.VehicleTypeDto;

import java.util.List;

public interface VehicleTypeService {

    void delete(Long id)  throws GenericExceptionMapper;


    VehicleTypeDto find(Long id)  throws GenericExceptionMapper;


    List<VehicleTypeDto> findAll();

    void save(VehicleTypeDto vehicleTypeDto)  throws GenericExceptionMapper;

    VehicleTypeDto update(VehicleTypeDto vehicleTypeDto)  throws GenericExceptionMapper;
}
