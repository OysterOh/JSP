<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="req_album_result.jsp">
		<table border="2">

			<tr>
				<th></th>
				<th>이미지</th>
				<th>이름</th>
				<th>소속</th>
				<th>최근 활동</th>
			</tr>
			<tr>
				<td><input type="radio" name="a" value="윤영철"></td>
				<td> <img alt="#" src="1.jpg"></td>
				<td>윤영철</td>
				<td>기아 타이거즈 </td>
				<td>230427 등판</td>
			</tr>
			<tr>
				<td><input type="radio" name="a" value="설윤"></td>
				<td> <img alt="#" src="2.jpg"></td>
				<td>설윤</td>
				<td>엔믹스 </td>
				<td>뭐시기 커버</td>
			</tr>
			<tr>
				<td colspan="5" align="center">
				<button>확인</button>
			</tr>
			
			
			<!-- <tr>
				<th>
				<th><input type="radio">
				<th><input type="radio">
				<th>
			</tr> -->

		</table>


	</form>
</body>
</html>