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
@Table(name = "FIELD_GROUP")
public class FieldGroup extends BaseModel{

	@Id
	@Column(name = "FIELD_GROUP_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long fieldGroupId;

	@Column(name = "DESCRIPTION", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String description;
	
	@Column(name = "LIST_NAME", length = 50)
	@NotNull
	@Size(min = 4, max = 50)
	private String listName;
	
	@Column(name="POSITION")
	@NotNull
	private Integer position;
	
	@OneToMany
	@JoinColumn(name="FIELD_GROUP_ID")
	@OrderBy
	private Set<Field> fields;

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

	public Long getFieldGroupId() {
		return fieldGroupId;
	}

	public void setFieldGroupId(Long fieldGroupId) {
		this.fieldGroupId = fieldGroupId;
	}

	public Set<Field> getFields() {
		return fields;
	}

	public void setFields(Set<Field> fields) {
		this.fields = fields;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}
}
