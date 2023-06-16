<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>read_data.jsp</h2>
		<c:forEach var = "obj" items="${testList}">
			${obj.data1 }, ${obj.data2 }, ${obj.data3 } <br>
		</c:forEach>
</body>
</html>