package com.abhi.ems.services;

import java.util.List;

import com.abhi.ems.dto.DashboardDto;
import com.abhi.ems.dto.EnqFilterDTO;
import com.abhi.ems.dto.EnquiryDto;

public interface EnquiryService {
	
	public DashboardDto getDashboardInfo(Integer counsellor_id);
	
	public boolean addEnquiry(EnquiryDto enqdto, Integer counsellor_id);
	
	public List<EnquiryDto> getEnquiry(Integer counsellor_id);
	
	public List<EnquiryDto> getEnquiry(EnqFilterDTO filterDto, Integer counsellor_id);
	
	public EnquiryDto getEnquiryId(Integer Enq_id);
	
	

}
