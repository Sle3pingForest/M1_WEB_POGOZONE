<%@page import="controllers.ProfileServlet"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/Style.css" type="text/css"/>
<title>Liste des utilisateurs</title>
</head>
<body>

		<c:forEach var="type" items="${listename}">
		
		<form method="POST" action="SupprimerUser">
				ID : <input type="text" name="idUser" value="${type.value}" size="5" readOnly="true"/>
		        Name: <input type="text" name="nameUser" value="${type.key}" />
				<input type="submit" id ="sup" name="Supprimer" value="Supprimer" />
				<input type="submit" id="modif" name="Modifier" value="Modifier" />
				<input type="submit" id="admin" name="Admin" value="SetAdmin" />
				<br>
.		</form>

	</c:forEach>
		<form action="Profile" method="GET">
	  		<input type="submit" value="Profile"/>
		</form>

</body>


</body>
</html>
