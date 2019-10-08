<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<h3 align="center">${requestScope.status}</h3>
<table style="background-color: cyan; margin: auto;" border="1">
	<c:forEach var="v" items="${requestScope.vendor_list}">
		<tr>
			<td>${v.name}</td>
			<td>${v.email}</td>
			<td>${v.regAmount}</td>
			<td><fmt:formatDate value="${v.regDate}" pattern="dd/MM/yyyy" />
			</td>
			<td><a href="<spring:url value='/vendor/update?vid=${v.id}'/>">Update</a></td>
			<td><a href="<spring:url value='/vendor/delete?vid=${v.id}'/>">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<h4 align="center">
	<a href="<spring:url value='/vendor/register'/>">Add New Vendor</a>
</h4>
<h5>
	<a href="<spring:url value='/user/logout'/>">Log Out</a>
</h5>

<body>

</body>
</html>