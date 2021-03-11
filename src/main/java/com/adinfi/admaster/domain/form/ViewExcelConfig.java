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
@Table(name = "APP_VIEW_EXCEL_CONFIG")
public class ViewExcelConfig extends BaseModel{

	@Id
	@Column(name = "VIEW_EXCEL_CONFIG_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long viewExcelConfigId;
	
	@Column(name = "VIEW_ID")
	@NotNull
	private Long viewId;

	@Column(name = "NAME", length=50)
	@NotNull
	@Size(min = 1, max = 50)
	private String name;
	
	@Column(name = "CELL", length=50)
	@NotNull
	@Size(min = 1, max = 50)
	private String cell;
	
	@Column(name = "REQUIRED")
	@NotNull
	private Boolean required;
	
	@Column(name = "VALIDATION_TYPE", length=50)
	@NotNull
	@Size(min = 1, max = 50)
	private String validationType;
	
	@Column(name = "CATALOG_QUERY", length=4000)
	@Size(min = 1, max = 4000)
	private String catalogQuery;
	
	@Column(name = "VALUE_TYPE", length=4000)
	@Size(min = 1, max = 4000)
	private String type;
	
	@Column(name = "CAN_SPLIT")
	private Boolean canSplit;
	
	@Column(name = "PROPERTY", length=4000)
	@Size(min = 1, max = 4000)
	private String property;
	
	

	public Long getViewExcelConfigId() {
		return viewExcelConfigId;
	}

	public void setViewExcelConfigId(Long viewExcelConfigId) {
		this.viewExcelConfigId = viewExcelConfigId;
	}

	public Long getViewId() {
		return viewId;
	}

	public void setViewId(Long viewId) {
		this.viewId = viewId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public String getValidationType() {
		return validationType;
	}

	public void setValidationType(String validationType) {
		this.validationType = validationType;
	}

	public String getCatalogQuery() {
		return catalogQuery;
	}

	public void setCatalogQuery(String catalogQuery) {
		this.catalogQuery = catalogQuery;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getCanSplit() {
		return canSplit;
	}

	public void setCanSplit(Boolean canSplit) {
		this.canSplit = canSplit;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	
}
