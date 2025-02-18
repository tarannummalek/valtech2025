<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="depts" method="post">
<table>
<tr>
<td>Id</td>
<td><input type="text" 
	<c:if test="${check == 1}">readonly=readonly</c:if>
  name="id" value="${dept.id}"/></td>
</tr>
<tr>
<td>Name</td>
<td><input type="text" name="name" value="${dept.name}"/></td>
</tr>
<tr>
<td>Location</td>
<td><input type="text" name="location" value="${dept.location}"/></td>
</tr>
<tr>

<tr>
<td colspan="2">

<input type="submit" name="operation" value="${mode}"/>
<input type="submit" name="operation" value="Cancel"/>
</td>
</tr>
</table>
</form>
</body>
</html>