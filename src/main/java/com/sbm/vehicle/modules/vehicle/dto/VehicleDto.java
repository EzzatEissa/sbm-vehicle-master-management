package com.sbm.vehicle.modules.vehicle.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sbm.vehicle.common.dto.BaseDto;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonClassDescription("Vehicle Data transfer object")
public class VehicleDto extends BaseDto{

	@JsonProperty(required = true)
	@JsonPropertyDescription("vehicleMaker should have value from 1 to 30")
    @Size(min = 1, max = 30, message = "vehicleMaker should have value from 1 to 30")
    @NotBlank
    private String vehicleMaker;

	@JsonProperty(required = false)
	@JsonPropertyDescription("vehicleModel should have value from 1 to 30")
    @Size(min = 1, max = 30, message = "vehicleModel should have value from 1 to 30")
    private String vehicleModel;

	@JsonProperty(required = false)
	@JsonPropertyDescription("vehicleTypeCode should have Vehicle Type Code")
    private Integer vehicleTypeCode;

	@JsonProperty(required = true)
	@JsonPropertyDescription("language should have value from 1 to 25")
    @Size(min = 1, max = 25, message = "language should have value from 1 to 25")
    @NotBlank
    private String language;

	@JsonProperty(required = false)
	@JsonPropertyDescription("countryMake should have null or value from 1 to 100")
    @Size(min = 1, max = 100, message = "countryMake should have null or value from 1 to 100")
    private String countryMake;

	@JsonProperty(required = false)
	@JsonPropertyDescription("newVehicleBodyType should have null or value from 1 to 100")
    @Size(min = 1, max = 100, message = "newVehicleBodyType should have null or value from 1 to 100")
    private String newVehicleBodyType;

	@JsonProperty(required = true)
	@JsonPropertyDescription("vehicleBodyType should have value from 1 to 50")
    @Size(min = 1, max = 50, message = "vehicleBodyType should have value from 1 to 50")
    @NotBlank
    private String vehicleBodyType;

	@JsonProperty(required = false)
	@JsonPropertyDescription("vehicleType should have have null or value from 1 to 100")
    @Size(min = 1, max = 100, message = "vehicleType should have have null or value from 1 to 100")
    private String vehicleType;

	@JsonProperty(required = false)
	@JsonPropertyDescription("vehicleCategory should have null or value from 1 to 100")
    @Size(min = 1, max = 100, message = "vehicleCategory should have null or value from 1 to 100")
    private String vehicleCategory;

	@JsonProperty(required = true)
	@JsonPropertyDescription("category50per50 should have value")
    @NotNull(message = "category50per50 should have value")
    private Boolean category50per50;

	@JsonProperty(required = false)
	@JsonPropertyDescription("usedCategory for used category")
    private Boolean usedCategory;

	@JsonProperty(required = false)
	@JsonPropertyDescription("cdaInput for CDA Input")
    private Integer cdaInput;

	@JsonProperty(required = true)
	@JsonPropertyDescription("active for active vehicle")
    @NotNull
    private Boolean active;

	@JsonProperty(required = false)
	@JsonPropertyDescription("sijilVehicleCode for sijil Vehicle Code")
    private Integer sijilVehicleCode;
}
