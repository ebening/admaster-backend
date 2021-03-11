package com.adinfi.admaster.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "STRUCTURE_DATA_DETAIL")
public class StructureDataDetail extends BaseModel{

	@Id
	@Column(name = "STRUCTURE_DATA_DETAIL_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long structureDataDetailId;
	
	@Column(name = "STRUCTURE_ID")
	@NotNull
	private Long structureId;
	
	@Column(name = "PROPERTY", length = 50)
	@NotNull
	@Size(min = 2, max = 50)
	private String property;
	
	@Column(name = "VALUE", length = 50)
	@Size(min = 2, max = 50)
	private String value;

	public Long getStructureDataDetailId() {
		return structureDataDetailId;
	}

	public void setStructureDataDetailId(Long structureDataDetailId) {
		this.structureDataDetailId = structureDataDetailId;
	}

	public Long getStructureId() {
		return structureId;
	}

	public void setStructureId(Long structureId) {
		this.structureId = structureId;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
