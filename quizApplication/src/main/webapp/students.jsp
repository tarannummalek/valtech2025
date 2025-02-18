
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Student"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><table>
<c:forEach items="${students}" var="s">
<tr>
<td>${s.id}</td>
<td>${s.name}</td>
<td>${s.birthDate}</td>

</tr>

</c:forEach></table>
</body>
</html>