package com.sbm.vehicle.modules.vehicle.model;

import com.sbm.vehicle.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Vehicle extends BaseEntity {

    private String vehicleMaker;

    private String vehicleModel;

    private String language;

    private String countryMade;

    private String newVehicleBodyType;

    private String vehicleBodyType;

    private String vehicleType;

    private String vehicleCategory;

    private String category50per50;

    private String usedCategory;

    private String cdaInput;

    private Boolean active;

    private String sijilVehicleCode;
}
