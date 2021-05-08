package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Member;
import com.example.repository.MemberRepository;

@Controller
@RequestMapping("/ex05")
public class Exam05Controller {

	//表紙
	@RequestMapping("")
	public String index1() {
		return "exam05";
	}
	
	@Autowired
	private MemberRepository repository;
	
	@RequestMapping("/result")
	public String index(String name, Model model) {
		//リストに入っているnameをループで取得・スコープに格納する
		List<Member> resultList = repository.findByName(name); 
		
		for (int i = 1 ; i<=resultList.length ; i++) {
			
		}
		
		
		return "exam05-result";
	}
	
}
