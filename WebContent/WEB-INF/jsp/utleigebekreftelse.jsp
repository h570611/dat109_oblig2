<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Utleigebekreftelse</title>
</head>
<body>
<h2>Utleigebekreftelse</h2>
	

	<form action="utleigebekreftelse" method="get">
	<p>Du har no leid ut bil med: </p>
	
	<p>ReservasjonsID:  ${resValg.reservasjonsid}</p>
	<p>Regnr:  ${resValg.getBilBean().regnr}</p>
	<p>Kilometerstand:  ${resValg.kmstandinn}</p>

	
	
	</form>

	<p>
		<a href="ferdig">Ferdig</a>
	</p>
</body>
</html>