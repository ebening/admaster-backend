package com.adinfi.admaster.domain.workflow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.adinfi.admaster.domain.BaseModel;

@Entity
@Table(name = "STAGE_CONFIG")
public class StageConfig extends BaseModel{

	@Id
	@Column(name = "STAGE_CONFIG_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long stageId;

	@OneToOne
	@JoinColumn(name="STAGE_ID")
	@OrderBy
	private Stage stage;
	
	@Column(name = "ACTION_URL", length = 50)
	@NotNull
	@Size(min = 2, max = 50)
	private String actionUrl;
	
	@Column(name = "FORM_VERSION")
	private Integer versionNum;
	

	public Long getStageId() {
		return stageId;
	}

	public void setStageId(Long stageId) {
		this.stageId = stageId;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public String getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	public Integer getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}
}
