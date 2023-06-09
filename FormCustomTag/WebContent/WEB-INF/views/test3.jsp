<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- 
      Form Custom Tag 에서 input 태그의 path 속성은
      일반 input 태그의 id 속성과 name 속성 두 가지 역할을 함  
    -->
    <h2>test3.jsp</h2>
    <form:form modelAttribute="bean" action="result">        
        이  름 : <form:input path="userName"/><br>     
        아이디 : <form:input path="userId"/><br>
        비밀번호 : <form:password path="userPw" showPassword="true"/><br>
        우편번호 : <form:input path="userPostcode"/><br>
        주   소1 : <form:input path="userAddress1"/><br>
        주   소2 : <form:input path="userAddress2"/><br>    
    </form:form>
</body>
</html>






