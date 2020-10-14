package com.sbm.vehicle.modules.lookup.service;

import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.lookup.dto.VehicleBodyTypeDto;

import java.util.List;

public interface VehicleBodyTypeService {

    void delete(Long id)  throws GenericExceptionMapper;


    VehicleBodyTypeDto find(Long id)  throws GenericExceptionMapper;


    List<VehicleBodyTypeDto> findAll();

    void save(VehicleBodyTypeDto vehicleBodyTypeDto)  throws GenericExceptionMapper;

    VehicleBodyTypeDto update(VehicleBodyTypeDto vehicleBodyTypeDto)  throws GenericExceptionMapper;
}
