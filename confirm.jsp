<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新規情報登録</title>
		<link href="style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div id="main">
			<h1>新規情報登録</h1>
			<p>登録しますか？</p>
			<form action="?" method="post">
				<input type="hidden" name="email" value="${customer.email}">
				<input type="hidden" name="password" value="${customer.password}">
				<input type="hidden" name="name" value="${customer.name}">
				<input type="hidden" name="gender" value="${customer.gender}">
				<input type="hidden" name="blood" value="${customer.blood}">
				<input type="hidden" name="old" value="${customer.old}">
				<input type="hidden" name="memo" value="${customer.memo}">
				<input type="submit" value="登録" formaction="entry">
				<input type="submit" value="修正" formaction="insert.jsp">
			</form>
		</div>
	</body>
</html>