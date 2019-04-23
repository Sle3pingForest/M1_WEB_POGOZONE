<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des utilisateur</title>
</head>
<body>
	 	<%
	 		String listusers = (String)request.getAttribute("lu");
			if((String)request.getAttribute("lu") != null ){
				out.println(listusers);

		    }
    	%>
</body>
</html>