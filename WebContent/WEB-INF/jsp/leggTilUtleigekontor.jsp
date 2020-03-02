<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Legg til utleigekontor</title>
</head>
<body>
	<h2>Legg til utleigekontor</h2>
	<form action="leggtilutleigekontor" method="post">
		<h3>Generelt:</h3>
		
		<a>Telefonnummer:</a> 
		<input type="text" name="telefonnummer" id="telefonnummer">
		

		
		<h3>Adresse:</h3>
		
		<a>Gateadresse:</a>
		<input type="text" name="gateadresse" id="gateadresse"> 
		
		<a>Postkode:</a>
		<input type="text" name="postkode" id="postkode"> 
		
		<a>Poststed:</a>
		<input type="text" name="poststed" id="poststed"> 
		<br>
		<input type="submit" name="submit" value="Videre..">

	</form>

</body>
</html>