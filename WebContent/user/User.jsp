<%@page import="controllers.LogOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Espace USER</title>
</head>
<body>
	<p> hello users</p>
	<%
 	String attribut = (String)request.getAttribute("name");
	out.println( attribut); 
	%>
	<form action="Deconnexion" method="GET">
	  	<input type="submit" value="Log Out" onClick="return confirmLogout()"/>
	</form>
	
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