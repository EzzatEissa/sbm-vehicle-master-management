package com.sbm.vehicle.modules.lookup.service;

import com.sbm.vehicle.common.consts.AppConstants;
import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.common.utils.MapperHelper;
import com.sbm.vehicle.modules.lookup.dto.VehicleBodyTypeDto;
import com.sbm.vehicle.modules.lookup.model.VehicleBodyType;
import com.sbm.vehicle.modules.lookup.model.VehicleBodyType;
import com.sbm.vehicle.modules.lookup.repository.VehicleBodyTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleBodyTypeServiceImpl implements VehicleBodyTypeService{

    @Autowired
    VehicleBodyTypeRepo vehicleBodyTypeRepo;

    @Autowired
    private MapperHelper mapperHelper;

    private final String NOT_FOUND = "Not_Found";

    @Override
    public void delete(Long id)  throws GenericExceptionMapper {
        Optional<VehicleBodyType> vehicleBodyType = vehicleBodyTypeRepo.findById(id);
        if(vehicleBodyType.isPresent()){
            try {
                vehicleBodyTypeRepo.delete(vehicleBodyType.get());
            } catch (Exception ex) {
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        }
        else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public VehicleBodyTypeDto find(Long id)  throws GenericExceptionMapper{
        Optional<VehicleBodyType> vehicleBodyType = vehicleBodyTypeRepo.findById(id);
        if(vehicleBodyType.isPresent())
            return mapperHelper.transform(vehicleBodyType.get(), VehicleBodyTypeDto.class);
        else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public List<VehicleBodyTypeDto> findAll() {
        return mapperHelper.transform(vehicleBodyTypeRepo.findAll(), VehicleBodyTypeDto.class);
    }

    @Override
    public void save(VehicleBodyTypeDto vehicleBodyTypeDto) throws GenericExceptionMapper{
        try{
            mapperHelper.transform(vehicleBodyTypeRepo.save(mapperHelper.transform(vehicleBodyTypeDto, VehicleBodyType.class)), VehicleBodyTypeDto.class);
        } catch(Exception ex){
            throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
        }
    }

    @Override
    public VehicleBodyTypeDto update(VehicleBodyTypeDto vehicleBodyTypeDto) throws GenericExceptionMapper {
        Optional<VehicleBodyType> vehicleBodyType = vehicleBodyTypeRepo.findById(vehicleBodyTypeDto.getId());

        if(vehicleBodyType.isPresent()){
            try {
                mapperHelper.partialMap(vehicleBodyTypeDto, vehicleBodyType.get());
                return mapperHelper.transform(vehicleBodyTypeRepo.save(vehicleBodyType.get()), VehicleBodyTypeDto.class);
            } catch (Exception ex){
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        } else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }
}
