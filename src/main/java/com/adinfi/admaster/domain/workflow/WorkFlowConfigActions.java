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
@Table(name = "WORKFLOW_CONFIG_ACTIONS")
public class WorkFlowConfigActions extends BaseModel{

	@Id
	@Column(name = "WORKFLOW_CONFIG_ACTION_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long workflowConfigActionId;
	
	@Column(name = "WORKFLOW_CONFIG_ID")
	@NotNull
	private Long workflowConfigId;
	
	@Column(name = "METHOD", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String valueCode;

	public Long getWorkflowConfigActionId() {
		return workflowConfigActionId;
	}

	public void setWorkflowConfigActionId(Long workflowConfigActionId) {
		this.workflowConfigActionId = workflowConfigActionId;
	}

	public Long getWorkflowConfigId() {
		return workflowConfigId;
	}

	public void setWorkflowConfigId(Long workflowConfigId) {
		this.workflowConfigId = workflowConfigId;
	}

	public String getValueCode() {
		return valueCode;
	}

	public void setValueCode(String valueCode) {
		this.valueCode = valueCode;
	}
	
}
