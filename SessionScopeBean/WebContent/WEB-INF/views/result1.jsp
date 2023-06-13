<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>result1 : JAVA 설정</h2>
  <h3 style="color:blue;">ByType 방식</h3>
  <h3 style="color:blue;">request scope 에서 객체 가져옴</h3>
  <h3>sessionBean1.data1 : ${ requestScope.sessionBean1.data1}</h3>
  <h3>sessionBean1.data2 : ${ requestScope.sessionBean1.data2}</h3>
  <h3 style="color:blue;">ByName 방식</h3>
  <h3 style="color:blue;">request scope 에서 객체 가져옴</h3>
  <h3>sessionBean2.data3 : ${ requestScope.sessionBean2.data3}</h3>
  <h3>sessionBean2.data4 : ${ requestScope.sessionBean2.data4}</h3>
</body>
</html>