<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bekreftelse</title>
</head>
<body>
	<h2>Bekreftelse på nytt utleigekontor</h2>
	
		<table border="1">
		<tr>
			<th>Id</th>

			
			<th>Tlf</th>
			
			<th>Poststed</th>
			
		
		</tr>

		<tr>
			<td>${nyUtleigekontor.id}</td>
			<td>${nyUtleigekontor.telefonnr}</td>
	
			<td>${nyUtleigekontor.getAdress().poststed}</td>





		</tr>

	</table>




	<p>
		<a href="ferdig">Ferdig</a>
	</p>

</body>
</html>