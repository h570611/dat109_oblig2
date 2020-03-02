<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Legg til bil</title>
</head>
<body>
	<h2>Legg til bil</h2>
	<form action="leggtilbil" method="post">
	
		<a>Registreringsnummer:</a> 
		<input type="text" name="regnr" id="regnr">
		
		<a>Merke:</a> 
		<input type="text" name="merke" id="merke"> 
		
		<a>Farge:</a>
		<input type="text" name="farge" id="farge"> 
		
		<a>Kontor:</a> 
		
				<select	name="kontorValgForBil" id="kontorValgForBil">
					<c:forEach var="k" items="${alleKontor}">
						<option value="${k.id}" id="kontorValForBil">${k.poststed}</option>
					</c:forEach>
				</select> 
				
		<a>PrisKategori:</a>
		
				<select id="kategori" name="kategori">
					<option value="A" selected>A - Liten bil</option>
					<option value="B">B - Mellomstor bil</option>
					<option value="C">C - Stor bil</option>
					<option value="D">D - stasjonsvogv</option>
				</select>
		<input type="submit" name="submit">


	</form>

</body>
</html>