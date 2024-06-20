package com.barofarm.fish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.barofarm.fish.service.IF_UserService;
import com.barofarm.fish.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	IF_UserService uService;
	
//	@GetMapping("login")
//	// 로그인 메인
//	public String login() {
//		return "login";
//	}
	
	@GetMapping("user_join")
	// 회원가입
	public String join() {
		return "user_join";
	}
	
	@PostMapping("userJoin")
	// 가입정보 저장
	public String usersave(@ModelAttribute UserVo uVo) throws Exception{
		uService.join(uVo);
		//	System.out.println(uVo.getUser_id());
		//	System.out.println(uVo.getUser_grade());
		//	System.out.println(uVo.getUser_pass());
	return "home";
	}
	
	
	@GetMapping("u_view")
	// a 링크 만들고 post로 바꾸기 
	public String allview(Model model) throws Exception{
		List<UserVo> uVo =uService.view();
		model.addAttribute("user",uVo);
		return "user_view";
	}
	
	@GetMapping("/del/{user_id}")
	public String udelete(@PathVariable("user_id") String id) throws Exception{
		uService.udelete(id);
		return "redirect:u_view";
	}
	// 메서드명칭 충돌인 것 같다. udelete 변경하니깐 오류 안남 
	@GetMapping("/mod/{user_id}")
	public String umodify(@PathVariable("user_id") String id,Model model) throws Exception{
		UserVo uVo=uService.umodify(id);
		model.addAttribute("umodiVo",uVo);
		return "user_modify";
	}
	
	@PostMapping("/user_modSave")
	public String umodSave(@ModelAttribute UserVo uVo) throws Exception{
		uService.umodsave(uVo);
		return "redirect:u_view";
	}

	
}
