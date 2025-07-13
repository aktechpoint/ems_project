package com.abhi.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		return "index.html";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req, Model model) {
		HttpSession session =req.getSession(false);
		session.invalidate();
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
			Integer counsellorId = counsellordto.getCounsellorId();
			HttpSession session = req.getSession(true);
			session.setAttribute("counsellor_id", counsellorId);
			DashboardDto dashboarddto = enquiryService.getDashboardInfo(counsellorId);
			model.addAttribute("Dashboard", dashboarddto);
			return "dashboard";
		}
		
	}
	@GetMapping("/register")
	public String registerPage(Model model) {
		CounsellorDto cdto =new CounsellorDto();
		model.addAttribute("counsellor", cdto);
		return "register";
	}
	
	@PostMapping("/register")
	public String handleRegister(@ModelAttribute("counsellor") CounsellorDto Counsellor, Model model) {
		boolean unique = counsellorService.uniqueEmailCheck(Counsellor.getEmail());
		if(unique) {
			boolean register = counsellorService.register(Counsellor);
			if(register) {
				model.addAttribute("smsg","Registration Success");
				
			}else {
				model.addAttribute("emsg", "Registration Failed");
			}
		}else {
			model.addAttribute("emsg", "Enter Unique Email");
		}
		return "register";
	}
	
	@GetMapping("/dashboard")
	public String displayDashboard(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		Integer counsellor_id =(Integer) session.getAttribute("counsellor_id");
		DashboardDto dashboarddto = enquiryService.getDashboardInfo(counsellor_id);
		model.addAttribute("dashboard", dashboarddto);
		return "dashboard";
	}

}
