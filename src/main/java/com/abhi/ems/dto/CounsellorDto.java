package com.abhi.ems.dto;

import lombok.Data;

@Data
public class CounsellorDto {
	
	private Integer counsellorId;
	private String coun_name;
	private String email;
	private String pwd;
	private String mobile_no;
	
	public Integer getCounsellorId() {
		return counsellorId;
	}
	public void setCounsellorId(Integer counsellorId) {
		this.counsellorId = counsellorId;
	}
	public String getCoun_name() {
		return coun_name;
	}
	public void setCoun_name(String coun_name) {
		this.coun_name = coun_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	

}
