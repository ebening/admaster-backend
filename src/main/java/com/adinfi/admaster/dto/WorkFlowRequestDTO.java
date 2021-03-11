package com.adinfi.admaster.dto;

public class WorkFlowRequestDTO {

	private Long dataId;
	private Long versionNum;
	private String valueCode;
	private Long eventosId;
	
	public Long getDataId() {
		return dataId;
	}
	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}
	public Long getVersionNum() {
		return versionNum;
	}
	public void setVersionNum(Long versionNum) {
		this.versionNum = versionNum;
	}
	public String getValueCode() {
		return valueCode;
	}
	public void setValueCode(String valueCode) {
		this.valueCode = valueCode;
	}
	
	public String toString(){
		return "dataId: " + this.dataId + ", versionNum: " + this.versionNum + ", valueCode: " + this.valueCode;
	}
	public Long getEventosId() {
		return eventosId;
	}
	public void setEventosId(Long eventosId) {
		this.eventosId = eventosId;
	}
}
