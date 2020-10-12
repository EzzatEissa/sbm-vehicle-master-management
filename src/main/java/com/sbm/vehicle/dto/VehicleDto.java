package com.sbm.vehicle.dto;

import com.sbm.vehicle.common.dto.BaseDto;
import lombok.Data;

@Data
public class VehicleDto extends BaseDto{

    private String vehicleMaker;

    private String vehicleModel;

    private String languageName;

    private String countryMade;

    private String newVehicleBodyType;

    private String vehicleBodyType;

    private String vehicleType;

    private String vehicleCategory;

    private String category50per50;

    private String usedCategory;

    private String CDAInput;

    private Boolean active;

    private String sijilVehicleCode;
}
