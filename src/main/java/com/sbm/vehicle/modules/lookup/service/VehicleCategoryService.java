package com.sbm.vehicle.modules.lookup.service;

import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.lookup.dto.VehicleCategoryDto;

import java.util.List;

public interface VehicleCategoryService {

    void delete(Long id)  throws GenericExceptionMapper;


    VehicleCategoryDto find(Long id)  throws GenericExceptionMapper;


    List<VehicleCategoryDto> findAll();

    void save(VehicleCategoryDto vehicleCategoryDto)  throws GenericExceptionMapper;

    VehicleCategoryDto update(VehicleCategoryDto vehicleCategoryDto)  throws GenericExceptionMapper;
}
