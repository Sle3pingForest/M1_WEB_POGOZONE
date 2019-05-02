<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajout de produit</title>
</head>
<body>
<form method="post" action="AjoutProduit">

	<label for="type_produit">Type de Produit : </label>
    <input type ="text" name = "type_produit"><br />
    <label for="marque">Marque : </label>
    <input type ="text" name = "marque" /><br/>
	<label for="stock">Stock Disponible : </label>
    <input type="text" name="stock"/>

</form>

</body>
</html>