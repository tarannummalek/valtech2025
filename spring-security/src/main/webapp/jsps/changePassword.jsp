<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="changePassword" method="post">

<table>
		<tr>
				<td>Current Password:</td>
				<td><input type="password" name="currPassword"></td>
			</tr>
			<tr>
				<td>New Password:</td>
				<td><input type="password" name="newPassword"></td>
			</tr>
			<tr>
				<td>Retype Password:</td>
				<td><input type="password" name="confirmPassword"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="Change password" name="changePassword"></td>
			</tr>
		</table>
</form>



</body>
</html>