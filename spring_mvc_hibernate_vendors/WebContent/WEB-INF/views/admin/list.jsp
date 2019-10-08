<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4 align="center" style="color: green;">${requestScope.status}</h4>
	
	<h3 align="center">Vendor List</h3>
	<table style="background-color: cyan; margin: auto;" border="1">
		<c:forEach var="v" items="${requestScope.vendor_list}">
			<tr>
				<td>${v.name}</td>
				<td>${v.email}</td>
				<td><fmt:formatDate value="${v.regDate}" pattern="dd-MM-yyyy" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>