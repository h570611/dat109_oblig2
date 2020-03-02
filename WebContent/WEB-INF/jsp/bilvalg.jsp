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
<title>Bilvalg</title>
</head>
<body>
	<h2>Ledige bilar:</h2>
	<p></p>






	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-controls">


				<select name="bilValg" id="bilValg">
					<c:forEach var="k" items="${alleLedigeBiler}">
						<option value="${k.regnr}" id="bilVal">Regnr: ${k.regnr}
							Merke: ${k.merke} Pris: ${k.biltype.pris}</option>
					</c:forEach>
				</select>
				<br>
				<button type="submit" id="søkKnapp"
					class="pure-button pure-button-primary">Submit</button>
			</div>
		</fieldset>
	</form>

	<button style="position: relative; left: 175px;"
		class="pure-button pure-button-primary"
		onclick="window.location.href = 'bilsok';">Tilbake</button>

	<p>
		<a href="ferdig">Ferdig</a>
	</p>
</body>
</html>