<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>result1.jsp</h2>
  <h3>ByType 방식</h3>
  <h3>request scope 에서 객체 가져옴</h3>
  <h3>requestScope.applicationBean1.data1 : ${ requestScope.applicationBean1.data1}</h3>
  <h3>requestScope.applicationBean1.data2 : ${ requestScope.applicationBean1.data2}</h3>
  
  <h3>ByName 방식</h3>  
  <h3>application scope 에서 객체 가져옴</h3>
  <h3>applicationScope.applicationBean2.data3 : ${ applicationScope.applicationBean2.data3}</h3>
  <h3>applicationScope.applicationBean2.data4 : ${ applicationScope.applicationBean2.data4}</h3>
</body>
</html>