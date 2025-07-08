package com.abhi.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.abhi.ems.dto.CounsellorDto;
import com.abhi.ems.dto.DashboardDto;
import com.abhi.ems.services.CounsellorService;
import com.abhi.ems.services.EnquiryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellorController {
	
	@Autowired
	private CounsellorService counsellorService;
	@Autowired
	private EnquiryService enquiryService;
	
	@GetMapping("/")
	public String index(Model model) {
		CounsellorDto cdto = new CounsellorDto();
		model.addAttribute("counsellor", cdto);
		return "index";
	}
	
	@PostMapping("/login")
	public String handleLogin(HttpServletRequest req, CounsellorDto counsellor, Model model) {
		CounsellorDto counsellordto = counsellorService.login(counsellor);
		if(counsellordto == null) {
			CounsellorDto cdto = new CounsellorDto();
			model.addAttribute("counsellor", cdto);
			model.addAttribute("emsg", "Invalid Credentials");
			return "index";
			
		}
		else {
			Integer counsellor_id = counsellordto.getCounsellor_id();
			HttpSession session = req.getSession(true);
			session.setAttribute("counsellor_id", counsellor_id);
			DashboardDto dashboarddto = enquiryService.getDashboardInfo(counsellor_id);
			model.addAttribute("Dashboard", dashboarddto);
			return "dashboard";
		}
		
	}
	

}
