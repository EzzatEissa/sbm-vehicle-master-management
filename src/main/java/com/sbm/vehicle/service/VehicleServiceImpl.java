package com.sbm.vehicle.service;

import com.sbm.vehicle.common.consts.AppConstants;
import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.common.utils.MapperHelper;
import com.sbm.vehicle.dto.VehicleDto;
import com.sbm.vehicle.model.Vehicle;
import com.sbm.vehicle.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements com.sbm.vehicle.service.VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private MapperHelper mapperHelper;

    private final String EMPLOYER_NOT_FOUND = "Employer_Not_Found";

    @Override
    public VehicleDto getVehicleById(Long id) throws GenericExceptionMapper{
        Optional<Vehicle> approvedEmployer = vehicleRepo.findById(id);
        if(approvedEmployer.isPresent())
            return mapperHelper.transform(approvedEmployer, VehicleDto.class);
        else
            throw new GenericExceptionMapper(EMPLOYER_NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        return mapperHelper.transform(vehicleRepo.findAll(), VehicleDto.class);
    }

    @Override
    public VehicleDto saveVehicle(VehicleDto vehicleDto) throws GenericExceptionMapper{
        try{
            return mapperHelper.transform(vehicleRepo.save(mapperHelper.transform(vehicleDto, Vehicle.class)), VehicleDto.class);
        } catch(Exception ex){
            throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
        }

    }

    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto) throws GenericExceptionMapper{
        Optional<Vehicle> approvedEmployer= vehicleRepo.findById(vehicleDto.getId());

        if(approvedEmployer.isPresent()){
            try {
                mapperHelper.partialMap(vehicleDto, approvedEmployer.get());
                return mapperHelper.transform(vehicleRepo.save(approvedEmployer.get()), VehicleDto.class);
            } catch (Exception ex){
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        } else
            throw new GenericExceptionMapper(EMPLOYER_NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);



    }

    @Override
    public void deleteVehicle(Long id) throws GenericExceptionMapper{
        Optional<Vehicle> approvedEmployer= vehicleRepo.findById(id);
        if(approvedEmployer.isPresent()){
            try {
                vehicleRepo.delete(approvedEmployer.get());
            } catch (Exception ex) {
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        }
        else
            throw new GenericExceptionMapper(EMPLOYER_NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }
}
