<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> Liste des produits : </p></br>
	<%/*
String attribut =(String) request.getAttribute("sb");
out.println(attribut);*/
%>
	<c:forEach var="type" items="${produits}">
		
		<form method="POST" action="ModifierProduit">
		         <c:out value="${type.get_Marque()}"></c:out>
				Type de Produit : <input type="text" name="type" value="${type.value}" />
				Marque : <input type="text" name="marque" value="${type.getMarque}" />
				Stock disponible : <input type="text" name="stock" value="${type.getStock_dispo()}" />
				<input type="submit" id ="sup" name="Supprimer" value="Supprimer" />
				<input type="submit" id="modif" name="Modifier" value="Modifier" />
				
				<br>
.		</form>

	</c:forEach>
	
	

</body>
</html>