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
@Table(name = "STAGE")
public class Stage extends BaseModel{

	@Id
	@Column(name = "STAGE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long stageId;

	@Column(name = "DESCRIPTION", length = 100, unique = true)
	@NotNull
	@Size(min = 4, max = 100)
	private String description;
	

	public Long getStageId() {
		return stageId;
	}

	public void setStageId(Long stageId) {
		this.stageId = stageId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
