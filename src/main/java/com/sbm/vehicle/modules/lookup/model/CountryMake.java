package com.sbm.vehicle.modules.lookup.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CountryMake")
public class CountryMake extends Lookup {
}
