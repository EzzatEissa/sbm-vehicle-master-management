package com.sbm.vehicle.modules.vehicle.dto;

import com.sbm.vehicle.common.dto.BaseDto;
import com.sbm.vehicle.modules.lookup.dto.*;
import lombok.Data;

@Data
public class VehicleDto extends BaseDto{

    private String vehicleMaker;

    private String vehicleModel;

    private Integer vehicleTypeCode;

    private String language;

    private String countryMake;

    private String newVehicleBodyType;

    private String vehicleBodyType;

    private String vehicleType;

    private String vehicleCategory;

    private Boolean category50per50;

    private Boolean usedCategory;

    private Integer cdaInput;

    private Boolean active;

    private Integer sijilVehicleCode;
}
