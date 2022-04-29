<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.top {
		margin-left: 100px;
		margin-top: 30px;
		font-size: 2em;
	}
	.sign {
		border: 1.5px solid silver;
		margin-left: 38%;
		width: 400px;
		height: 500px;
		text-align: center;
	}
	.sign h1 {
		font-size: 3em;
	}
	.sign input {
		margin: 5px;
		width: 350px;
		height: 50px;
	}

</style>
</head>

<body>
	<thead>
		<div class="top">
			<h3>instarkilogram</h3>
		</div>
	</thead>
	
	<tbody>
		<div class="sign">
			<h1><i>instarkilogram</i></h1>
			<form>
				<input type="text" name=uid value="Username"><br>
				<input type="password" name=upwd value="0000"><br>
				<input type="submit" value="로그인"><br>
				<input type="button" value="회원가입" onclick="Sign_up()">
			</form>
		</div>
	</tbody>
</body>
</html>