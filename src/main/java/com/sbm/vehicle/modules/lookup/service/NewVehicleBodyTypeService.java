package com.sbm.vehicle.modules.lookup.service;

import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.lookup.dto.NewVehicleBodyTypeDto;

import java.util.List;

public interface NewVehicleBodyTypeService {

    void delete(Long id)  throws GenericExceptionMapper;


    NewVehicleBodyTypeDto find(Long id)  throws GenericExceptionMapper;


    List<NewVehicleBodyTypeDto> findAll();

    void save(NewVehicleBodyTypeDto newVehicleBodyTypeDto)  throws GenericExceptionMapper;

    NewVehicleBodyTypeDto update(NewVehicleBodyTypeDto newVehicleBodyTypeDto)  throws GenericExceptionMapper;
}
