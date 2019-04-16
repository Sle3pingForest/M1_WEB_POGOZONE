<%@page import="controllers.Servlet1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calculatrice du turfu </title>
</head>
<body>
	<p> la cookie au chocolat </p>
	<%-- TP1
		String droite = (String)request.getAttribute("Droite");
		String gauche = (String)request.getAttribute("Gauche");
		out.println( droite + " + " + gauche  + " = "  );
	 	String attribut = (String)request.getAttribute("Res");
    	out.println( attribut);
	--%>
	<%-- TP2 Exo 1
		<form method="GET"/>
	 	<%
			if(request.getParameter("name") != null && request.getParameter("valeur") != null){
			 	Cookie cookie = new Cookie(request.getParameter("name"), request.getParameter("valeur"));
			 	cookie.setMaxAge(15);
			    response.addCookie(cookie );
			 	String attribut = (String)request.getAttribute("cookie");
		    	out.println( attribut); 
		    }
    	%>
    	<br>
		Name<input type="text" name = "name" value="pikachu"/>
		<br>
		Valeur<input type="text" name = "valeur"  value="pikachu"/>
		<br>
	  	<input type="submit" value="Cuisson de cookie"/>
	  </form>
	--%>
	<form action ="Servlet1" method="GET">
	 	<%
			if(request.getParameter("name") != null && request.getParameter("valeur") != null){
			 	Cookie cookie = new Cookie(request.getParameter("name"), request.getParameter("valeur"));
			 	cookie.setMaxAge(15);
			    response.addCookie(cookie );
			 	String attribut = (String)request.getAttribute("cookie");
		    	out.println( attribut); 
		    }
    	%>
    	<br>
		ID <input type="text" name = "name" value="id"/>
		<br>
		Pass Word<input type="text" name = "valeur"  value="password"/>
		<br>
	  	<input type="submit" value="Log In"/>
	  </form>
	
	
</body>
</html>