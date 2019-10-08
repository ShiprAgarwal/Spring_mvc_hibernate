<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<sf:form method="post" modelAttribute="vendor">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Vendor ID (R)</td>
				<td><sf:input  path="id" readonly="true" /></td>
			</tr>
			<tr>
				<td>Enter Vendor Name</td>
				<td><sf:input path="name" /></td>
			</tr>
			<tr>
				<td>Your Registered Email (R)</td>
				<td><sf:input type="email" path="email" readonly="true" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><sf:password path="password" showPassword="true"/></td>
			</tr>
			<tr>
				<td>Enter Reg Amount</td>
				<td><sf:input type="number" path="regAmount" /></td>
			</tr>
			<tr>
				<td>Enter Reg Date</td>
				<td><sf:input type="date" path="regDate" /></td>
			</tr>
			<tr>
				<td>Choose Role</td>
				<td><sf:radiobutton path="role" value="vendor" />Vendor</td>
				<td><sf:radiobutton path="role" value="admin" />Admin</td>

			</tr>
			<tr>
				<td><input type="submit" name="btn" value="Update Vendor" /></td>
			</tr>
		</table>
	</sf:form>



</body>
</html>