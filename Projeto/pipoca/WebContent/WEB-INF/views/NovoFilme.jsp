<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo Filme</title>
</head>
<body>
	<form action="inserir" method='post'>
		<input type='text' name='titulo'>
		<select name='genero.id'>
		<c:forEach var="genero" items="${generos}">
			<option value="${genero.id}">${genero.nome}</option>
		</c:forEach>
		</select>
		<input type='submit' value='enviar'>
	</form>
</body>
</html>