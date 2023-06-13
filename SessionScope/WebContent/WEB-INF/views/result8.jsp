<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>result8.jsp</h2>
  <h3>session scope 에서 sessionBean2(TestBean2) 객체 가져옴</h3>  
  <h3>requestScope.data3 : ${sessionBean2.data3 }</h3>
  <h3>requestScope.data4 : ${sessionBean2.data4 }</h3>
  <h3>requestScope.data3 : ${requestScope.sessionBean2.data3 }</h3>
  <h3>requestScope.data4 : ${requestScope.sessionBean2.data4 }</h3>
  <h3>sessionBean2.data3 : ${sessionScope.sessionBean2.data3 }</h3>
  <h3>sessionBean2.data4 : ${sessionScope.sessionBean2.data4 }</h3>
</body>
</html>