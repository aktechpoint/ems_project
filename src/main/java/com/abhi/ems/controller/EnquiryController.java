package com.abhi.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhi.ems.dto.EnqFilterDTO;
import com.abhi.ems.dto.EnquiryDto;
import com.abhi.ems.services.EnquiryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {

	@Autowired
	private EnquiryService enqservice;
	
	@GetMapping("/edit-enquiry")
	public String editEnquiry(@RequestParam("enqid") Integer Enq_id, Model model) {
		EnquiryDto enqDto = enqservice.getEnquiryId(Enq_id);
		model.addAttribute("enquiry", enqDto);
		return "add-enquiry";
	}
	
	@GetMapping("/Enquiry-page")
	public String loadEnqPage(Model model) {
		EnquiryDto enqDto = new EnquiryDto();
		model.addAttribute("Enquiry", enqDto);
		return "add-enquiry";
	}
	@PostMapping("/add-enquiry")
	public String addEnquiry(HttpServletRequest req, @ModelAttribute("enquiry") EnquiryDto Enquiry, Model model) {
		
		HttpSession session = req.getSession(false);
		Integer counsellor_id = (Integer) session.getAttribute("counsellor_id");
		boolean status = enqservice.addEnquiry(Enquiry, counsellor_id);
		if (status) {
			model.addAttribute("smsg", "Enquiry data Saved !");
		}else {
			model.addAttribute("emsg", "Failed to save Enquiry");
		}
		return "add-enquiry";
	}
	@GetMapping("/view-enquiries")
	public String getEnquiries(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		Integer counsellor_id = (Integer) session.getAttribute("counsellor_id");
		List<EnquiryDto> enqList = enqservice.getEnquiry(counsellor_id);
		model.addAttribute("enquiries", enqList);
		EnqFilterDTO filterDTO = new EnqFilterDTO();
		model.addAttribute("fillterDTO", filterDTO);
		return "view-enquiries";
		
	}
	
	@PostMapping("/filter-enquiries")
	public String filterEnquires(HttpServletRequest req, @ModelAttribute("filterDTO") EnqFilterDTO fillterDTO, Model model) {
		HttpSession session = req.getSession(false);
		Integer counsellor_id = (Integer) session.getAttribute("counsellor_id");
		List<EnquiryDto> enqList = enqservice.getEnquiry(fillterDTO, counsellor_id);
		model.addAttribute("enquiries", enqList);
		return "view-enquiries";
	}
}











