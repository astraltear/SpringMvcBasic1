<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
ModelAttribute setting and master dto setting detail dto setting how to

<!-- bindingresult 에러 처리 방법 -->
<form:errors path="student1.*"/> 

<form action="${pageContext.request.contextPath}/AdmissionOKForm" method="post">
studentName: <input type="text" name="studentName"><br>
studentHobby: <input type="text" name="studentHobby"><br>
studentMobile: <input type="text" name="studentMobile"><br><br>
studentRegDate: <input type="text" name="studentRegDate"><br><br>

student skillSet:
<select name="studentSkills" multiple="multiple">
	<option value="java core">java core</option>
	<option value="spring core">spring core</option>
	<option value="spring mvc">spring mvc</option>
</select>
<br>
studentAddress.post: <input type="text" name="studentAddress.post"><br>
studentAddress.country: <input type="text" name="studentAddress.country"><br>
studentAddress.city: <input type="text" name="studentAddress.city"><br>
studentAddress.addr1: <input type="text" name="studentAddress.addr1"><br>
studentAddress.addr2: <input type="text" name="studentAddress.addr2"><br>

<br>
<input type="submit" value="send"/><br>
</form>

</body>
</html>