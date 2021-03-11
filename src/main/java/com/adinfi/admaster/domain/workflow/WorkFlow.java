package com.adinfi.admaster.domain.workflow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.adinfi.admaster.domain.BaseModel;

@Entity
@Table(name = "WORKFLOW")
public class WorkFlow extends BaseModel{

	@Id
	@Column(name = "WORKFLOW_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long workFlowId;

	@Column(name = "DESCRIPTION", length = 50, unique = true)
	@NotNull
	@Size(min = 4, max = 50)
	private String description;
	
	@OneToOne
	@JoinColumn(name="FIRST_STAGE_CONFIG")
	private StageConfig firstStageConfig;
	
	@Column(name = "FIRST_VALUE_CODE", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String firstValueCode;

	public Long getWorkFlowId() {
		return workFlowId;
	}

	public void setWorkFlowId(Long workFlowId) {
		this.workFlowId = workFlowId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StageConfig getFirstStageConfig() {
		return firstStageConfig;
	}

	public void setFirstStageConfig(StageConfig firstStageConfig) {
		this.firstStageConfig = firstStageConfig;
	}

	public String getFirstValueCode() {
		return firstValueCode;
	}

	public void setFirstValueCode(String firstValueCode) {
		this.firstValueCode = firstValueCode;
	}
}
