package com.sbm.vehicle.modules.lookup.service;

import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.lookup.model.Lookup;
import com.sbm.vehicle.modules.lookup.repository.LookupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LookupServiceImpl implements LookupService {

    @Autowired
    private LookupRepo lookupRepo;

    @Override
    public Lookup getByName(String name) throws GenericExceptionMapper {
        return lookupRepo.getByName(name);
    }
}
