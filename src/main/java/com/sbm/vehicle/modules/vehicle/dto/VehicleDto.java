package com.sbm.vehicle.modules.vehicle.dto;

import com.sbm.vehicle.common.dto.BaseDto;
import com.sbm.vehicle.modules.lookup.dto.*;
import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class VehicleDto extends BaseDto{

    @Size(min = 1, max = 30)
    @NotBlank
    private String vehicleMaker;

    @Size(min = 1, max = 30)
    private String vehicleModel;

    private Integer vehicleTypeCode;

    @Size(min = 1, max = 15)
    @NotBlank
    private String language;

    @Size(max = 100)
    private String countryMake;

    @Size(max = 100)
    private String newVehicleBodyType;

    @Size(min = 1, max = 50)
    @NotBlank
    private String vehicleBodyType;

    @Size(max = 100)
    private String vehicleType;

    @Size(max = 100)
    private String vehicleCategory;

    @Size(min = 1, max = 30)
    @NotBlank
    private Boolean category50per50;

    private Boolean usedCategory;

    @Digits(integer = 22, fraction = 7)
    private Integer cdaInput;

    @NotNull
    private Boolean active;

    @Size(min = 1, max = 100)
    private Integer sijilVehicleCode;
}
