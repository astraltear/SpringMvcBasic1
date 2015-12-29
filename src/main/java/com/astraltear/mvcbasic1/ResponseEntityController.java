package com.astraltear.mvcbasic1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/responseEntity")
public class ResponseEntityController {
	private static Logger logger = LoggerFactory.getLogger(ResponseEntityController.class);
	
//	http://localhost:8080/mvcbasic1/responseEntity/getString
	@RequestMapping(value="/getString", method=RequestMethod.GET)
	public HttpEntity<String> getString(){
		logger.info("getString method call!!");
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("userDefine", "user define value");
		return new HttpEntity<String>("Hello World HttpEntity",headers);
	}
	
//	http://localhost:8080/mvcbasic1/responseEntity?id=444
	@RequestMapping(params="id", method=RequestMethod.GET)
	public HttpEntity<String> getId(@RequestParam("id") int id){
		logger.info("getId method call!!!! ");
		return new HttpEntity<String>("getID:"+id);
	}
	
//	http://localhost:8080/mvcbasic1/responseEntity/getUsrIdReturn
	@RequestMapping("/getUsrIdReturn")
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public void getUsrIdReturn() {
		logger.info("getUsrIdReturn call!!!! ");
	}
	
//	http://localhost:8080/mvcbasic1/responseEntity/getPathVariable/ASTRALTEAR/test/DARAP/test2
	@RequestMapping(value="/getPathVariable/{id}/test/{name}/test2", method=RequestMethod.GET)
	@ResponseBody
	public HttpEntity<String> getPathVariable(@PathVariable("id") String id, @PathVariable("name") String name){
		logger.info("getPathVariable call!!!! ");
		return new HttpEntity<String>("getPathVar id["+id+"]name["+name+"]");
	}

//	jackson 관련 dependency가 필요함 
//	http://localhost:8080/mvcbasic1/responseEntity/getPathVariableJackson/ASTRALTEAR/test/DARAP/test2
	@RequestMapping(value="/getPathVariableJackson/{id}/test/{name}/test2", method=RequestMethod.GET)
	public HttpEntity<Map<String,String>> getPathVariableJackson(@PathVariable Map<String, String> pathVars){
		logger.info("getPathVariableJackson id ["+pathVars.get("id")+"]name["+pathVars.get("name")+"]");
		return new HttpEntity<Map<String,String>>(pathVars);
	}

//	jackson 관련 dependency가 필요함 
//	http://localhost:8080/mvcbasic1/responseEntity/getStudentList
	@RequestMapping(value="getStudentList", method=RequestMethod.GET, produces= {"application/json","application/xml"})
	public ResponseEntity<List<Student>> getJacksonList(){
		logger.info("ResponseEntity call!!!! ");
		List list = new ArrayList<Student>();
		
		for (int i = 0; i < 10; i++) {
			Student student = new Student();
			student.setStudentName(i+" girl friend");
			student.setStudentHobby(i+" take picture");
			list.add(student);
			
		}
		
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}
}
