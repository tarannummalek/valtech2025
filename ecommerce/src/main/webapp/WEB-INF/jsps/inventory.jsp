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
  <input name="id" type="hidden" value="10">
  <label>Name</label><input name="name" type="text"/><br>
  <label>Description</label><input name="description" type="text" /><br>
  <label>Reorder level</label><input name="reorderLevel" type="number" /><br>
  <label>Max quantity</label><input name="max_quantity" type="number"/><br>
  <label>Current quantity</label><input name="cur_quantity" type="number"/><br>
  
  <input type="submit" name="submit">
  </form>

</body>
</html>