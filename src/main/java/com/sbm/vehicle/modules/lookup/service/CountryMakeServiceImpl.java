package com.sbm.vehicle.modules.lookup.service;

import com.sbm.vehicle.common.consts.AppConstants;
import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.common.utils.MapperHelper;
import com.sbm.vehicle.modules.lookup.dto.CountryMakeDto;
import com.sbm.vehicle.modules.lookup.model.CountryMake;
import com.sbm.vehicle.modules.lookup.repository.CountryMakeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryMakeServiceImpl implements CountryMakeService{

    @Autowired
    CountryMakeRepo countryMakeRepo;

    @Autowired
    private MapperHelper mapperHelper;

    private final String NOT_FOUND = "Not_Found";

    @Override
    public void delete(Long id)  throws GenericExceptionMapper{
        Optional<CountryMake> countryMake = countryMakeRepo.findById(id);
        if(countryMake.isPresent()){
            try {
                countryMakeRepo.delete(countryMake.get());
            } catch (Exception ex) {
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        }
        else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public CountryMakeDto find(Long id)  throws GenericExceptionMapper{
        Optional<CountryMake> countryMake = countryMakeRepo.findById(id);
        if(countryMake.isPresent())
            return mapperHelper.transform(countryMake.get(), CountryMakeDto.class);
        else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public List<CountryMakeDto> findAll() {
        return mapperHelper.transform(countryMakeRepo.findAll(), CountryMakeDto.class);
    }

    @Override
    public void save(CountryMakeDto countryMakeDto) throws GenericExceptionMapper{
        try{
            mapperHelper.transform(countryMakeRepo.save(mapperHelper.transform(countryMakeDto, CountryMake.class)), CountryMakeDto.class);
        } catch(Exception ex){
            throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
        }
    }

    @Override
    public CountryMakeDto update(CountryMakeDto countryMakeDto) throws GenericExceptionMapper {
        Optional<CountryMake> countryMake = countryMakeRepo.findById(countryMakeDto.getId());

        if(countryMake.isPresent()){
            try {
                mapperHelper.partialMap(countryMakeDto, countryMake.get());
                return mapperHelper.transform(countryMakeRepo.save(countryMake.get()), CountryMakeDto.class);
            } catch (Exception ex){
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        } else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }
}
