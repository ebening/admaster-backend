package com.adinfi.admaster.domain.workflow;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.adinfi.admaster.domain.BaseModel;
import com.adinfi.admaster.domain.bussinnes.ObjectoUbicaciones;

@Entity
@Table(name = "WORKFLOW_CONFIG")
public class WorkFlowConfig extends BaseModel{

	@Id
	@Column(name = "WORKFLOW_CONFIG_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long workflowConfigId;
	
	@OneToOne
	@JoinColumn(name="WORKFLOW_ID")
	private WorkFlow workFlow;
	
	@OneToOne
	@JoinColumn(name="STAGE_CONFIG_ID")
	private StageConfig stageConfig;
	
	@Column(name = "VALUE_CODE", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String valueCode;
	
	@OneToOne
	@JoinColumn(name="NEXT_STAGE_CONFIG")
	private StageConfig nextStageConfig;

	@OneToOne
	@JoinColumn(name="STATUS_ID")
	private Status status;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="WORKFLOW_CONFIG_ID")
	@OrderBy
	private Set<WorkFlowConfigActions> actions;

	public Long getWorkflowConfigId() {
		return workflowConfigId;
	}

	public void setWorkflowConfigId(Long workflowConfigId) {
		this.workflowConfigId = workflowConfigId;
	}

	public WorkFlow getWorkFlow() {
		return workFlow;
	}

	public void setWorkFlow(WorkFlow workFlow) {
		this.workFlow = workFlow;
	}

	public StageConfig getStageConfig() {
		return stageConfig;
	}

	public void setStageConfig(StageConfig stageConfig) {
		this.stageConfig = stageConfig;
	}

	public String getValueCode() {
		return valueCode;
	}

	public void setValueCode(String valueCode) {
		this.valueCode = valueCode;
	}

	public StageConfig getNextStageConfig() {
		return nextStageConfig;
	}

	public void setNextStageConfig(StageConfig nextStageConfig) {
		this.nextStageConfig = nextStageConfig;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<WorkFlowConfigActions> getActions() {
		return actions;
	}

	public void setActions(Set<WorkFlowConfigActions> actions) {
		this.actions = actions;
	}
	
}
