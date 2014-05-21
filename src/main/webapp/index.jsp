<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>

	<h1>Please enter your registration data.</h1>

	<form name="commitData" action="registration" method="post">

		Username: <input name="username" type="text">
		<br/>
		Password: <input name="password" type="text">
		<br/>
		
		Gender:
		<br/>
		<input name="gender" type="radio" checked="checked" value="male"/>Male <br/>
		<input name="gender" type="radio" value="female"/>Female <br/>
		
		</form>
</body>
</html>