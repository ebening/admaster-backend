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
import com.adinfi.admaster.domain.workflow.WorkFlow;

@Entity
@Table(name = "APPLICATION")
public class Application extends BaseModel{

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CONTEXT", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String context;
	
	@OneToOne
	@JoinColumn(name="WORKFLOW_ID")
	private WorkFlow workFlow;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public WorkFlow getWorkFlow() {
		return workFlow;
	}

	public void setWorkFlow(WorkFlow workFlow) {
		this.workFlow = workFlow;
	}	
}
