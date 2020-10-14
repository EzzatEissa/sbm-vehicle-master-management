package com.sbm.vehicle.modules.lookup.service;

import com.sbm.vehicle.common.consts.AppConstants;
import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.common.utils.MapperHelper;
import com.sbm.vehicle.modules.lookup.dto.CountryMadeDto;
import com.sbm.vehicle.modules.lookup.model.CountryMade;
import com.sbm.vehicle.modules.lookup.repository.CountryMadeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryMadeServiceImpl implements CountryMadeService{

    @Autowired
    CountryMadeRepo countryMadeRepo;

    @Autowired
    private MapperHelper mapperHelper;

    private final String NOT_FOUND = "Not_Found";

    @Override
    public void delete(Long id)  throws GenericExceptionMapper{
        Optional<CountryMade> countryMade = countryMadeRepo.findById(id);
        if(countryMade.isPresent()){
            try {
                countryMadeRepo.delete(countryMade.get());
            } catch (Exception ex) {
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        }
        else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public CountryMadeDto find(Long id)  throws GenericExceptionMapper{
        Optional<CountryMade> countryMade = countryMadeRepo.findById(id);
        if(countryMade.isPresent())
            return mapperHelper.transform(countryMade.get(), CountryMadeDto.class);
        else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }

    @Override
    public List<CountryMadeDto> findAll() {
        return mapperHelper.transform(countryMadeRepo.findAll(), CountryMadeDto.class);
    }

    @Override
    public void save(CountryMadeDto countryMadeDto) throws GenericExceptionMapper{
        try{
            mapperHelper.transform(countryMadeRepo.save(mapperHelper.transform(countryMadeDto, CountryMade.class)), CountryMadeDto.class);
        } catch(Exception ex){
            throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
        }
    }

    @Override
    public CountryMadeDto update(CountryMadeDto countryMadeDto) throws GenericExceptionMapper {
        Optional<CountryMade> countryMade = countryMadeRepo.findById(countryMadeDto.getId());

        if(countryMade.isPresent()){
            try {
                mapperHelper.partialMap(countryMadeDto, countryMade.get());
                return mapperHelper.transform(countryMadeRepo.save(countryMade.get()), CountryMadeDto.class);
            } catch (Exception ex){
                throw new GenericExceptionMapper(ex.getMessage(), AppConstants.HTTP_CODE_SEVER_ERROR);
            }
        } else
            throw new GenericExceptionMapper(NOT_FOUND, AppConstants.HTTP_CODE_NOT_FOUND);
    }
}
