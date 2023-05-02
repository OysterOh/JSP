<%@page import="user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		User user = new User(
					request.getParameter("id"),
					request.getParameter("pw"),
					request.getParameter("name"),
					request.getParameter("email")				
				);
		session.setAttribute("member", user);
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_obj2</title>
</head>
<body>

	<a href="el_obj3.jsp">el로 세션 내의 객체의 값 표현</a>

</body>
</html>

