package com.sbm.vehicle.modules.lookup.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VehicleCategory")
public class VehicleCategory extends Lookup{
}
