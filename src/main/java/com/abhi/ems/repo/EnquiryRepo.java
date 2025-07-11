package com.abhi.ems.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.ems.entity.Enquiry;


public interface EnquiryRepo extends JpaRepository<Enquiry, Integer>{
	
	public List<Enquiry> findByCounsellorCounsellorId( Integer counsellor_id);
	

}
