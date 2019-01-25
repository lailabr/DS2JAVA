<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page d'authentification</title>
<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>
<form action="Servlet" method="post">
	Login: <input type="text" name="login"><br>
	Password:<input type="password" name="password"><br>
			<input name="action" value="auth" type="submit">
</form>
</body>
</html>