<%@page import="controllers.ProfileServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/Style.css" type="text/css"/>
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="js/app-ajax.js" type="text/javascript"></script>
</head>
<body>
	<h1>Liste des produits :</h1>
	</br>

	<c:forEach var="type" items="${produits}">

			<c:if test="${admin}">
		<form method="POST" action="ModifierProduit">
			ID : <input type="text" name="idProduit" value="${type.getId()}"
				size="5" readOnly="true" /> Type de Produit : <input type="text"
				name="type" value="${type.getType_produit()}" /> Marque : <input
				type="text" name="marque" value="${type.getMarque()}" /> Stock
			disponible : <input type="text" name="stock"
				value="${type.getStock_dispo()}" />
				<input type="submit" id="sup" name="Supprimer" value="Supprimer" />
				<input type="submit" id="modif" name="Modifier" value="Modifier" />
			<br> .
		</form>

		</c:if>
		<c:if test="${user}">
			<form method="GET" action="AjoutPanier">
				ID : <input type="text" name="idProduit" value="${type.getId()}"
				size="5" readOnly="true" /> Type de Produit : <input type="text"
				name="type" value="${type.getType_produit()}" /> Marque : <input
				type="text" name="marque" value="${type.getMarque()}" /> Stock
				disponible : <input type="text" name="stock" id="qte"
				value="${type.getStock_dispo()}" />
				<input type="submit" id="ajout" name="Ajouter"
					value="Ajouter" />
			</form>

		</c:if>
	</c:forEach>
		<form action="Profile" method="GET">
	  		<input type="submit" value="Profile"/>
		</form>
		
		<div id="listProduit"></div>

</body>
</html>