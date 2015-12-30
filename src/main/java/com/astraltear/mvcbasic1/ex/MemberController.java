package com.astraltear.mvcbasic1.ex;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

//	http://localhost:8080/mvcbasic1/member/join?name=aaa&id=bdere&pw=2345522&email=terwerwer
	@RequestMapping("/join")
	public String join(MemberDTO memberDTO) {
		return "member/join";
	}
	
//	http://localhost:8080/mvcbasic1/member/join2?name=aaa&id=bdere&pw=2345522&email=terwerwer
	@RequestMapping("/join2")
	public String join2(@ModelAttribute("m") MemberDTO memberDTO) {
		return "member/join2";
	}
	
//	http://localhost:8080/mvcbasic1/member
	@RequestMapping("")
	public String redirect() {
		return "redirect:/member/sampleRedirect";
	}
	
	@RequestMapping("/sampleRedirect")
	public String recvRedirect() {
		return "redirectsample/sample";
	}
	
//	http://localhost:8080/mvcbasic1/member/validChk?name=aaa&id=bdere&pw=2345522&email=terwerwer	
	@RequestMapping("/validChk")
	public String validateCheck(@ModelAttribute("mem") MemberDTO memberDTO, BindingResult result ) {
		String pageName="/member/validOK";
		
		MemberValidator validator = new MemberValidator();
		validator.validate(memberDTO, result);
		
		if (result.hasErrors()) {
			pageName="/member/validError";
		}
		
		return pageName;
	}
}
