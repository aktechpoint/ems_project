package com.abhi.ems.dto;

import lombok.Data;

@Data
public class EnquiryDto {
	private Integer Enq_id;
	private String Visitor_name;
	private Long Mobile_no;
	private String visitor_mode;
	private String officer_name;
	private String enqStatus;
	private String Property_id;
	public Integer getEnq_id() {
		return Enq_id;
	}
	public void setEnq_id(Integer enq_id) {
		Enq_id = enq_id;
	}
	public String getVisitor_name() {
		return Visitor_name;
	}
	public void setVisitor_name(String visitor_name) {
		Visitor_name = visitor_name;
	}
	public Long getMobile_no() {
		return Mobile_no;
	}
	public void setMobile_no(Long mobile_no) {
		Mobile_no = mobile_no;
	}
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
	public String getProperty_id() {
		return Property_id;
	}
	public void setProperty_id(String property_id) {
		Property_id = property_id;
	}
	
	

}
