<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자 리스트</h2>
	<table>
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Gender</td>
			<td>City</td>
		</tr>
		<c:forEach var="user" items="${userList}">
		<tr>
			<td>${user.userId}</td>
			<td>${user.name}</td>
			<td>${user.gender}</td>
			<td>${user.city}</td>	
		</tr>	
		</c:forEach>
	</table>
</body>
</html>