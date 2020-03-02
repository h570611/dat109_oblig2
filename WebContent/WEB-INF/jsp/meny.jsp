<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Meny</title>
</head>
<body>
	<h2>Meny</h2>

	<p>For kunder:</p>

	<button style="position: relative; left: 175px;"
		class="pure-button pure-button-primary"
		onclick="window.location.href = 'bilsok';">Bilsøk</button>

	<p>For admin:</p>

	<button style="position: relative; left: 175px;"
		class="pure-button pure-button-primary"
		onclick="window.location.href = 'utleige';">Utleige</button>

	<button style="position: relative; left: 175px;"
		class="pure-button pure-button-primary"
		onclick="window.location.href = 'innlevering';">Innlevering</button>

	<button style="position: relative; left: 175px;"
		class="pure-button pure-button-primary"
		onclick="window.location.href = 'leggtilbil';">Legg til ny Bil</button>

	<button style="position: relative; left: 175px;"
		class="pure-button pure-button-primary"
		onclick="window.location.href = 'leggtilutleigekontor';">Legg til
		nytt utleigested</button>
	<p>
		<a href="ferdig">Ferdig</a>
	</p>
</body>
</html>