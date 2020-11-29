package com.sbm.vehicle.modules.vehicle.service;

import com.sbm.vehicle.common.consts.AppConstants;
import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.common.utils.MapperHelper;
import com.sbm.vehicle.modules.lookup.model.*;
import com.sbm.vehicle.modules.lookup.service.*;
import com.sbm.vehicle.modules.vehicle.dto.VehicleDto;
import com.sbm.vehicle.modules.vehicle.model.Vehicle;
import com.sbm.vehicle.modules.vehicle.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements com.sbm.vehicle.modules.vehicle.service.VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private MapperHelper mapperHelper;

    private final String Vehicle_NOT_FOUND = "Vehicle_Not_Found";

    @Autowired
    private CountryMakeService countryMakeService;

    @Autowired
    private NewVehicleBodyTypeService newVehicleBodyTypeService;

    @Autowired
    private VehicleBodyTypeService vehicleBodyTypeService;

    @Autowired
    private VehicleCategoryService vehicleCategoryService;

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @Override
    public VehicleDto getVehicleById(Long id) throws GenericExceptionMapper{
        Optional<Vehicle> vehicle = vehicleRepo.findById(id);
        if(vehicle.isPresent())
            return mapperHelper.transform(vehicle.get(), VehicleDto.class);
        else
            throw new GenericExceptionMapper(Vehicle_NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        return mapperHelper.transform(vehicleRepo.findAll(), VehicleDto.class);
    }

    @Override
    public VehicleDto saveVehicle(VehicleDto vehicleDto) throws GenericExceptionMapper{
        try{
            Vehicle vehicle = mapperHelper.transform(vehicleDto, Vehicle.class);
            populateVehicleLookup(vehicleDto, vehicle);
            return mapperHelper.transform(vehicleRepo.save(vehicle), VehicleDto.class);
        } catch(Exception ex){
            throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
        }

    }

    private void populateVehicleLookup(VehicleDto vehicleDto, Vehicle vehicle) throws GenericExceptionMapper{

        try {
            if(vehicleDto.getCountryMake() != null) {
                Lookup lkp = countryMakeService.getByName(vehicleDto.getCountryMake());
                vehicle.setCountryMake((CountryMake) lkp);
            }

            if(vehicleDto.getNewVehicleBodyType() != null) {
                Lookup lkp = newVehicleBodyTypeService.getByName(vehicleDto.getNewVehicleBodyType());
                vehicle.setNewVehicleBodyType((NewVehicleBodyType) lkp);
            }

            if(vehicleDto.getVehicleBodyType() != null) {
                Lookup lkp = vehicleBodyTypeService.getByName(vehicleDto.getVehicleBodyType());
                vehicle.setVehicleBodyType((VehicleBodyType) lkp);
            }

            if(vehicleDto.getVehicleCategory() != null) {
                Lookup lkp = vehicleCategoryService.getByName(vehicleDto.getVehicleCategory());
                vehicle.setVehicleCategory((VehicleCategory) lkp);
            }

            if(vehicleDto.getVehicleType() != null) {
                Lookup lkp = vehicleTypeService.getByName(vehicleDto.getVehicleType());
                vehicle.setVehicleType((VehicleType) lkp);
            }
        } catch (Exception ex) {
            throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
        }

    }

    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto) throws GenericExceptionMapper{
        Optional<Vehicle> vehicle = vehicleRepo.findById(vehicleDto.getId());

        if(vehicle.isPresent()){
            try {
                mapperHelper.partialMap(vehicleDto, vehicle.get());
                return mapperHelper.transform(vehicleRepo.save(vehicle.get()), VehicleDto.class);
            } catch (Exception ex){
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        } else
            throw new GenericExceptionMapper(Vehicle_NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);



    }

    @Override
    public void deleteVehicle(Long id) throws GenericExceptionMapper{
        Optional<Vehicle> vehicle = vehicleRepo.findById(id);
        if(vehicle.isPresent()){
            try {
                vehicleRepo.delete(vehicle.get());
            } catch (Exception ex) {
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        }
        else
            throw new GenericExceptionMapper(Vehicle_NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public List<VehicleDto> getVehiclesByFields(VehicleDto vehicleDto) throws GenericExceptionMapper {
        vehicleDto.setCountryMake(null);
        List<Vehicle> vehicles = vehicleRepo.getVehiclesByFields(vehicleDto);
        List<VehicleDto> vehiclesDto = mapperHelper.transform(vehicles, VehicleDto.class);
        return vehiclesDto;
    }
}
