package com.adinfi.admaster.domain.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.adinfi.admaster.domain.BaseModel;

@Entity
@Table(name = "FIELD")
public class Field extends BaseModel{

	@Id
	@Column(name = "FIELD_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long fieldId;

	@Column(name = "DESCRIPTION", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String description;
	
	@Column(name = "PATH", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String path;
	
	@Column(name = "TYPE", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String type;
	
	@Column(name="ROW_NUM")
	@NotNull
	private Integer rowNum;
	
	@Column(name="CELL_NUM")
	@NotNull
	private Integer cellNum;
	
	@Column(name="REQUIRED")
	@NotNull
	private boolean required;
	

	public Long getFieldId() {
		return fieldId;
	}

	public void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
}
