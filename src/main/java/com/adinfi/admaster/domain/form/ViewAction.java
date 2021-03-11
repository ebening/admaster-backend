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
@Table(name = "APP_VIEW_ACTION")
public class ViewAction extends BaseModel{

	@Id
	@Column(name = "VIEW_ACTION_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long appViewConfigId;
	
	@Column(name = "VIEW_ID")
	@NotNull
	private Long viewId;

	@Column(name = "DESCRIPTION", length=100)
	@NotNull
	@Size(min = 4, max = 100)
	private String description;
	
	@Column(name = "HTML_ID", length=100)
	@NotNull
	@Size(min = 4, max = 100)
	private String htmlId;

	@Column(name = "DEFAULT_METHOD", length=100)
	@NotNull
	@Size(min = 4, max = 100)
	private String defaultMethod;

	public Long getAppViewConfigId() {
		return appViewConfigId;
	}

	public void setAppViewConfigId(Long appViewConfigId) {
		this.appViewConfigId = appViewConfigId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHtmlId() {
		return htmlId;
	}

	public void setHtmlId(String htmlId) {
		this.htmlId = htmlId;
	}

	public String getDefaultMethod() {
		return defaultMethod;
	}

	public void setDefaultMethod(String defaultMethod) {
		this.defaultMethod = defaultMethod;
	}

	public Long getViewId() {
		return viewId;
	}

	public void setViewId(Long viewId) {
		this.viewId = viewId;
	}
}
