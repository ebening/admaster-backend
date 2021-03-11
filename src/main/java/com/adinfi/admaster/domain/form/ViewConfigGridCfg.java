package com.adinfi.admaster.domain.form;

import java.util.Set;

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

import com.adinfi.admaster.domain.Application;
import com.adinfi.admaster.domain.BaseModel;
import com.adinfi.admaster.domain.DataStructureDetail;
import com.adinfi.admaster.domain.workflow.WorkFlow;

@Entity
@Table(name = "APP_VIEW_CONFIG_GRID_CFG")
public class ViewConfigGridCfg extends BaseModel{

	@Id
	@Column(name = "APP_VIEW_CONFIG_GRID_CFG_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long appViewConfigGridCfgId;
	
	@Column(name = "APP_VIEW_CONFIG_GRID_ID")
	@NotNull
	private Long appViewConfigGridId;
	
	@Column(name = "DESCRIPTION", length=100)
	@NotNull
	@Size(min = 2, max = 100)
	private String descritpion;
	
	@Column(name = "DATA_KEY", length=100)
	@NotNull
	@Size(min = 2, max = 100)
	private String dateKey;
	
	@Column(name = "LABEL", length=100)
	@NotNull
	@Size(min = 2, max = 100)
	private String label;
	
	@Column(name="POSITION")
	@NotNull
	private Integer position;

	@Column(name="STYLE", length=100)
	@Size(min = 2, max = 100)
	private String style;

	
	public Long getAppViewConfigGridCfgId() {
		return appViewConfigGridCfgId;
	}

	public void setAppViewConfigGridCfgId(Long appViewConfigGridCfgId) {
		this.appViewConfigGridCfgId = appViewConfigGridCfgId;
	}

	public String getDescritpion() {
		return descritpion;
	}

	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}

	public String getDateKey() {
		return dateKey;
	}

	public void setDateKey(String dateKey) {
		this.dateKey = dateKey;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Long getAppViewConfigGridId() {
		return appViewConfigGridId;
	}

	public void setAppViewConfigGridId(Long appViewConfigGridId) {
		this.appViewConfigGridId = appViewConfigGridId;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
		
}
