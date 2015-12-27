package com.astraltear.mvcbasic1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@InitBinder
	public void initBinder(WebDataBinder binder) {
//		 아래의 설정은 해당 필드가 disable상태로 request에 전달되지 않는다. 
		binder.setDisallowedFields(new String[] {"studentHobby"});
		
//		날짜 포맷 지정 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		binder.registerCustomEditor(Date.class, "studentRegDate", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/admissionForm", method=RequestMethod.GET)
	public ModelAndView getPageForm() {
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
		return modelAndView;
	}
	
	
	@ModelAttribute
	public void addingCommonObject(Model model1) {
		model1.addAttribute("headerMessage", "ModelAttribute Common Message");
	}
	
//	모델 어트리뷰트 설정 및 메인 DTO세팅 과 메인에 종송적인 DTO 세팅방법
	@RequestMapping(value="/AdmissionOKForm", method=RequestMethod.POST)
	public String AdmissionOKForm(@ModelAttribute("student1") Student student, BindingResult result) {
		
		// bindingresult 에러 처리 방법 
		if(result.hasErrors()) {
			return "AdmissionForm";
		}
		
		return "AdmissionOK";
	}
	
}
