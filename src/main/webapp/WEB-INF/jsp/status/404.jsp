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
	<h3>요청하신 페이지는 존재하지 않는 페이지입니다.(404)</h3>
	
	<p>
	<a href="${pageContext.request.contextPath}">메인페이지로 이동</a>
</body>
</html>