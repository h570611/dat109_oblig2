<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservasjonsbekreftelse</title>
</head>
<body>
	<h2>Reservasjonsbekreftelse</h2>
	<table border="1">
		<tr>
			<th>Reservasjonsnummer</th>

			<th>Fornavn</th>
			<th>Etternavn</th>

			<th>Frå dato</th>
			<th>Til dato</th>

			<th>Kontor for henting</th>
			<th>Kontor for levering</th>

			<th>Registreringsnummer</th>
			<th>Merke</th>
		</tr>

		<tr>
			<td>${reservasjon.reservasjonsid}</td>

			<td>${reservasjon.getKundeBean().fornavn}</td>
			<td>${reservasjon.getKundeBean().etternavn}</td>

			<td>${reservasjon.fradato}</td>
			<td>${reservasjon.tildato}</td>

			<td>${reservasjon.getUtleigekontor1().getAdress().poststed}</td>
			<td>${reservasjon.getUtleigekontor2().getAdress().poststed}</td>

			<td>${reservasjon.getBilBean().regnr}</td>
			<td>${reservasjon.getBilBean().merke}</td>


		</tr>

	</table>




	<p>
		<a href="ferdig">Ferdig</a>
	</p>
</body>
</html>