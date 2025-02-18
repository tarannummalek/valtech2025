<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Welcome <%=request.getAttribute("username") %> You are registered as <%=request.getAttribute("role") %>
A=<%=request.getParameter("a") %><br/>
B=<%=request.getParameter("b") %><br/>
Operation=<%=request.getParameter("operation") %><br/>
Result=<%=request.getAttribute("result") %><br/>
<form action="arithmatic" method="post" >
A=<input type="text" name="a"> <br/>
B=<input type="text" name="b">

<input type="submit" name="operation" value="add"/>
<input type="submit" name="operation" value="sub"/>
<input type="submit" name="operation" value="mul"/>
<input type="submit" name="operation" value="div"/></form>

</body>
</html>