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
			<h1>ユーザー情報一覧</h1>
			<table border="1">
				<tr>
					<th>id</th>
					<th>email</th>
					<th>氏名</th>
					<th>性別</th>
					<th>血液型</th>
					<th>年齢</th>
					<th>詳細</th>
				</tr>
				<c:forEach var="customer" items="${customerList}">
					<tr>
						<td><c:out value="${customer.id}"/></td>
						<td><c:out value="${customer.email}"/></td>
						<td><c:out value="${customer.password}"/></td>
						<td><c:out value="${customer.name}"/></td>
						<c:if test="${customer.gender == 0}"><td>男</td></c:if>
						<c:if test="${customer.gender == 1}"><td>女</td></c:if>
						<td><c:out value="${customer.blood}"/>型</td>
						<td><c:out value="${customer.old}"/>歳</td>
						<td><c:out value="${customer.memo}"/></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>