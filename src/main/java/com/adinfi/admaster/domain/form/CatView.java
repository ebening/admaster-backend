package com.adinfi.admaster.domain.form;

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
import com.adinfi.admaster.domain.StructureDataDetail;
import com.adinfi.admaster.domain.workflow.WorkFlow;

@Entity
@Table(name = "CAT_VIEW")
public class CatView extends BaseModel{

	@Id
	@Column(name = "CAT_VIEW_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long catViewId;
	
	@Column(name = "DESCRIPTION", length=100)
	@NotNull
	@Size(min = 4, max = 100)
	private String description;

	public Long getCatViewId() {
		return catViewId;
	}

	public void setCatViewId(Long catViewId) {
		this.catViewId = catViewId;
	}

	public String getDescription() {
		return description;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	public void setDescription(String description) {
		this.description = description;
	}

}
