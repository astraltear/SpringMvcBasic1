<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<html>
<head>
	<title>CUST INFORMATION</title>
	<link rel="stylesheet" type="text/css" href="<%= application.getContextPath()%>/css/tables.css">
	<script type="text/javascript" src="<%= application.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/angular.min.js"></script>

</head>
<body>
<table border='1' width="1000" height="50">
<tr>
<td>
<t:insertAttribute name="header"/>
</td>
</tr>
</table>
<table border='1' width="1000" height="300">
<col width="200"/><col width="700"/>
<tr align="left" valign="top">
<td align="left" valign="top">
<t:insertAttribute name="menu"/>
</td>
<td align="left" valign="top"><t:insertAttribute name="content"/></td>
</tr>
</table>
<table border='1' width="1000" height="50">
<tr>
<td>
<t:insertAttribute name="footer"/>
</td>
</tr>
</table>
</body>
</html>