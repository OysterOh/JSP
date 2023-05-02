<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_basic</title>
</head>
<body>

	<% int i = 5; %>
	<p>
		<%= 10*8 %> <br>  <!-- out.print(10*8); -->
		<%= 5.55 + 3 %> <br>
		<%= "안녕" %>	  <br>
		<%= i %>
	</p>
	
	<hr>
	
	<%-- el은 브라우저에 특정 값을 표현하기 위한 언어이다.
		 el을 통해 데이터를 표현할 때, 스크립틀릿으로 작성한 변수의 값은
		 el로 가지고 올 수 없다. el이 접근하는 범위는 jsp 내장 객체 범위이다.
		 (request, session..) --%>
	
	
	<p>
		${10 * 4 } <br>
		${5.55 + 3 } <br>
		${'HI' } <br>
		${i }
	</p>
	
</body>
</html>