package com.sbm.vehicle.modules.lookup.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VehicleBodyType")
public class VehicleBodyType extends Lookup {
}
