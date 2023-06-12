<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>result6.jsp</h2>
	<h3>session scope에 올린 bean1(TestBean1) 객체를 가져옴</h3>
	<h3>data1 : ${sessionScope.bean1.data1 }</h3>
	<h3>data2 : ${sessionScope.bean1.data2 }</h3>
</body>
</html>