<%@page import="dto.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Completed</title>
</head>


<% 

StudentDTO studentDTO = (StudentDTO)session.getAttribute("studentDTO"); 
String lastName = studentDTO.getLastName();
String message = "Strudent Registration " + lastName + " corrected";

%>
<body>

<%=message%>

</body>
</html>