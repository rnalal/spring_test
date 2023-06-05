<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<!-- get 방식으로 이동하면서 data 전달하기  -->
	<a href='test1?number1=100&number2=200&numbers=300&numbers=400'>test1 get</a>
	<hr>
	<form action="test2" method="post">
		number1 : <input type="text" name="number1" /><br>
		number2 : <input type="text" name="number2" /><br>
		numbers : <input type="checkbox" name="numbers" value="100">100
				  <input type="checkbox" name="numbers" value="200">200<br>
		<button type="submit">test2 post</button>
	</form>
	<hr>
	<a href='test3?number1=100&number2=200&numbers=300&numbers=400'>test3 get</a>
	<hr>
	<a href='test4/111/222/333'>test4</a>
	<hr>
	<a href='test5/111/222/333/444'>test5</a>
	<hr>
	<a href="test6?num1=11&num2=22&nums=33&nums=44">test6</a>
	<hr>
	<a href="test7?num1=11&num2=22&nums=33&nums=44">test7</a>
	<hr>
	<a href="test8?num1=11&num2=22&nums=33&nums=44">test8</a>
	<hr>
	<a href="test9?num1=11&num2=22&nums=33&nums=44">test9</a>
	<hr>
	<a href="test10?num1=11&num2=22&nums=33&nums=44">test10</a>
	<hr>
	<a href="test11?num1=11&num2=22&nums=33&nums=44">test11</a>
</body>
</html>