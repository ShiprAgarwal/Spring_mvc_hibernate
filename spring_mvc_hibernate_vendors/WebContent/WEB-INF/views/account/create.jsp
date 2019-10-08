<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sf:form method="post" modelAttribute="bankAccount">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Choose A/C Type</td>
				<td><sf:radiobutton path="type" value="SAVING" />Saving</td>
				<td><sf:radiobutton path="type" value="CURRENT" />Current</td>
				<td><sf:radiobutton path="type" value="FD" />FD</td>
				<td><sf:radiobutton path="type" value="LOAN" />Loan</td>
				<td><sf:radiobutton path="type" value="DMAT" />DMAT</td>
			</tr>
			<tr>
				<td>Initial Balance</td>
				<td><sf:input type="number" path="balance" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create A/C" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>