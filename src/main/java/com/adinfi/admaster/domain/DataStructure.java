package com.adinfi.admaster.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DATA_STRUCTURE")
public class DataStructure extends BaseModel{

	@Id
	@Column(name = "DATA_STRUCTURE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long dataStructureId;

	@Column(name = "DESCRIPTION")
	@NotNull
	@Size(min = 4, max = 50)
	private String description;
	
	@Column(name = "DESCRIPTOR", length = 50)
	@Size(min = 2, max = 50)
	private String descriptor;
	
	@OneToMany
	@JoinColumn(name="DATA_STRUCTURE_ID")
	@OrderBy
	private Set<DataStructureDetail> detail;

	public Long getDataStructureId() {
		return dataStructureId;
	}

	public void setDataStructureId(Long dataStructureId) {
		this.dataStructureId = dataStructureId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	public Set<DataStructureDetail> getDetail() {
		return detail;
	}

	public void setDetail(Set<DataStructureDetail> detail) {
		this.detail = detail;
	}
	
}
