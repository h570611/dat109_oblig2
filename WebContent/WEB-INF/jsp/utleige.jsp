<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Utleige</title>
</head>
<body>
	<h2>Utleige</h2>
	<form action="utleige" method="post">
		<p>Velg reservasjon</p>
		
				<select name="resValg" id="resValg">
					<c:forEach var="k" items="${alleReservasjoner}">
						<option value="${k.reservasjonsid}" id="resVal">Id: ${k.reservasjonsid} Regnr: ${k.getBilBean().regnr}
							</option>
					</c:forEach>
				</select>
				
				<p>Noverandre kilometerstand: </p>
				<input type="text" name="kmstand" id="kmstand">
				
				<p>Kredittkortnummer:  </p>
				<input type="text" name="krednr" id="krednr">
	
	
	
	<input type="submit" name="submit" id="submit" value="Lei ut">
	</form>
	
</body>
</html>