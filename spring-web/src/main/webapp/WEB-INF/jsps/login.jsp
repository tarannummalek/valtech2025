<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="">
		<table>
		<tr><td >${message}</td></tr>
			<tr>
				<td>Username</td>
				<td><input name="username" type="text"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input name="password" type="password"/></td>
			</tr>
			<tr>
			<td><input name="action" value="Login" type="submit"/> </td>
			<td><input name="action" value="Cancel" type="submit"/> </td>
			</tr>
			
			

		</table>


	</form>
	Login here...

</body>
</html>