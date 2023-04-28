<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<%	
		String value = request.getParameter("a"); 
	%>
	
	선택한 인물 정보 
	<hr>
	당신이 선택하신 인물은 <strong><%=value %></strong>입니다.
	<hr>
	관련 영상	 <br> <br> <br>
	<% if(value.equals("윤영철")){%>
	<iframe width="955" height="430" src="https://www.youtube.com/embed/39cpPsYHYMw" title="&#39;4이닝 7K 무실점&#39; 윤영철 시범경기 하이라이트(vs 키움히어로즈)" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
	<%} else { %>
	<iframe width="805" height="654" src="https://www.youtube.com/embed/q0F0hrpHxdo" title="[안방1열 직캠4K] 엔믹스 설윤 &#39;Love Me Like This&#39; (NMIXX SULLYOON FanCam) @SBS Inkigayo 230402" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
	<%} %>
</body>
</html>