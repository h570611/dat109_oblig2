<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Logg inn</title>
</head>
<body>
	<h2>Logg inn</h2>
	<p>Pinkoden er: 12345</p>
	<p>
		<font color="red" id="ugyldig"> ${feilmeld} </font>
	</p>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="mobil">Mobil:</label> <input type="text" id="mobil" name="mobil" />
			</div>
			<div class="pure-control-group">
				<label for="pin">Pin:</label> <input type="password"
					name="pin" id="pin"/>
			</div>
			<div class="pure-controls">
				<button type="submit" id="loggInnButton" class="pure-button pure-button-primary">Logg
					inn</button>
			</div>
		</fieldset>
	</form>

<!-- 
	<button style="position:relative; left:175px; " class="pure-button pure-button-primary" 
	onclick="window.location.href = 'meny';">Meny</button>
 -->	
	
	<script src="js/script-logginn.js" charset="utf-8" defer></script>

</body>
</html>