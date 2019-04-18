<%@page import="controllers.GetListUsers"%>
<%@page import="controllers.LogOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Espace ADMIN</title>
</head>
<body>
	<p> hello admin </p>

	<form action="ListUsers" method="GET">
	  	<input type="submit" value="Affiche Users"/>
	</form>
	
	<form action="Deconnexion" method="GET">
	  	<input type="submit" value="Log Out"/>
	</form>
</body>
</html>