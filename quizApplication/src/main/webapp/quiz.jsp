<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Question"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${q_name}</h3>
<h5>Maximum score:      ${maxMarks}</h5>
	<form action="quiz" method="post">
		<table>
			<c:forEach items="${questions}" var="q">
				<tr colspan='4'>
					<td>${q.question}</td>
				</tr>
				<tr>
					<td><input type="radio" name="ans1">${q.o1}</td>
					<td><input type="radio" name="ans2">${q.o2}</td>
					<td><input type="radio" name="ans3">${q.o3}</td>
					<td><input type="radio" name="ans4">${q.o4}</td>
				</tr>
				
			</c:forEach>
			<tr><td><input type="submit" name="submit_quiz" value="submit" /></td></tr>
			<tr><td><a href="quiz?operation=add">New Quiz</a></td></tr>
		</table>
		
		
	</form>
</body>
</html>