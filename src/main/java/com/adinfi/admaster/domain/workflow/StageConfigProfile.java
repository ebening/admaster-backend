package com.adinfi.admaster.domain.workflow;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.adinfi.admaster.domain.BaseModel;

@Entity
@Table(name = "stage_config_profile")
public class StageConfigProfile extends BaseModel{

	@Id
	@Column(name = "STAGE_CONFIG_PROFILE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long stageConfigProfileId;
	
	@Column(name = "STAGE_CONFIG_ID")
	@NotNull
	private Long stageConfigId;
	
	@Column(name = "PROFILE_ID")
	@NotNull
	private Long profileId;
	
	@Column(name = "IS_OWNER")
	private Boolean isOwner;
	
	@Column(name="CREATION_DATE")
	private Timestamp creationDate;
	
	@Column(name="LAST_UP_DATE")
	private Timestamp lastUpDate;
	
	@Column(name="CREATOR_ID")
	private Long creatorId;
	
	@Column(name="UPDATOR_ID")
	private Long updatorId;

	public Long getStageConfigProfileId() {
		return stageConfigProfileId;
	}

	public void setStageConfigProfileId(Long stageConfigProfileId) {
		this.stageConfigProfileId = stageConfigProfileId;
	}

	public Long getStageConfigId() {
		return stageConfigId;
	}

	public void setStageConfigId(Long stageConfigId) {
		this.stageConfigId = stageConfigId;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public Boolean getIsOwner() {
		return isOwner;
	}

	public void setIsOwner(Boolean isOwner) {
		this.isOwner = isOwner;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getLastUpDate() {
		return lastUpDate;
	}

	public void setLastUpDate(Timestamp lastUpDate) {
		this.lastUpDate = lastUpDate;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public Long getUpdatorId() {
		return updatorId;
	}

	public void setUpdatorId(Long updatorId) {
		this.updatorId = updatorId;
	}
}
