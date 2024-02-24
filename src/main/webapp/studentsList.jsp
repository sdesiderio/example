<%@page import="vo.StudentVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students List</title>
</head>
<%ArrayList<StudentVO> students = (ArrayList<StudentVO>)session.getAttribute("students"); %>
<body>
<table>
        <tr>
            <th>FirstName</th>
            <th>LastName</th>
            <th>Age</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td style="text-align: center">${student.firstName}</td>
                <td style="text-align: center">${student.lastName}</td>
                <td style="text-align: center">${student.age}</td>
                <td style="text-align: center"><c:url value="toUpdate" var="updateUrl">
                    <c:param name="id" value="${student.id}" />
                    </c:url> <a href="${updateUrl}">update</a></td>
                <td style="text-align: center"><c:url value="delete"
                        var="deleteUrl">
                        <c:param name="id" value="${student.id}" />
                    </c:url> <a href="${deleteUrl}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br />
    <a href="home.html">home</a>

</body>
</html>