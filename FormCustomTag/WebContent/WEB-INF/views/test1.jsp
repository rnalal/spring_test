<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>test1.jsp</h2>
    <form action='result' method='post'>
        이  름 : <input type='text' name='userName' value="${requestScope.userInfoBean.userName}"><br>
        아이디 : <input type='text' name='userId' value="${requestScope.userInfoBean.userId}"><br>
        비밀번호 : <input type='password' name='userPw' value="${requestScope.userInfoBean.userPw}"><br>
        우편번호 : <input type='text' name='userPostcode' value="${requestScope.userInfoBean.userPostcode}"><br>
        주 소1 : <input type='text' name='userAddress1' value="${requestScope.userInfoBean.userAddress1}"><br>
        주 소2 : <input type='text' name='userAddress2' value="${requestScope.userInfoBean.userAddress2}"><br><br>
        <button type='submit'> 전송 </button>    
    </form>
    
</body>
</html>


