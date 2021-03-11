package com.adinfi.admaster.domain.form;

import java.util.HashSet;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.adinfi.admaster.domain.Application;
import com.adinfi.admaster.domain.BaseModel;
import com.adinfi.admaster.domain.StructureDataHistory;

@Entity
@Table(name = "APP_VIEW")
public class View extends BaseModel{

	@Id
	@Column(name = "VIEW_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long viewId;

	@OneToOne
	@JoinColumn(name="CAT_VIEW_ID")
	private CatView catView;
	
	@OneToOne
	@JoinColumn(name="APPLICATION_ID")
	private Application application;
	
	@Column(name = "DESCRIPTION", length=100)
	@NotNull
	@Size(min = 4, max = 100)
	private String description;
	
	@Column(name = "VIEW_TITLE", length=100)
	@NotNull
	@Size(min = 4, max = 100)
	private String viewTitle;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="VIEW_ID")
	@OrderBy
	private Set<ViewConfig> viewConfig;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="VIEW_ID")
	@OrderBy
	private Set<ViewAction> viewAction;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="VIEW_ID")
	@OrderBy
	private Set<ViewExcelValidation> viewExcelValidations;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="VIEW_ID")
	@OrderBy
	private Set<ViewConfigGrid> viewGrids;
	
	@Column(name = "APPLY_EXCEL_IMPORT")
	private Boolean applyExcelImport;
	
	@Column(name = "EXCEL_DATA_FIRST_ROW")
	private Integer excelDataFirstRow;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="VIEW_ID")
	@OrderBy
	private Set<ViewExcelConfig> viewExcelConfig;
	

	public Long getViewId() {
		return viewId;
	}

	public void setViewId(Long viewId) {
		this.viewId = viewId;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getViewTitle() {
		return viewTitle;
	}

	public void setViewTitle(String viewTitle) {
		this.viewTitle = viewTitle;
	}

	public Set<ViewConfig> getViewConfig() {
		//return history.stream().filter(h -> h.getActive()).collect(Collectors.toSet());
		Set<ViewConfig> l = new HashSet<ViewConfig>();
		for(ViewConfig s: viewConfig){
			if(s.getActive()){
				l.add(s);
			}
		}
		return l;
	}

	public void setViewConfig(Set<ViewConfig> viewConfig) {
		this.viewConfig = viewConfig;
	}

	public Set<ViewAction> getViewAction() {
		return viewAction;
	}

	public void setViewAction(Set<ViewAction> viewAction) {
		this.viewAction = viewAction;
	}

	public Boolean getApplyExcelImport() {
		return applyExcelImport;
	}

	public void setApplyExcelImport(Boolean applyExcelImport) {
		this.applyExcelImport = applyExcelImport;
	}

	public Set<ViewExcelValidation> getViewExcelValidations() {
		return viewExcelValidations;
	}

	public void setViewExcelValidations(Set<ViewExcelValidation> viewExcelValidations) {
		this.viewExcelValidations = viewExcelValidations;
	}

	public Set<ViewConfigGrid> getViewGrids() {
		return viewGrids;
	}

	public void setViewGrids(Set<ViewConfigGrid> viewGrids) {
		this.viewGrids = viewGrids;
	}

	public Integer getExcelDataFirstRow() {
		return excelDataFirstRow;
	}

	public void setExcelDataFirstRow(Integer excelDataFirstRow) {
		this.excelDataFirstRow = excelDataFirstRow;
	}

	public Set<ViewExcelConfig> getViewExcelConfig() {
		return viewExcelConfig;
	}

	public void setViewExcelConfig(Set<ViewExcelConfig> viewExcelConfig) {
		this.viewExcelConfig = viewExcelConfig;
	}

}
