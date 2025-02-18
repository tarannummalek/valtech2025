<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="quiz" method="post">
<table>
<tr>
<td>Id</td>
<td><input type="text" 
	<c:if test="${check == 1}">readonly=readonly</c:if>
  name="id" value="${quiz.id}"/></td>
</tr>
<tr>
<td>Name</td>
<td><input type="text" name="name" value="${quiz.name}"/></td>
</tr>
<tr>
<td>Location</td>
<td><input type="text" name="result" value="${quiz.result}"/></td>
</tr>
<tr>
<td></td>
</tr>
 <c:foreach item="questions" value="${questions}">

        <c:foreach item="question" value="${question}">
            <tr>
                <td><input type="checkbox" name="${part.no}"></td>
                <td>${question.que}</td>
                <td>${question.o1}</td>
                <td>${question.o2}</td>
                <td>${question.o3}</td>
                <td>${question.o4}</td>
                <td>${question.ans}</td>
                <td>${part.discription}</td>
            </tr>
         </c:foreach>   
        </c:foreach>
        
        <input type="submit" value="Submit">
   

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