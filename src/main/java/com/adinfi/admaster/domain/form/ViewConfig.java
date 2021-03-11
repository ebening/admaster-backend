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
@Table(name = "APP_VIEW_CONFIG")
public class ViewConfig extends BaseModel{

	@Id
	@Column(name = "APP_VIEW_CONFIG_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long appViewConfigId;

	@Column(name = "VIEW_ID")
	@NotNull
	private Long viewId;
	
	@Column(name = "HTML_ID", length=100)
	@NotNull
	@Size(min = 4, max = 100)
	private String htmlId;

	@Column(name = "LABEL", length=100)
	@NotNull
	@Size(min = 4, max = 100)
	private String label;
	
	@Column(name="REQUIRED")
	@NotNull
	private boolean required;
	
	@Column(name="ROW_NUM")
	@NotNull
	private Integer rowNum;
	
	@Column(name="CELL_NUM")
	@NotNull
	private Integer cellNum;
	
	@Column(name="ROW_SPAN")
	@NotNull
	private Integer rowSpan;
	
	@Column(name="CELL_SPAN")
	@NotNull
	private Integer cellSpan;
	
	@Column(name="READONLY")
	@NotNull
	private boolean readOnly;

	public Long getAppViewConfigId() {
		return appViewConfigId;
	}

	public void setAppViewConfigId(Long appViewConfigId) {
		this.appViewConfigId = appViewConfigId;
	}

	public Long getViewId() {
		return viewId;
	}

	public void setViewId(Long viewId) {
		this.viewId = viewId;
	}

	public String getHtmlId() {
		return htmlId;
	}

	public void setHtmlId(String htmlId) {
		this.htmlId = htmlId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}

	public Integer getCellNum() {
		return cellNum;
	}

	public void setCellNum(Integer cellNum) {
		this.cellNum = cellNum;
	}

	public Integer getRowSpan() {
		return rowSpan;
	}

	public void setRowSpan(Integer rowSpan) {
		this.rowSpan = rowSpan;
	}

	public Integer getCellSpan() {
		return cellSpan;
	}

	public void setCellSpan(Integer cellSpan) {
		this.cellSpan = cellSpan;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
	
}
