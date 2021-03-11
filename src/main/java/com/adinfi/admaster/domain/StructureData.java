package com.adinfi.admaster.domain;

import com.adinfi.admaster.domain.bussinnes.Eventos;

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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "STRUCTURE_DATA")
public class StructureData extends BaseModel{

	@Id
	@Column(name = "DATA_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long dataId;

	@Column(name = "DESCRIPTION", length = 50)
	@NotNull
	@Size(min = 2, max = 50)
	private String description;
	
	@NotNull
	@Column(name = "APP_ID")
	private Long appId;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="DATA_ID")
	@OrderBy
	private Set<StructureDataDetail> detail;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="DATA_ID")
	@OrderBy
	private Set<StructureDataHistory> history;

	@Column(name = "EventosId")
	private Long eventosId;
	
	public Long getDataId() {
		return dataId;
	}

	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<StructureDataDetail> getDetail() {
		return detail;
	}

	public void setDetail(Set<StructureDataDetail> detail) {
		this.detail = detail;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public Set<StructureDataHistory> getHistory() {
		//return history.stream().filter(h -> h.getActive()).collect(Collectors.toSet());
		Set<StructureDataHistory> l = new HashSet<StructureDataHistory>();
		for(StructureDataHistory s: history){
			if(s.getActive()){
				l.add(s);
			}
		}
		return l;
	}

	public void setHistory(Set<StructureDataHistory> history) {
		this.history = history;
	}

	public Long getEventosId() {
		return eventosId;
	}

	public void setEventosId(Long eventosId) {
		this.eventosId = eventosId;
	}

	public String toString(){
		return "description: "+this.description + ", appId: " + this.appId + ", active: " + this.getActive();
	}
}
