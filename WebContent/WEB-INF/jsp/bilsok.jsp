<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Bilsøk</title>
</head>
<body>
	<h2>Velg utleigested:</h2>
	<p></p>
	<p>
		<font color="red" id="ugyldig"> ${feilmelding} </font>
	</p>



	<!-- 
	<select name="kontorValg" id="kontorValg">
		<c:forEach var="k" items="${alleKontor}">
			<option value="${k.id}" id="kontorVal">${k.poststed}</option>
		</c:forEach>
	</select>
	
				<select id="kontorValg" name="kontorValg">
					<option value="1" selected>Førde</option>
					<option value="2">Sogndal</option>
				</select>
-->

	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-controls">
				<p>Velg frå-dato:</p>
				<input type="date" name="fraTidspunkt" id="fraTidspunkt">

				<p>Velg til-dato:</p>
				<input type="date" name="tilTidspunkt" id="tilTidspunkt"> 
				
				<p>Hentekontor:</p>
				<select
					name="kontorValg" id="kontorValg">
					<c:forEach var="k" items="${alleKontor}">
						<option value="${k.id}" id="kontorVal">${k.poststed}</option>
					</c:forEach>
				</select> 
				
				<p>Leveringskontor: </p>
				<select name="kontorValgLevering" id="kontorValgLevering">
					<c:forEach var="k" items="${alleKontor}">
						<option value="${k.id}" id="kontorValLevering">${k.poststed}</option>
					</c:forEach>
				</select>




				<button type="submit" id="søkKnapp"
					class="pure-button pure-button-primary">Submit</button>
			</div>
		</fieldset>
	</form>

	<p>
		<a href="ferdig">Ferdig</a>
	</p>


</body>
</html>