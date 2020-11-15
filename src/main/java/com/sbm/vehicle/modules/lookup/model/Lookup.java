package com.sbm.vehicle.modules.lookup.model;

import com.sbm.vehicle.common.model.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Lookup extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

//	@Version
//    @Column(name = "version")
//    private Integer version;
//
//	public Integer getVersion() {
//        return this.version;
//    }
//
//	public void setVersion(Integer version) {
//        this.version = version;
//    }

    @NotNull
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

	public void setCode(String key) {
		this.code = key;
	}
}
