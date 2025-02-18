<%@page import="dao.Dept"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<table>
		<tr colspan="2">
		<td>
			<form action="depts" method="post">
	
			<tr>
				<td onclick="clickHere()"> Id</td>
				<td >${dept.id}</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>${dept.name}</td>
			</tr>
			<tr>
				<td>Location</td>
				<td>${dept.location}</td>
			</tr>
			<tr>
				<td>
				<input type="hidden" name="id" /> 
				<input
				type="submit" name="operation" value="First" /> <input
				type="submit" name="operation" value="Previous" /> <input
				type="submit" name="operation" value="Next" /> <input type="submit"
				name="operation" value="Last" /> <a href="depts?operation=Add">New
					Department</a></td>
			</tr>
			
		<!-- 	<tr>
				<td><input type="text" name="search" value="sal" /> <input
				type="text" name="search" value="age" /> <input
				type="text" name="search" value="exp" /> 
				 <input type="submit"
				name="text" value="name" /> <a href="depts?operation=search?type=">New
					Department</a></td>
			</tr> -->

		
	</form></td>
	<td>
	<form action="depts?operation=search" method="post"><table>
	<tr>
			<td> Name:<input type="text" name="search_name" /></td></tr>
	     <tr>		<td>Id:<input type="text" name="search_id" /></td></tr>
	    <tr>        <td>Salary:<input type="text" name="search_sal" /></td></tr>
		<tr>	<td> Age: <input type="text" name="search_age" /></td></tr>
		<tr>	<td> Gender<input type="text" name="search_gender"/></td></tr>
		<tr>	<td> Experience<input type="text" name="search_exp" /></td></tr>
		<tr>	<td> Level<input type="text" name="search_level"/></td></tr>
		<tr>	<td><input type="submit" value="search" name="search_submit"/></td></tr>
				    <tr>  <td>Salary >:<input type="text" name="search_sal_g" /></td></tr>
				    <tr><td>Salary < :<input type="text" name="search_sal_l" /></td></tr>
				    <tr>	<td> Age >: <input type="text" name="search_age_g" /></td></tr>
					<tr>	<td> Age <: <input type="text" name="search_age_l" /></td></tr>
			</table>
	
	</form></td></tr>
	</table>
	

	<table>
		<tr>
		
		<th>Id<a href="depts?operation=sort&&attr=id&&sort_type=asc">asc</a> <a href="depts?operation=sort&&attr=id&&sort_type=desc">desc</a></th>
			<th>Name<a href="depts?operation=sort&&attr=name&&sort_type=asc">asc</a> <a href="depts?operation=sort&&?attr=name&&sort_type=desc">desc</a></th>
			<th>Age<a href="depts?operation=sort&&attr=age&&sort_type=asc">asc</a> <a href="depts?operation=sort&&attr=age&&sort_type=desc">desc</a></th>
			<th>Gender<a href="depts?operation=sort&&attr=gender&&sort_type=asc">asc</a> <a href="depts?operation=sort&&attr=gender&&sort_type=desc">desc</a></th>
			<th>Salary<a href="depts?operation=sort&&attr=sal&&sort_type=asc">asc</a> <a href="depts?operation=sort&&attr=sal&&sort_type=desc">desc</a></th>
			<th>Experience<a href="depts?operation=sort&&attr=exp&&sort_type=asc">asc</a> <a href="depts?operation=sort&&attr=exp&&sort_type=desc">desc</a></th>
			<th>Level<a href="depts?operation=sort&&attr=level&&sort_type=asc">asc</a> <a href="depts?operation=sor&&attr=level&&sort_type=desc">desc</a></th>
		</tr>
		 <c:forEach items="${emps}" var="e">
			<tr>
				
				<td>${e.id}</td>
				<td>${e.name}</td>
				<td>${e.age}</td>
				<td>${e.gender}</td>
				<td>${e.salary}</td>
				<td>${e.exp}</td>
				<td>${e.level}</td>
				

			</tr>
		</c:forEach>


	</table>
	
	
</body>
<script type="text/javascript">
var listCount = 0;
function clickHere(){
	console.log("Hello World");	
}

</script>
</html>