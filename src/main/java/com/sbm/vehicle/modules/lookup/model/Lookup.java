package com.sbm.vehicle.modules.lookup.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Lookup {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOOKUP_SEQ")
    @SequenceGenerator(sequenceName = "LOOKUP_SEQ", allocationSize = 1, name = "LOOKUP_SEQ")
	private Long id;
	
    @NotNull
    private String name;

    private String nameAr;

    private String description;
    
    private String code;

    private Integer nameLic;

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

    public Integer getNameLic() {
        return nameLic;
    }

    public void setNameLic(Integer nameLic) {
        this.nameLic = nameLic;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        Lookup other = (Lookup)obj;
        if (getId() == null || other.getId() == null)
            return false;

        return getId().equals(other.getId());
    } 
    
}
