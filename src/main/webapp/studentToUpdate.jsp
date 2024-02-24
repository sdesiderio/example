<%@page import="vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Update</title>
</head>
<%StudentVO studentVO = (StudentVO)session.getAttribute("studentVO");%>
<body>
<form method="post" action="update">
	
	<input type="hidden" name="id" value="<%=studentVO.getId()%>"/><br/><br/><br/>
	<label for="FirstName">FirstName</label>
	<input type="text" name="firstname" value="<%=studentVO.getFirstName()%>"/><br/><br/><br/>
	<label for="LastName">LastName</label>
	<input type="text" name="lastname" value="<%=studentVO.getLastName()%>"/><br/><br/><br/>
	<label for="Age">Age</label>
	<input type="text" name="age" value="<%=studentVO.getAge()%>"/><br/><br/><br/>
	
	<input type="submit" value="Update">
	
</form>
</body>
</html>