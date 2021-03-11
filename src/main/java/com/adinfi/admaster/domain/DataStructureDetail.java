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
@Table(name = "DATA_STRUCTURE_DETAIL")
public class DataStructureDetail extends BaseModel{

	@Id
	@Column(name = "DATA_STUCTURE_DETAIL_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long dataStructureDetailId;

	@Column(name = "PROPERTY", length = 50)
	@NotNull
	@Size(min = 2, max = 50)
	private String property;
	
	@Column(name = "TYPE", length = 50)
	@NotNull
	@Size(min = 2, max = 50)
	private String type;
	
	@Column(name = "REFERENCE_ID")
	private Long referenceId;

	public Long getDataStructureDetailId() {
		return dataStructureDetailId;
	}

	public void setDataStructureDetailId(Long dataStructureDetailId) {
		this.dataStructureDetailId = dataStructureDetailId;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}
	
}
