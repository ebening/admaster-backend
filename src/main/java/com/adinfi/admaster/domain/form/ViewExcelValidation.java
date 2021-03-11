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
@Table(name = "APP_VIEW_EXCEL_VALIDATION")
public class ViewExcelValidation extends BaseModel{

	@Id
	@Column(name = "VIEW_EXCEL_VALIDATION_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long viewExcelValidationId;
	
	@Column(name = "VIEW_ID")
	@NotNull
	private Long viewId;

	@Column(name = "CELL", length=50)
	@NotNull
	@Size(min = 2, max = 50)
	private String cell;
	
	@Column(name = "POSIBLE_VALUES", length=200)
	@NotNull
	@Size(min = 4, max = 200)
	private String posibleValues;

	public Long getViewExcelValidationId() {
		return viewExcelValidationId;
	}

	public void setViewExcelValidationId(Long viewExcelValidationId) {
		this.viewExcelValidationId = viewExcelValidationId;
	}

	public Long getViewId() {
		return viewId;
	}

	public void setViewId(Long viewId) {
		this.viewId = viewId;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getPosibleValues() {
		return posibleValues;
	}

	public void setPosibleValues(String posibleValues) {
		this.posibleValues = posibleValues;
	}
	
	
}
