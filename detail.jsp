<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>マイページ</title>
		<link href="style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div id="main">
			<h1>詳細画面</h1>
			<c:forEach var="customer" items="${customerList}">
				<form action="?" method="post">
					<label for="email">Email</label>
					<input type="text" id="email" name="email" value="${customer.email}">
					<label for="password">Password</label>
					<input type="text" id="password" name="password" value="${customer.password}">
					<label for="email">氏名</label>
					<input type="text" id="name" name="name" value="${customer.name}">
					<label for="gender">性別</label>
					<input type="radio" name="gender" value=0 <c:if test="${customer.gender == 0}">checked</c:if>/>男
					<input type="radio" name="gender" value=1 <c:if test="${customer.gender == 1}">checked</c:if>/>女
					<label for="blood">血液型</label>
					<select name="blood">
						<option value="A"<c:if test="${customer.blood.equals('A')}">selected</c:if>>A型</option>
						<option value="B"<c:if test="${customer.blood.equals('B')}">selected</c:if>>B型</option>
						<option value="O"<c:if test="${customer.blood.equals('O')}">selected</c:if>>O型</option>
						<option value="AB"<c:if test="${customer.blood.equals('AB')}">selected</c:if>>AB型</option>
					</select>
					<label for="old">年齢</label>
					<input type="text" id="old" name="old" value="${customer.old}">
					<label for="memo">メモ</label>
					<textarea name="memo" rows="4" cols="41" maxlength="100">${customer.memo}</textarea>
					<input type="hidden" name="id" value="${customer.id}">
					<input type="submit" value="更新" formaction="update">
					<input type="submit" value="削除" formaction="delete">
				</form>
			</c:forEach>
		</div>
	</body>
</html>