<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!-- 여기가 에러 페이지가 맞다는 뜻 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		요청 처리 과정에서 에러가 발생했습니다.  <br>
		빠른 시간 내에 문제를 해결할게  <br>
		기다려
	</p>
	
	<p>
		에러 원인: <%=exception.getMessage() %>
	</p>
</body>
</html>