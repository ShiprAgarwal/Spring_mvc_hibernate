<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4 align="center">${requestScope.status}</h4>
	<h4>Hello , ${sessionScope.vendor_dtls.name}</h4>
	<h3 align="center">Your A/C Summary</h3>
	<table style="background-color: cyan; margin: auto;" border="1">
		<c:forEach var="a" items="${sessionScope.vendor_dtls.accounts}">
			<tr>
				<td>${a.acctId}</td>
				<td>${a.type}</td>
				<td>${a.balance}</td>
				<td><a
					href="<spring:url value='/account/close?acct_id=${a.acctId}'/>">Close
						Bank A/C</a></td>
			</tr>
		</c:forEach>
	</table>
	<h4 align="center">
		<a href="<spring:url value='/account/create'/>">Create Bank A/C</a>
	</h4>
	<h5>
		<a href="<spring:url value='/user/logout'/>">Log Out</a>
	</h5>

</body>
</html>