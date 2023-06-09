<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>test1.jsp</h2>
    <form:form modelAttribute="beanData" action="result" method="get">
        <form:hidden path="data1" />
        <form:button > 전송1 </form:button>
        <form:button disabled="true"> 전송2 </form:button>
    </form:form>
</body>
</html>






