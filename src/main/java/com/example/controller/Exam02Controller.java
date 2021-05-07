package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex02")
public class Exam02Controller {

	//2ページに渡って情報を保持したいのでsessionスコープを使う
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	public String index() {
		return "exam02";
	}

	@RequestMapping("/result")
	public String inputName(String num1, String num2) {
		//数字を数値に変える
		int i = Integer.parseInt(num1);
		int p = Integer.parseInt(num2);
		int answer = i + p ;
		
		//requestスコープに格納
		session.setAttribute("num1", i);
		session.setAttribute("num2", p);
		session.setAttribute("answer", answer);
		return "exam02-result";
	}
	
	//結果画面その1
	@RequestMapping("/result1")
	public String toPage1() {
		return "exam02-result";
	}
	
	//結果画面その2
	@RequestMapping("/result2")
	public String toPage2() {
		return "exam02-result2";
	}
}
