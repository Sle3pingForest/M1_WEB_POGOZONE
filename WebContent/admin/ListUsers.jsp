<%@page import="controllers.Inscription"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des utilisateur</title>
</head>
<body>

	<form  method="POST" action ="SupprimerUser">
	<c:forEach var="type" items="${listename}" >
		ID:  ${type.key}
   		Name: ${type.value}
        <input type="submit" id="${type.key}" name="${type.key}" value="Supprimer"">
	</c:forEach>
    </form>
</body>
</html>