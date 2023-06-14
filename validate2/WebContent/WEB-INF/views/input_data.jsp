<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
--%>

<!-- Spring Form Custom Tag -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>input_data.jsp</h2>
	<form:form action="input_result" modelAttribute="testBean1" method="post">
		data1 : <form:input path="data1" type="text" /><br>
			    <form:errors path="data1" /><br>
		data2 : <form:input path="data2" type="text" /><br>
		 	    <form:errors path="data2" /><br>
		<form:button type="submit">전송</form:button>	
	</form:form>
</body>
</html>

<%-- 	
<form action="input_result" method="post">
		data1 : <input type="text" name="data1" /><br>
			<spring:hasBindErrors name="testBean1">
				<c:if test="${errors.hasFieldErrors('data1') }">
					<spring:message code="${errors.getFieldError('data1').codes[0] }" /><br>
				</c:if>
			</spring:hasBindErrors>	
		data2 : <input type="text" name="data2" /><br>
		<!-- name="testBean1" : requestScope 에 올라간 객체의 이름을 지정함 -->
			<spring:hasBindErrors name="testBean1">
				<c:if test="${errors.hasFieldErrors('data2') }">
					<spring:message code="${errors.getFieldError('data2').codes[0] }" /><br>
				</c:if>	
			</spring:hasBindErrors>	
		<button type="submit">전 송</button>
</form> 
--%>
