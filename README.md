Spring MVC 4.2.4
log4j

<annotation-driven />
<context:component-scan base-package="com.astraltear.mvcbasic1" />

@InitBinder
	HomeController.initBinder
	binder.registerCustomEditor

@ModelAttribute
	HomeController
	모델 어트리뷰트 설정 및 메인 DTO세팅 과 메인에 종송적인 DTO 세팅방법

bindingresult 에러 처리 방법 
	HomeController.AdmissionOKForm
	WEB-INF\views\AdmissionOK.jsp
	<form:errors path="student1.*"/> 

에러페이지 설정법
	web.xml 
	<error-page>
		<error-code>404</error-code>
		<location>/WEB-INF/jsp/status/404.jsp</location>
	</error-page>

http request logger filter 
	src\main\java\com\astraltear\mvcbasic1\filter\AccessLoggerFilter.java
	
tiles3 사용하기 
	pom.xml
	\WEB-INF\spring\appServlet\servlet-context.xml
	
	