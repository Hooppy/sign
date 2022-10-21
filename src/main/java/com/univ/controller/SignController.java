package com.univ.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.univ.service.SignService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SignController {
	
	private final SignService signService;
	
	@GetMapping
	public String index(Model model) {
		
		Long signPeople = signService.getSignPeople();
		
		model.addAttribute("today", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		model.addAttribute("signPeople", signPeople);
		
		return "index";
	}
	
	@PostMapping("/sign")
	public String sign(@RequestParam Map<String, Object> params) {
		
		signService.sign(params);
		
		return "index";
	}
	
}
