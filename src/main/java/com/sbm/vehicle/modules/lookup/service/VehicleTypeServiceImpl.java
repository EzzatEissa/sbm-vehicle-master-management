package com.sbm.vehicle.modules.lookup.service;

import com.sbm.vehicle.common.consts.AppConstants;
import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.common.utils.MapperHelper;
import com.sbm.vehicle.modules.lookup.dto.VehicleTypeDto;
import com.sbm.vehicle.modules.lookup.model.VehicleCategory;
import com.sbm.vehicle.modules.lookup.model.VehicleType;
import com.sbm.vehicle.modules.lookup.model.VehicleType;
import com.sbm.vehicle.modules.lookup.repository.VehicleTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService{

    @Autowired
    VehicleTypeRepo vehicleTypeRepo;

    @Autowired
    private MapperHelper mapperHelper;

    private final String NOT_FOUND = "Not_Found";

    @Override
    public void delete(Long id)  throws GenericExceptionMapper {
        Optional<VehicleType> vehicleType = vehicleTypeRepo.findById(id);
        if(vehicleType.isPresent()){
            try {
                vehicleTypeRepo.delete(vehicleType.get());
            } catch (Exception ex) {
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        }
        else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public VehicleTypeDto find(Long id)  throws GenericExceptionMapper{
        Optional<VehicleType> vehicleType = vehicleTypeRepo.findById(id);
        if(vehicleType.isPresent())
            return mapperHelper.transform(vehicleType.get(), VehicleTypeDto.class);
        else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public List<VehicleTypeDto> findAll() {
        return mapperHelper.transform(vehicleTypeRepo.findAll(), VehicleTypeDto.class);
    }

    @Override
    public void save(VehicleTypeDto vehicleTypeDto) throws GenericExceptionMapper{
        try{
            mapperHelper.transform(vehicleTypeRepo.save(mapperHelper.transform(vehicleTypeDto, VehicleType.class)), VehicleTypeDto.class);
        } catch(Exception ex){
            throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
        }
    }

    @Override
    public VehicleTypeDto update(VehicleTypeDto vehicleTypeDto) throws GenericExceptionMapper {
        Optional<VehicleType> vehicleType = vehicleTypeRepo.findById(vehicleTypeDto.getId());

        if(vehicleType.isPresent()){
            try {
                mapperHelper.partialMap(vehicleTypeDto, vehicleType.get());
                return mapperHelper.transform(vehicleTypeRepo.save(vehicleType.get()), VehicleTypeDto.class);
            } catch (Exception ex){
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        } else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public VehicleType getByName(String name) throws GenericExceptionMapper {
        return vehicleTypeRepo.getByName(name);
    }
}
