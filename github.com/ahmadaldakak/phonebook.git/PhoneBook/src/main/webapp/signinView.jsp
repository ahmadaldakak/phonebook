<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/api/signIn" method="post">
email : <input name="email" , type="email">
password: <input name="password", type="password">
<input type="submit" , value="Sign In">
</form>
</body>
</html>