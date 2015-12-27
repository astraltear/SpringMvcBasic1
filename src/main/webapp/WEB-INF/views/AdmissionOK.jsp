<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Admission OK PAGE!!<br>
${headerMessage}<br>

studentName: ${student1.studentName }<br>
studentHobby: ${student1.studentHobby }<br>
studentMobile: ${student1.studentMobile }<br>
studentRegDate: ${student1.studentRegDate }<br>

studentSkills: ${student1.studentSkills }<br>

studentAddress.post: ${student1.studentAddress.post }<br>
studentAddress.country: ${student1.studentAddress.country }<br>
studentAddress.city: ${student1.studentAddress.city }<br>
studentAddress.addr1: ${student1.studentAddress.addr1 }<br>
studentAddress.addr2: ${student1.studentAddress.addr2 }<br>

</body>
</html>