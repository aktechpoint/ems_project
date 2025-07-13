package com.abhi.ems.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.abhi.ems.dto.DashboardDto;
import com.abhi.ems.dto.EnqFilterDTO;
import com.abhi.ems.dto.EnquiryDto;
import com.abhi.ems.entity.Counsellor;
import com.abhi.ems.entity.Enquiry;
import com.abhi.ems.repo.CounsellorRepo;
import com.abhi.ems.repo.EnquiryRepo;

@Service
public class EnquiryServiceImpl implements EnquiryService{
	
	@Autowired
	private EnquiryRepo enqRepo;
	@Autowired
	private CounsellorRepo counsellorRepo;

	@Override
	public DashboardDto getDashboardInfo(Integer counsellor_id) {
		DashboardDto dto = new DashboardDto();
		List<Enquiry> enqsList = enqRepo.findByCounsellorCounsellorId(counsellor_id);
		
		int avail_Enq_inwaiting = enqsList.stream().filter(enq -> enq.getEnqStatus().equals("open")).collect(Collectors.toList()).size();
		int meeting_Done = enqsList.stream().filter(enq -> enq.getEnqStatus().equals("confirm")).collect(Collectors.toList()).size();
		int not_in_que = enqsList.stream().filter(enq -> enq.getEnqStatus().equals("denied")).collect(Collectors.toList()).size();
		dto.setTotlaEnqs(enqsList.size());
		dto.setAvail_Enq_inwaiting(avail_Enq_inwaiting);
		dto.setMeeting_Done(meeting_Done);
		dto.setNot_in_que(not_in_que);
		
		
		return dto;
	}

	@Override
	public boolean addEnquiry(EnquiryDto enqdto, Integer counsellor_id) {
	
		Enquiry entity = new Enquiry();
		BeanUtils.copyProperties(enqdto, entity);
		Optional<Counsellor> byId = counsellorRepo.findById(counsellor_id);
		if(byId.isPresent()) {
			Counsellor conunsellor = byId.get();
			entity.setCounsellor(conunsellor);
		}
		Enquiry save = enqRepo.save(entity);
		return save.getEnq_id() != null;
	}

	@Override
	public List<EnquiryDto> getEnquiry(Integer counsellor_id) {
		List<EnquiryDto> enqdtolist = new ArrayList<>();
		List<Enquiry> enqlist = enqRepo.findByCounsellorCounsellorId(counsellor_id);
		for(Enquiry entity :enqlist) {
			EnquiryDto dto = new EnquiryDto();
			BeanUtils.copyProperties(entity, dto);
			enqdtolist.add(dto);
			
		}
		return enqdtolist;
	}

	@Override
	public List<EnquiryDto> getEnquiry(EnqFilterDTO filterDto, Integer counsellor_id) {
		Enquiry entity =new Enquiry();
		if(filterDto.getVisitor_mode() != null && !filterDto.getVisitor_mode().equals("")) {
			entity.setVisitor_mode(filterDto.getVisitor_mode());
		}
		if(filterDto.getOfficer_name() !=null && !filterDto.getOfficer_name().equals("")) {
			entity.setOfficer_name(filterDto.getOfficer_name());
		}
		if(filterDto.getEnqStatus() !=null && !filterDto.getEnqStatus().equals("")) {
			entity.setEnqStatus(filterDto.getEnqStatus());
		}
		Counsellor counsellor = new Counsellor();
		counsellor.setCounsellorId(counsellor_id);
		entity.setCounsellor(counsellor);
		Example<Enquiry> of = Example.of(entity);
		List<Enquiry> enqList = enqRepo.findAll(of);
		
		List<EnquiryDto> enqDtolist = new ArrayList<>();
		for(Enquiry enq : enqList) {
			EnquiryDto dto = new EnquiryDto();
			BeanUtils.copyProperties(enq, dto);
			enqDtolist.add(dto);
		}
		return enqDtolist;
	}

	@Override
	public EnquiryDto getEnquiryId(Integer Enq_id) {
		Optional<Enquiry> byId = enqRepo.findById(Enq_id);
		if(byId.isPresent()) {
			Enquiry enqtable = byId.get();
			EnquiryDto dto = new EnquiryDto();
			BeanUtils.copyProperties(enqtable, dto);
			return dto;
		}
		return null;
	}

}
