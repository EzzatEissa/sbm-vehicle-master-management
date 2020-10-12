package com.sbm.vehicle.model;

import com.sbm.vehicle.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Data
public class Vehicle extends BaseEntity {

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
