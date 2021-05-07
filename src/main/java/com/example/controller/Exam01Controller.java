package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex01")
public class Exam01Controller {
	
	@RequestMapping("")
	public String index() {
		return "exam01";
	}
	
	@RequestMapping("/result")
	public String inputName(String name,Model model) {
		//requestスコープに格納
		model.addAttribute("name", name);
		return "exam01-result";
	}

}
