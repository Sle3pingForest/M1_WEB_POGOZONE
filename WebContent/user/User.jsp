<%@page import="controllers.LogOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/Style.css" type="text/css"/>
<title>Espace USER</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="js/app-ajax.js" type="text/javascript"></script>
</head>
<body>
	<p id="user"> Hello users</p>

	</form>
		<form action="GetListProduit" method="GET">
	  	<input type="submit" value="Liste Produit"/>
	</form>
	
	<form action="Deconnexion" method="GET">
	  	<input type="submit" value="Log Out" onClick="return confirmLogout()"/>
	</form>
	
	
	<form onsubmit="return false;">
		<input type="button" id="monPanier" value="Mon Panier">
	</form>
	<br>
	<br>

	<strong>Les produit dans Mon panier</strong>:
	<div id="listProduit"></div>
	<script type="text/javascript">
		$(document).ready(function() {
		$('#monPanier').on('click', function () {
			$.ajax({
				url : 'MyPanier',
				data : {
					userName : $('#monPanier').val()
				},
				success : function(responseText) {
					$('#listProduit').text(responseText);
				}
			});
		});
	});
	</script>
	
	<script type="text/javascript">
	function confirmLogout(){
		var agree = confirm("voulez-vous deconnecté ?");
		if(agree){
			return true;
		}else{
			return false;
			}
		}
	</script>
</body>
</html>