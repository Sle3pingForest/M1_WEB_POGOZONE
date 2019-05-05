<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> Liste des produits : </p></br>

	<c:forEach var="type" items="${produits}">
		
		<form method="POST" action="ModifierProduit">
		        ID :  <input type="text" name="idUser" value="${type.getId()}"  size="5" readOnly="true"/>
				Type de Produit : <input type="text" name="type" value="${type.getType_produit()}" />
				Marque : <input type="text" name="marque" value="${type.getMarque()}" />
				Stock disponible : <input type="text" name="stock" value="${type.getStock_dispo()}" />
				<c:if test="${admin}" >
				<input type="submit" id ="sup" name="Supprimer" value="Supprimer" />
				<input type="submit" id="modif" name="Modifier" value="Modifier" />
				</c:if>
				<br>
.		</form>

	</c:forEach>
	
	

</body>
</html>