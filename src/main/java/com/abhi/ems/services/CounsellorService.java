package com.abhi.ems.services;

import com.abhi.ems.dto.CounsellorDto;

public interface CounsellorService {
	
	public CounsellorDto login(CounsellorDto counsellorDTO);
	
	public boolean uniqueEmailCheck(String email);
	
	public boolean register(CounsellorDto counsellorDTO);
	
	
}
