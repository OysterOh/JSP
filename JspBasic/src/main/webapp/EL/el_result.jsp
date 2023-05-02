<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_result</title>
</head>
<body>

	<p>
		# data1: <%= session.getAttribute("data1") %> <br>
		# data2: <%= application.getAttribute("data2") %>	<br>
		
	</p>

	<hr>
	
	<!--
		- EL에서 데이터를 참조할 때 영역을 명시하지 않는다면
		page -> request -> session -> application
		순서대로 검색하여 찾아내 표현한다.
		- 만약 서로 다른 내장 객체에 같은 이름의 데이터가 존재하는 경우
		내장 객체명 Scope.데이터이름 -> 특정 영역을 지목해서 가져올 수 있다.
	 -->
	
	
	<!----><!----><!----><!----><!----><!----><!--  -->
	<!----><p>								  	<!---->
	<!---->	# data1: ${data1 } <br>			  	<!---->
	<!---->	# data2: ${applicationScope.data2}  <!---->
	<!----></p>								  	<!---->
	<!----><!----><!----><!----><!----><!----><!--  -->
</body>
</html>