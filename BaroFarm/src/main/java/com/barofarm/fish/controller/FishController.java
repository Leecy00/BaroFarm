package com.barofarm.fish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.barofarm.fish.service.IF_FishService;
import com.barofarm.fish.vo.FishVo;
@Controller
public class FishController {

	@Autowired
	IF_FishService fService;

	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/add")
	public String add() {
		return "add";
	}
	@PostMapping("/addSave")
	public String addSave(@ModelAttribute FishVo  fVo) throws Exception{
		fService.insert(fVo);
		return "redirect:/";
	}
	
	@GetMapping("/allview")
	public String allview(Model model) throws Exception{
	List<FishVo> fVo = fService.allview();
	model.addAttribute("allList",fVo);
	return "allview";
	}
	
	@GetMapping("/delete/{product_no}")
	public String delete(@PathVariable("product_no") int no) throws Exception{
		fService.delete(no);
		return "redirect:/allview";
	}
	
	@GetMapping("/modify/{product_no}")
	public String modify(@PathVariable("product_no") int no,Model model) throws Exception{
		FishVo fVo=fService.modify(no);
		model.addAttribute("modiVo",fVo);
		return "modify";
	}
	
	@PostMapping("/modifySave")
	public String modify(@ModelAttribute FishVo fvo)throws Exception{
		fService.update(fvo);
		//System.out.println(fvo.getProduct_name());
		
		return "redirect:/allview";
	}
	
	//마이페이지 개발중 - 담당자 meat
	@GetMapping("/mypage")
	public String mypage() {
		
		return "mypage";
	}
	
	@GetMapping("/memberUpdate")
	public String memberUpdate() {
		
		
		return "mypage";
	}
}
