package com.sbm.vehicle.modules.lookup.dto;

import com.sbm.vehicle.common.dto.BaseDto;

public class LookupDto extends BaseDto {

    private Integer version;

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }

    private String name;

    private String description;
    
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
