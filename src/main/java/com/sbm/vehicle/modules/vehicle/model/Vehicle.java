package com.sbm.vehicle.modules.vehicle.model;

import com.sbm.vehicle.common.model.BaseEntity;
import com.sbm.vehicle.modules.lookup.model.*;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Vehicle extends BaseEntity {

    private String vehicleMaker;

    private String vehicleModel;

    private String language;

    @ManyToOne
    private CountryMake countryMake;

    @ManyToOne
    private NewVehicleBodyType newVehicleBodyType;

    @ManyToOne
    private VehicleBodyType vehicleBodyType;

    @ManyToOne
    private VehicleType vehicleType;

    @ManyToOne
    private VehicleCategory vehicleCategory;

    private String category50per50;

    private String usedCategory;

    private String cdaInput;

    private Boolean active;

    private String sijilVehicleCode;
}
