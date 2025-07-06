package com.abhi.ems.dto;

import lombok.Data;

@Data
public class EnqFilterDTO {
	private String visitor_mode;
	private String officer_name;
	private String enqStatus;
	public String getVisitor_mode() {
		return visitor_mode;
	}
	public void setVisitor_mode(String visitor_mode) {
		this.visitor_mode = visitor_mode;
	}
	public String getOfficer_name() {
		return officer_name;
	}
	public void setOfficer_name(String officer_name) {
		this.officer_name = officer_name;
	}
	public String getEnqStatus() {
		return enqStatus;
	}
	public void setEnqStatus(String enqStatus) {
		this.enqStatus = enqStatus;
	}

	
}
