package com.abhi.ems.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Enquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Enq_id;
	private String Visitor_name;
	private Long Mobile_no;
	private String visitor_mode;
	private String officer_name;
	
	private String enqStatus;
	private String Property_id;
	
	@CreationTimestamp
	private LocalDate createdAt;
	
	@UpdateTimestamp
	private LocalDate updatedAt;
	
	@ManyToOne
	@JoinColumn(name ="counsellor_id")
	private Counsellor counsellor;

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

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Counsellor getCounsellor() {
		return counsellor;
	}

	public void setCounsellor(Counsellor counsellor) {
		this.counsellor = counsellor;
	}
	
	
	

}
