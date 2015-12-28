<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
response.setStatus(HttpServletResponse.SC_OK);
%>
<fmt:requestEncoding value="utf-8"/>
<html>
<head>
	<title>예외사항 발생</title>
</head>
<body>
	<h3>예외사항이 발생하였습니다.(500)</h3>
	${exception}
	
	<p>
	<a href="/">메인페이지로 이동</a>
</body>
</html>