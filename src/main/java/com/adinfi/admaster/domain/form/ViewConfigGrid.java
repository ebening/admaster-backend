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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.adinfi.admaster.domain.Application;
import com.adinfi.admaster.domain.BaseModel;
import com.adinfi.admaster.domain.DataStructureDetail;
import com.adinfi.admaster.domain.StructureDataHistory;
import com.adinfi.admaster.domain.workflow.WorkFlow;

@Entity
@Table(name = "APP_VIEW_CONFIG_GRID")
public class ViewConfigGrid extends BaseModel{

	@Id
	@Column(name = "APP_VIEW_CONFIG_GRID_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long appViewConfigGridId;

	@Column(name = "VIEW_ID")
	@NotNull
	private Long viewId;
	
	@Column(name = "HTML_ID", length=100)
	@NotNull
	@Size(min = 4, max = 100)
	private String htmlId;

	@Column(name = "GRID_TITLE", length=100)
	@NotNull
	@Size(min = 4, max = 100)
	private String gridTitle;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="APP_VIEW_CONFIG_GRID_ID")
	@OrderBy("position ASC")
	private Set<ViewConfigGridCfg> gridConfig;
	
	@Column(name = "SEARCH_COLUMNS", length=100)
	@NotNull
	@Size(min = 4, max = 100)
	private String searchColumns;

	public Long getAppViewConfigGridId() {
		return appViewConfigGridId;
	}

	public void setAppViewConfigGridId(Long appViewConfigGridId) {
		this.appViewConfigGridId = appViewConfigGridId;
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

	public String getGridTitle() {
		return gridTitle;
	}

	public void setGridTitle(String gridTitle) {
		this.gridTitle = gridTitle;
	}

	public String getSearchColumns() {
		return searchColumns;
	}

	public void setSearchColumns(String searchColumns) {
		this.searchColumns = searchColumns;
	}

	public Set<ViewConfigGridCfg> getGridConfig() {
		Set<ViewConfigGridCfg> l = new HashSet<ViewConfigGridCfg>();
		for(ViewConfigGridCfg s: gridConfig){
			if(s.getActive()){
				l.add(s);
			}
		}
		return l;
	}

	public void setGridConfig(Set<ViewConfigGridCfg> gridConfig) {
		this.gridConfig = gridConfig;
	}	
}
