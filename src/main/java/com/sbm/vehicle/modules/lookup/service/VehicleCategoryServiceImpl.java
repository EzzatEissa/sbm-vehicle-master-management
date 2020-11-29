package com.sbm.vehicle.modules.lookup.service;

import com.sbm.vehicle.common.consts.AppConstants;
import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.common.utils.MapperHelper;
import com.sbm.vehicle.modules.lookup.dto.VehicleCategoryDto;
import com.sbm.vehicle.modules.lookup.model.VehicleBodyType;
import com.sbm.vehicle.modules.lookup.model.VehicleCategory;
import com.sbm.vehicle.modules.lookup.model.VehicleCategory;
import com.sbm.vehicle.modules.lookup.repository.VehicleCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleCategoryServiceImpl implements VehicleCategoryService{

    @Autowired
    VehicleCategoryRepo vehicleCategoryRepo;

    @Autowired
    private MapperHelper mapperHelper;

    private final String NOT_FOUND = "Not_Found";

    @Override
    public void delete(Long id)  throws GenericExceptionMapper {
        Optional<VehicleCategory> vehicleCategory = vehicleCategoryRepo.findById(id);
        if(vehicleCategory.isPresent()){
            try {
                vehicleCategoryRepo.delete(vehicleCategory.get());
            } catch (Exception ex) {
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        }
        else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public VehicleCategoryDto find(Long id)  throws GenericExceptionMapper{
        Optional<VehicleCategory> vehicleCategory = vehicleCategoryRepo.findById(id);
        if(vehicleCategory.isPresent())
            return mapperHelper.transform(vehicleCategory.get(), VehicleCategoryDto.class);
        else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public List<VehicleCategoryDto> findAll() {
        return mapperHelper.transform(vehicleCategoryRepo.findAll(), VehicleCategoryDto.class);
    }

    @Override
    public void save(VehicleCategoryDto vehicleCategoryDto) throws GenericExceptionMapper{
        try{
            mapperHelper.transform(vehicleCategoryRepo.save(mapperHelper.transform(vehicleCategoryDto, VehicleCategory.class)), VehicleCategoryDto.class);
        } catch(Exception ex){
            throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
        }
    }

    @Override
    public VehicleCategoryDto update(VehicleCategoryDto vehicleCategoryDto) throws GenericExceptionMapper {
        Optional<VehicleCategory> vehicleCategory = vehicleCategoryRepo.findById(vehicleCategoryDto.getId());

        if(vehicleCategory.isPresent()){
            try {
                mapperHelper.partialMap(vehicleCategoryDto, vehicleCategory.get());
                return mapperHelper.transform(vehicleCategoryRepo.save(vehicleCategory.get()), VehicleCategoryDto.class);
            } catch (Exception ex){
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        } else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public VehicleCategory getByName(String name) throws GenericExceptionMapper {
        return vehicleCategoryRepo.getByName(name);
    }
}
