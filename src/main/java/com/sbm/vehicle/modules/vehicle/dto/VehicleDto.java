package com.sbm.vehicle.modules.vehicle.dto;

import com.sbm.vehicle.common.dto.BaseDto;
import com.sbm.vehicle.modules.lookup.dto.*;
import lombok.Data;

@Data
public class VehicleDto extends BaseDto{

    private String vehicleMaker;

    private String vehicleModel;

    private String language;

    private CountryMakeDto countryMake;

    private NewVehicleBodyTypeDto newVehicleBodyType;

    private VehicleBodyTypeDto vehicleBodyType;

    private VehicleTypeDto vehicleType;

    private VehicleCategoryDto vehicleCategory;

    private String category50per50;

    private String usedCategory;

    private String cdaInput;

    private Boolean active;

    private String sijilVehicleCode;
}
