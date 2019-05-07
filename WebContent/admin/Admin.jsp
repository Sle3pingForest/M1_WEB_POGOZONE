<%@page import="controllers.GetListUsers"%>
<%@page import="controllers.LogOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/Style.css" type="text/css"/>
<title>Espace ADMIN</title>
</head>
<body>
	<p id="admin"> Hello admin </p>

	<form action="ListUsers" method="GET">
	  	<input type="submit" value="Affiche Users"/>
	</form>
		<form action="AjoutProduit" method="GET">
	  	<input type="submit" value="Ajouter Produit"/>
	</form>
	</form>
		<form action="GetListProduit" method="GET">
	  	<input type="submit" value="Liste Produit"/>
	</form>
	
	<form action="Deconnexion" method="GET">
	  	<input type="submit" value="Log Out"/>
	</form>
</body>
</html>