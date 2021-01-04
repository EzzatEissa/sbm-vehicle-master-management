package com.sbm.vehicle.modules.lookup.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sbm.vehicle.common.dto.BaseDto;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LookupDto extends BaseDto {

    private Integer version;

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }

	@JsonProperty(required = true)
	@JsonPropertyDescription("name should have value from 1 to 100")
	@Size(min = 1, max = 100, message = "name should have value from 1 to 100")
    @NotBlank
    private String name;

	@JsonProperty(required = false)
	@JsonPropertyDescription("description for lookup")
    private String description;
    
	@JsonProperty(required = true)
	@JsonPropertyDescription("code should have value from 1 to 100")
	@Size(min = 1, max = 100, message = "code should have value from 1 to 100")
    @NotBlank
    private String code;

	public String getName() {
        return this.name;
    }

	public void setName(String name) {
        this.name = name;
    }

	public String getDescription() {
        return this.description;
    }

	public void setDescription(String description) {
        this.description = description;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
