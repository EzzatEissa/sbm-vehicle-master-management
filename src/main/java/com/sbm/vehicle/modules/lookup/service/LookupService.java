package com.sbm.vehicle.modules.lookup.service;

import com.sbm.vehicle.common.exception.GenericExceptionMapper;
import com.sbm.vehicle.modules.lookup.model.Lookup;

public interface LookupService {

    Lookup getByName(String name)   throws GenericExceptionMapper;
}
