package com.astraltear.mvcbasic1.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

//	http://localhost:8080/mvcbasic1/board/view
	@RequestMapping("/board/view")
	public String boardView() {
		return "board/view";
	}
	
//	http://localhost:8080/mvcbasic1/board/content
	@RequestMapping("/board/content")
	public String cotent(Model model) {
		model.addAttribute("id", 30);
		return "board/content";
	}
	
//	http://localhost:8080/mvcbasic1/board/reply
	@RequestMapping("/board/reply")
	public ModelAndView	reply() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", 40);
		modelAndView.setViewName("board/reply");
		
		return modelAndView;
	}

//	http://localhost:8080/mvcbasic1/board/reqParamSample?id=ABC&pw=ZZZZ
	@RequestMapping("/board/reqParamSample")
	public String reqParamSample( HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "board/reqParamSample";
	}

//	http://localhost:8080/mvcbasic1/board/reqParamAnno?id=ABC&pw=ZZZZ
	@RequestMapping("/board/reqParamAnno")
	public String reqParamAnno( @RequestParam("id") String id, @RequestParam("pw") String pw, Model model ) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "board/reqParamSample";
	}
	
//	http://localhost:8080/mvcbasic1/board/pathVar/ASTRALTEAR?pw=DARAP
	@RequestMapping("/board/pathVar/{id}")
	public String reqPathParam(@PathVariable String id,@RequestParam("pw") String pw, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "board/reqParamSample";
	}
}
