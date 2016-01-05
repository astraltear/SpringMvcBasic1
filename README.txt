Spring MVC 4.2.4
log4j
Jackson
tiles3
spring security
form validation
h2 database
commons-dbcp
spring test JUNIT4
JdbcDaoSupport getJdbcTemplate
transaction
logback


tiles resolver와 jsp resolver가 혼재하므로 해당 resolver를 보려면 
servlet-context.xml을 적당히 수정하면서 해야 한다. 

<annotation-driven />
<context:component-scan base-package="com.astraltear.mvcbasic1" />

<context:component-scan base-package="com.astraltear.mvcbasic1.web" />
	<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
</context:component-scan>

<context:component-scan base-package="com.astraltear.mvcbasic1.dao" />
	<context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
</context:component-scan>


## @InitBinder
	HomeController.initBinder
	binder.registerCustomEditor

## @ModelAttribute
	HomeController
	모델 어트리뷰트 설정 및 메인 DTO세팅 과 메인에 종송적인 DTO 세팅방법

## bindingresult에러 처리 방법 
	HomeController.AdmissionOKForm
	WEB-INF\views\AdmissionOK.jsp
	<form:errors path="student1.*"/> 

## 에러페이지 설정법
	web.xml 
	<error-page>
		<error-code>404</error-code>
		<location>/WEB-INF/jsp/status/404.jsp</location>
	</error-page>

## http request logger filter 
	src\main\java\com\astraltear\mvcbasic1\filter\AccessLoggerFilter.java
	
## tiles3 setting
	pom.xml
	\WEB-INF\spring\appServlet\servlet-context.xml
	

## interceptors
	<interceptors>
		<interceptor>
			<mapping path="/paramModelAttr/**/"/>
			<beans:bean class="com.astraltear.mvcbasic1.MyRequestHandlerInterceptor"/>
		</interceptor>
	</interceptors>
	

## SimpleUrlHandlerMapping
	<beans:bean id="simpleUrlHandlerController" class="com.astraltear.mvcbasic1.SimpleUrlHandlerController"/>
		<beans:bean id="urlHandler" class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
			<beans:property name="urlMap">
			<beans:map>
				<beans:entry key="/simpleUrlControl" value-ref="simpleUrlHandlerController"></beans:entry>
			</beans:map>
		</beans:property>
	</beans:bean>	
	

## Controller 인터페이스 구현체 
	HelloWorldController.handleRequest		
	
## 다양한 requestParam 처리
	ParamHandleController
	params="fdAction=createForm"
	params= {"x=a","y=b"}
	@RequestParam(value="fixedDepositId") int id
	@RequestParam(value="optionId", required=false,defaultValue = "0") int id
	@RequestParam Map<String, String> params
	@RequestParam MultiValueMap<String, String> params
	@ExceptionHandler
	한 컨트롤러 안에서  여러 메서드에 @ModelAttribute 어노테이션을 지정할 수 있다.
        	컨트롤러의 @RequestMapping 어노테이션이 지정된 메소드로 요청이 전달되면 @RequestMapping 메소드가 호출되기 전에 해당 컨트롤러의 
        	모든 @ModelAttribute 어노테이션이 지정된 메소드가 호출된다. 	
    @RequestMapping 및  @ModelAttribute 어노테이션이 모두 지정된 경우 메소드가 반환한 값은 뷰 이름이 아니라 모델 특성으로 간주된다.
 		이 경우 뷰 이름은 들어오는 요청의 url기준으로 생성할 뷰를 결정하는 스프링의 RequestToViewNameTranslator 클래스가 결정한다.
 		아래의 뷰 이름은  views/fixedDeposit/anotherStudent.jsp 이렇게 된다. 
 		
 	@ModelAttribute("paramModelAttr") 파라미터 처리 
 	
## HttpEntity Jackson 처리 
 	HttpEntity
 	@ResponseBody
 	@ResponseStatus(value=HttpStatus.NOT_FOUND)
 	@PathVariable("id") String id, @PathVariable("name") String name
 	ResponseEntity
 	produces= {"application/json","application/xml"}
 	
 
## Spring Security
	spring security filter
	security-context.xml
	(아래의 exception발생) 
	At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
1


## database H2
	<properties>
		<entry key="database.driverClassName">org.h2.Driver</entry>
		<entry key="database.url">jdbc:h2:~/astral</entry>
		<entry key="database.username">sa</entry>
		<entry key="database.password"></entry>
	</properties>
	<context:property-placeholder location="classpath*:application-properties.xml"/>
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="${database.driverClassName}"
		p:url="${database.url}"
		p:username="${database.username}"
		p:password="${database.password}"
	 />
 
## spring test
	junit4로 jdbc 설정 테스트를 한다. 
	com.astraltear.support.ApplicationContextTest
	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(locations= {"/applicationContext.xml"})
	JdbcDaoSupport

	@PostConstruct
	public void initialize() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("user.sql"));
		DatabasePopulatorUtils.execute(populator, getDataSource());
	}
	
## transaction
		 
	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager"
	 	p:dataSource-ref="dataSource"/>
	<tx:annotation-driven transaction-manager="transactionManager"/>
	 
	@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
	@Transactional
	
## logback	
		<dependency>
			<groupId>ch.qos.logback</groupId>
			<artifactId>logback-classic</artifactId>
			<version>1.1.3</version>
		</dependency>
		src\main\resources\logback.xml