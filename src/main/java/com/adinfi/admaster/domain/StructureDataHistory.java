package com.adinfi.admaster.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.adinfi.admaster.domain.workflow.StageConfig;
import com.adinfi.admaster.domain.workflow.WorkFlowConfig;

@Entity
@Table(name = "STRUCTURE_DATA_HISTORY")
public class StructureDataHistory extends BaseModel{

	@Id
	@Column(name = "STRUCTURE_DATA_HISTORY_ID")
	@GeneratedValue()
	private Long structureDataHistoryId;
	
	@Column(name = "DATA_ID")
	private Long dataId;
	
	@Column(name = "CONSECUTIVE")
	@NotNull
	private Long consecutive;
	
	@OneToOne
	@JoinColumn(name="WORKFLOW_CONFIG_ID")
	private WorkFlowConfig workFlowConfig;

	public Long getStructureDataHistoryId() {
		return structureDataHistoryId;
	}

	public void setStructureDataHistoryId(Long structureDataHistoryId) {
		this.structureDataHistoryId = structureDataHistoryId;
	}

	public Long getConsecutive() {
		return consecutive;
	}

	public void setConsecutive(Long consecutive) {
		this.consecutive = consecutive;
	}

	public WorkFlowConfig getWorkFlowConfig() {
		return workFlowConfig;
	}

	public void setWorkFlowConfig(WorkFlowConfig workFlowConfig) {
		this.workFlowConfig = workFlowConfig;
	}

	public Long getDataId() {
		return dataId;
	}

	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}
		
}
