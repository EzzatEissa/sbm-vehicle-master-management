package com.sbm.vehicle.modules.lookup.service;

import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.lookup.dto.CountryMakeDto;
import com.sbm.vehicle.modules.lookup.model.CountryMake;
import com.sbm.vehicle.modules.lookup.model.Lookup;

import java.util.List;

public interface CountryMakeService {

    void delete(Long id)  throws GenericExceptionMapper;


    CountryMakeDto find(Long id)  throws GenericExceptionMapper;


    List<CountryMakeDto> findAll();

    void save(CountryMakeDto countryMakeDto)  throws GenericExceptionMapper;

    CountryMakeDto update(CountryMakeDto countryMakeDto)  throws GenericExceptionMapper;

    CountryMake getByName(String name)   throws GenericExceptionMapper;
}
