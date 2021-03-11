package com.adinfi.admaster.domain.form;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.adinfi.admaster.domain.BaseModel;

@Entity
@Table(name = "TAB")
public class Tab extends BaseModel{

	@Id
	@Column(name = "TAB_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tabId;

	@Column(name = "DESCRIPTION", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String description;
	
	@Column(name="POSITION")
	@NotNull
	private Integer position;
	
	@OneToMany
	@JoinColumn(name="TAB_ID")
	@OrderBy
	private Set<FieldGroup> divs;

	public Long getTabId() {
		return tabId;
	}

	public void setTabId(Long tabId) {
		this.tabId = tabId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Set<FieldGroup> getDivs() {
		return divs;
	}

	public void setDivs(Set<FieldGroup> divs) {
		this.divs = divs;
	}
}
