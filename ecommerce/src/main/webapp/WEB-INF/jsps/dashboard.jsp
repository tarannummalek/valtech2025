<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid black;
}

th, td {
	padding: 8px;
	text-align: left;
}

.success-message {
	color: green;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>Welcome ${name}!</h1>
	<c:if test="${not empty orderPlaced}">
		<div class="success-message">Order placed successfully! Thank
			you for your purchase.</div>
	</c:if>

	<h3>Available Items</h3>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Min Stock</th>
			<th>Max Stock</th>
			<th>Current Quantity</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${items}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.description}</td>
				<td>${item.reorderLevel}</td>
				<td>${item.max_quantity}</td>
				<td>${item.cur_quantity}</td>
				<td><form:form action="/dashboard" method="POST">
						<form:input path="lineOrderItems[${item.id}].quantity" value="1"
							min="1" style="width: 50px;" />
						<input type="hidden" name="lineOrderItems[${item.id}].item.id"
							value="${item.id}" />
						<input type="hidden" name="lineOrderItems[${item.id}].item.name"
							value="${item.name}" />
						<input type="submit" value="Add to Cart" />
					</form:form></td>	
			</tr>
		</c:forEach>
	</table>

	<h3>Your Cart</h3>
	<form:form action="/placeOrder" method="POST">
		<table>
			<tr>
				<th>Item</th>
				<th>Quantity</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${order.lineOrderItems}" var="lineItem">
				<tr>
					<td>${lineItem.item.name}</td>
					<td><form:input
							path="lineOrderItems[${lineItem.item.id}].quantity"
							value="${lineItem.quantity}" min="1" style="width: 50px;" /></td>
					<td>
						<button type="button" onclick="removeItem(${lineItem.item.id})">Remove</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Place Order" />
	</form:form> 

	<script>
        function removeItem(itemId) {
            alert("Removing item with ID: " + itemId);
        }
    </script>
</body>
</html>
