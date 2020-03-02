<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bekreftelse</title>
</head>
<body>
	<h2>Bekreftelse på ny bil</h2>
	
		<table border="1">
		<tr>
			<th>Registreringsnummer</th>

			
			<th>Merke</th>
			
			<th>Farge</th>
			
			<th>Kontor</th>
			
			<th>PrisKategori</th>
			
		
		</tr>

		<tr>
			<td>${nyBil.regnr}</td>
			<td>${nyBil.merke}</td>
			<td>${nyBil.farge}</td>
			<td>${nyBil.getUtleigekontor().getAdress().poststed}</td>
			<td>${nyBil.getBiltype().description}</td>




		</tr>

	</table>




	<p>
		<a href="ferdig">Ferdig</a>
	</p>

</body>
</html>