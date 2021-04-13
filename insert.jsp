<%@ page contentType="text/html; charset=UTF-8"%>
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
			<p>登録情報を入力して下さい</p>
			<form action="insert" method="post">
				<label for="email">Email</label>
				<input type="text" id="email" name="email">
				<label for="email">Password</label>
				<input type="text" id="password" name="password">
				<label for="name">氏名</label>
				<input type="text" id="name" name="name">
				<label for="gender">性別</label>
				<input type="radio" name="gender" value="0" checked=checked>男
				<input type="radio" name="gender" value="1">女
				<label for="blood">血液型</label>
				<select name="blood">
					<option value="A">A型</option>
					<option value="B">B型</option>
					<option value="O">O型</option>
					<option value="AB">AB型</option>
				</select>
				<label for="old">年齢</label>
				<input type="text" id="old" name="old">
				<label for="memo">メモ</label>
				<input type="text" id="memo" name="memo">
				<input type="submit" value="確認">
			</form>
		</div>
	</body>
</html>