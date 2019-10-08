<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>

	<sf:form method="post" modelAttribute="vendor">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Enter Vendor Name</td>
				<td><sf:input path="name" /></td>
				<td><sf:errors path="name" /></td>
			</tr>
			<tr>
				<td>Enter Vendor Email</td>
				<td><sf:input type="email" path="email" /></td>
				<td><sf:errors path="email" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><sf:password path="password" /></td>
				<td><sf:errors path="password" /></td>
			</tr>
			<tr>
				<td>Enter Reg Amount</td>
				<td><sf:input type="number" path="regAmount" /></td>
				<td><sf:errors path="regAmount" /></td>
			</tr>
			<tr>
				<td>Enter Reg Date</td>
				<td><sf:input type="date" path="regDate" /></td>
				<td><sf:errors path="regDate" /></td>
			</tr>
			<tr>
				<td>Choose Role</td>
				<td><sf:radiobutton path="role" value="vendor" />Vendor</td>
				<td><sf:radiobutton path="role" value="admin" />Admin</td>
			</tr>
			<tr>
				<td><input type="submit" name="btn" value="Register Vendor" /></td>
			</tr>
		</table>
	</sf:form>



</body>
</html>