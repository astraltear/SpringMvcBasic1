<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>validError</title>
</head>
<body>


<form:form commandName="mem">
	이름:<form:input type="text" path="name" value="${mem.name }"/><form:errors path="name" />		<br>
	아이디:<form:input type="text" path="id" value="${mem.id }"/><form:errors path="id" />		<br>
	<input type="submit"> 
	
</form:form>

</body>
</html>