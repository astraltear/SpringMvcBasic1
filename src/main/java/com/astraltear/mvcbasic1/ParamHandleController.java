package com.astraltear.mvcbasic1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamHandleController {
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(ParamHandleController.class);
	
//	http://localhost:8080/mvcbasic1/paramhandle
	@RequestMapping("/paramhandle")
	public String index( HttpServletRequest request, Model model) {
		
		logger.info("index!!");
		setModel(request, model,"index");
		return "paramHandleTest";
	}
	
//	http://localhost:8080/mvcbasic1/paramhandle?fdAction=createForm
	@RequestMapping(value="/paramhandle", params="fdAction=createForm",method=RequestMethod.GET)
	public String paramHandler1(HttpServletRequest request, Model model) {
		
		logger.info("paramHandler1!!");
		setModel(request, model,"paramHandler1");
		return "paramHandleTest";
	}

//	http://localhost:8080/mvcbasic1/paramhandle?x=a&y=b
	@RequestMapping(value="/paramhandle", params= {"x=a","y=b"}, method=RequestMethod.GET)
	public String paramHandler2(HttpServletRequest request, Model model) {

		logger.info("paramHandler2!!");
		setModel(request, model,"paramHandler2");
		return "paramHandleTest";
	}
	
//	http://localhost:8080/mvcbasic1/requestParam?fixedDepositId=3
	@RequestMapping(value="/requestParam" , method=RequestMethod.GET)
	public String paramHandler3(HttpServletRequest request, Model model,@RequestParam(value="fixedDepositId") int id) {
		
		logger.info("paramHandler3 id:"+id);
		setModel(request, model,"paramHandler3");
		return "paramHandleTest";
	}

//	http://localhost:8080/mvcbasic1/requestParamOption?optionId=3&name=TItle
//	http://localhost:8080/mvcbasic1/requestParamOption
//	required false이면 파라미터가 없어도 처리가 되나 null을 리턴한다. 이때 받는 변수가 int이면 null이 들어갈 수 없으면 Exception이 발생한다. 
	@RequestMapping(value="/requestParamOption", method=RequestMethod.GET)
	public String paramHandler4(HttpServletRequest request, Model model, 
			@RequestParam(value="optionId", required=false,defaultValue = "0") int id,
			@RequestParam(value="name", required=false) String name) {
		
		logger.info("paramHandler4 id["+id+"]name["+name+"]");
		setModel(request, model,"paramHandler4");
		return "paramHandleTest";
	}
	
//	http://localhost:8080/mvcbasic1/requestParamMap
//	http://localhost:8080/mvcbasic1/requestParamMap?title=abc&name=fer
	@RequestMapping(value="/requestParamMap", method=RequestMethod.GET)
	public String paramHandler5(HttpServletRequest request, Model model,
			@RequestParam Map<String, String> params) {
		
		logger.info("paramHandler5 title["+params.get("title")+"]name["+params.get("name")+"]");
		setModel(request, model,"paramHandler5");
		return "paramHandleTest";
	}
	
//	http://localhost:8080/mvcbasic1/requestMultiValueMap?title=abc&title=bbb&title=c
//	MultiValueMap의 형식은 키는 K 형식이고 값은 List 형식이다
	@RequestMapping(value="/requestMultiValueMap", method=RequestMethod.GET)
	public String paramHandle6(HttpServletRequest request, Model model,
			@RequestParam MultiValueMap<String, String> params) {
		logger.info("paramHandle6 title["+params.get("title").size()+"]name["+params.get("title").get(0)+"]");
		setModel(request, model,"paramHandle6");
		return "paramHandleTest";
	}

//	http://localhost:8080/mvcbasic1/occurException
//	아래의 @ExceptionHandler가 없으면 web.xml에 정의해 놓은 505로 호출되고 
//	@ExceptionHandler를 정의해 놓으면 해당 메소드가 호출된다. 
	@RequestMapping(value="/occurException")
	public String paramHandle7(HttpServletRequest request, Model model) {
		logger.info("paramHandle7");
		
		int a = 5/0;
		
		setModel(request, model,"paramHandle7");
		return "paramHandleTest";
	}
	
	@ExceptionHandler
	public String handleException1(HttpServletRequest request, Model model,Exception e) {
		logger.info("handleException1:"+e.getMessage());
		setModel(request, model,"handleException1");
		return "exceptionHandle";
	}
	
	@ExceptionHandler(value={IOException.class, FileNotFoundException.class})
	public String exception2() {
		return "exceptionHandle";
	}
	

	private void setModel(HttpServletRequest request, Model model, String pageName) {
		String uri = StringUtils.defaultIfEmpty(request.getRequestURI(), "");
		model.addAttribute("uri", uri);
		model.addAttribute("pageName", pageName);
	}
	
/* 
 * 한 컨트롤러 안에서  여러 메서드에 @ModelAttribute 어노테이션을 지정할 수 있다.
 * 컨트롤러의 @RequestMapping 어노테이션이 지정된 메소드로 요청이 전달되면 @RequestMapping 메소드가 호출되기 전에 해당 컨트롤러의 모든 @ModelAttribute 어노테이션이 지정된 메소드가 호출된다. 
 */
	@ModelAttribute(value="studentModelAttr")
	public Student getModelAttr() {
		logger.info("getModelAttr  CALL!!:");
		Student student = new Student();
		student.setStudentName("ASTRALTEAR");
		student.setStudentHobby("CYCLE");
		student.setStudentMobile(new Long(987654));
		return student;
	}
	
//	http://localhost:8080/mvcbasic1/showStudentModelAttr
	@RequestMapping(value="/showStudentModelAttr")
	public String showModelAttr() {
		logger.info("showModelAttr  CALL!!:");
		return "showStudent";
	}
	

/*
 *  @RequestMapping 및  @ModelAttribute 어노테이션이 모두 지정된 경우 메소드가 반환한 값은 뷰 이름이 아니라 모델 특성으로 간주된다.
 *  이 경우 뷰 이름은 들어오는 요청의 url기준으로 생성할 뷰를 결정하는 스프링의 RequestToViewNameTranslator 클래스가 결정한다.
 *  아래의 뷰 이름은  views/fixedDeposit/anotherStudent.jsp 이렇게 된다. 
 */
	
//	http://localhost:8080/mvcbasic1/anotherStudent
	@RequestMapping("/anotherStudent")
	@ModelAttribute("anotherDepositDetail")
	public Student getAnotherModelAttr() {
		logger.info("getAnotherModelAttr  CALL!!:");
		Student student = new Student();
		student.setStudentName("ANOTHER DARAP");
		student.setStudentHobby("DRINK");
		student.setStudentMobile(new Long(1234567));
		return student;
	}
	
}
