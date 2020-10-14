package com.sbm.vehicle.modules.lookup.service;

import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.lookup.dto.CountryMadeDto;

import java.util.List;

public interface CountryMadeService {

    void delete(Long id)  throws GenericExceptionMapper;


    CountryMadeDto find(Long id)  throws GenericExceptionMapper;


    List<CountryMadeDto> findAll();

    void save(CountryMadeDto countryMadeDto)  throws GenericExceptionMapper;

    CountryMadeDto update(CountryMadeDto countryMadeDto)  throws GenericExceptionMapper;
}
