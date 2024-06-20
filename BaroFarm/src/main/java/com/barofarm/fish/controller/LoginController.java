package com.barofarm.fish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.barofarm.fish.service.IF_LoginService;
import com.barofarm.fish.vo.UserVo;

import jakarta.servlet.http.HttpSession;



@Controller
public class LoginController {

	@Autowired
	IF_LoginService logService;
	
	@GetMapping("login_main")
	// 로그인 메인
	public String loginMain() {
		return "login_main";
	}
	
	// 로그인 화면에서 회원가입 버튼 활성화 test완료
	@PostMapping("login")
	public String login(HttpSession session,
			@RequestParam ("id") String user_id, 
			@RequestParam("pw") String user_pw) throws Exception{
		// form action 으로 전달 되는 ID/PW 확인 하기 위한 작업 
		UserVo uVo=logService.login(user_id, user_pw);
		System.out.println(uVo.getUser_id()+"/"+uVo.getUser_pass());
		// 값 확인 
		
		if(uVo !=null) {
			
			if(uVo.getUser_id().equals(user_id)&&uVo.getUser_pass().equals(user_pw)) {
				// 데이터베이스 등록된 id pw가 입력한 값과 같은지 확인 하는 코드 
				// 로그인 성공 > 세션처리 > 이떄 서버는 쿠키를 만들고 세션영역을 쿠키로 구분이 가능하다. 
				// 클라이언트는 접속시 쿠키값을 서버에 전송하고 서버에서는 쿠키값을 참고하여 세션에서 등록된 변수 값을 가져온다.
				
				if(session.getAttribute("user_id")!=null) {
					// (만약 쓰레기 값이 있다면 지워버려라) // 로그인 후 세션값이 있는지 확인하는 코드 
					// id를 비교대상으로 한 이유는 primary key 니깐 하나만 존재 // 이름은 중복 가능성 있음
					session.removeAttribute("user_name");
					// 쓰레기 값을 지울 때는 "user_name" 만 지우면 될 것 같다. 왜냐하면 html에 표기할 건 이름 뿐이니
					//session.removeAttribute("user_pw");
					//"user_id"+"user_pw" > 로그인하고 html창에 표기할 값 
					
				}
				session.setAttribute("user_id", uVo.getUser_id());
				session.setAttribute("user_name",uVo.getUser_name());
				// html 창에 표시 할 user_id // user_name을 변경 한다. 로그인 한 값으로 
		
		}else {
		}	
		}else {	
		}
		return "redirect:/";
		
		
		
		
	}

}
