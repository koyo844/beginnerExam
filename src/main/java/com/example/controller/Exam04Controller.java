package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
import com.example.form.UserForm;

@Controller
@RequestMapping("/ex04")
public class Exam04Controller {

	//入力画面
	@RequestMapping("")
	public String index() {
		return "exam04";
	}
	//フォームを使えるようにする
	@ModelAttribute
	public UserForm setUpform() {
		return new UserForm();
	}
	
	@RequestMapping("/result")
	public String display(@Validated UserForm userForm
			,BindingResult result
			,RedirectAttributes redirectAttributes
			,Model model) {
		
		if(result.hasErrors()) {
			return index();
		}
		
		User user = new User();
		//フォームで受け取った情報をドメインへ入れて行く
		user.setName(userForm.getName());
		user.setAge(Integer.parseInt(userForm.getAge()));
		user.setComment(userForm.getComment());
		
		//requestフォームに格納（ドメインから情報を取得）
		model.addAttribute("User", user);
		
		return "exam04-result.html";
	}
	
}
