package com.sbm.vehicle.modules.vehicle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.sbm.vehicle.modules.lookup.model.Lookup;

import lombok.Data;

@Entity
@Data
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VEHICLE_SEQ")
	@SequenceGenerator(sequenceName = "VEHICLE_SEQ", allocationSize = 1, name = "VEHICLE_SEQ")
	private Long id;

	private String vehicleMaker;

	private String vehicleModel;

	private String language;

	private Integer vehicleTypeCode;

	@ManyToOne
	private Lookup countryMake;

	@ManyToOne
	private Lookup newVehicleBodyType;

	@ManyToOne
	private Lookup vehicleBodyType;

	@ManyToOne
	private Lookup vehicleType;

	@ManyToOne
	private Lookup vehicleCategory;

	private Boolean category50per50;

	private Boolean usedCategory;

	private Integer cdaInput;

	private Boolean active;

	private Integer sijilVehicleCode;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		Vehicle other = (Vehicle) obj;
		if (getId() == null || other.getId() == null)
			return false;

		return getId().equals(other.getId());
	}
}
