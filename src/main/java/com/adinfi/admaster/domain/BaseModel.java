package com.adinfi.admaster.domain;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class BaseModel {

	@NotNull
	private Boolean active;

	public Boolean getActive() {
		return (active == null ? true: active);
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
