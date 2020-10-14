package com.sbm.vehicle.modules.lookup.service;

import com.sbm.vehicle.common.consts.AppConstants;
import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.common.utils.MapperHelper;
import com.sbm.vehicle.modules.lookup.dto.NewVehicleBodyTypeDto;
import com.sbm.vehicle.modules.lookup.model.NewVehicleBodyType;
import com.sbm.vehicle.modules.lookup.model.NewVehicleBodyType;
import com.sbm.vehicle.modules.lookup.repository.NewVehicleBodyTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewVehicleBodyTypeServiceImpl implements NewVehicleBodyTypeService{

    @Autowired
    NewVehicleBodyTypeRepo newVehicleBodyTypeRepo;

    @Autowired
    private MapperHelper mapperHelper;

    private final String NOT_FOUND = "Not_Found";

    @Override
    public void delete(Long id)  throws GenericExceptionMapper{
        Optional<NewVehicleBodyType> newVehicleBodyType = newVehicleBodyTypeRepo.findById(id);
        if(newVehicleBodyType.isPresent()){
            try {
                newVehicleBodyTypeRepo.delete(newVehicleBodyType.get());
            } catch (Exception ex) {
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        }
        else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public NewVehicleBodyTypeDto find(Long id)  throws GenericExceptionMapper{
        Optional<NewVehicleBodyType> newVehicleBodyType = newVehicleBodyTypeRepo.findById(id);
        if(newVehicleBodyType.isPresent())
            return mapperHelper.transform(newVehicleBodyType.get(), NewVehicleBodyTypeDto.class);
        else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public List<NewVehicleBodyTypeDto> findAll() {
        return mapperHelper.transform(newVehicleBodyTypeRepo.findAll(), NewVehicleBodyTypeDto.class);
    }

    @Override
    public void save(NewVehicleBodyTypeDto newVehicleBodyTypeDto) throws GenericExceptionMapper{
        try{
            mapperHelper.transform(newVehicleBodyTypeRepo.save(mapperHelper.transform(newVehicleBodyTypeDto, NewVehicleBodyType.class)), NewVehicleBodyTypeDto.class);
        } catch(Exception ex){
            throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
        }
    }

    @Override
    public NewVehicleBodyTypeDto update(NewVehicleBodyTypeDto newVehicleBodyTypeDto) throws GenericExceptionMapper {
        Optional<NewVehicleBodyType> newVehicleBodyType = newVehicleBodyTypeRepo.findById(newVehicleBodyTypeDto.getId());

        if(newVehicleBodyType.isPresent()){
            try {
                mapperHelper.partialMap(newVehicleBodyTypeDto, newVehicleBodyType.get());
                return mapperHelper.transform(newVehicleBodyTypeRepo.save(newVehicleBodyType.get()), NewVehicleBodyTypeDto.class);
            } catch (Exception ex){
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        } else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }
}
