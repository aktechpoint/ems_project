package com.abhi.ems.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.ems.dto.CounsellorDto;
import com.abhi.ems.entity.Counsellor;
import com.abhi.ems.repo.CounsellorRepo;

@Service
public class CounsellorServiceImpl implements CounsellorService {
	
	@Autowired
	private CounsellorRepo counsellorRepo;

	@Override
	public CounsellorDto login(CounsellorDto counsellorDTO) {
		Counsellor entity = counsellorRepo.findByEmailAndPwd(counsellorDTO.getEmail(), counsellorDTO.getPwd());
		if (entity != null) {
			//copy the entity obj data into dto obj and return dto obj
			CounsellorDto dto = new CounsellorDto();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}
		return null;
	}

	@Override
	public boolean uniqueEmailCheck(String email) {
		Counsellor entity = counsellorRepo.findByEmail(email);
		return entity == null;
	}

	@Override
	public boolean register(CounsellorDto counsellorDTO) {
		Counsellor entity = new Counsellor();
		BeanUtils.copyProperties(counsellorDTO, entity);
		Counsellor saveEntity = counsellorRepo.save(entity);
		return null != saveEntity. getCounsellorId();
	}

}
