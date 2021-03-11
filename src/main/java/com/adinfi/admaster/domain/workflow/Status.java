package com.adinfi.admaster.domain.workflow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.adinfi.admaster.domain.BaseModel;

@Entity
@Table(name = "APP_STATUS")
public class Status extends BaseModel{

	@Id
	@Column(name = "STATUS_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long statusId;

	@Column(name = "DESCRIPTION", length = 100, unique = true)
	@NotNull
	@Size(min = 4, max = 100)
	private String description;

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
