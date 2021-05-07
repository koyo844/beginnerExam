package com.example.controller;

import java.text.NumberFormat;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex03")
public class Exam03Controller {

	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "exam03";
	}
	
	@RequestMapping("/result")
	public String calc(String num1,String num2,String num3) {
		//数値への変換と計算
		int i = Integer.parseInt(num1);
		int p = Integer.parseInt(num2);
		int t = Integer.parseInt(num3);
		int total = i + p + t;
		int taxplus = (int)((int)(i + p + t)*1.1);
		
		NumberFormat comma = NumberFormat.getNumberInstance();
		
		//applicationスコープに格納
		application.setAttribute("total", comma.format(total));
		application.setAttribute("taxplus", comma.format(taxplus));
		return "exam03-result.html";
	
	}

	
}
