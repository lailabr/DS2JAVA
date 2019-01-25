
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome Mr/Mme <c:out value="${agent.login }"/></h1>
</body>

<table border="1">
	<tr>
		<th>nom</th>
		<th>prenom</th>
		<th>payement</th>
		
	</tr>
	<c:forEach items="${AllAbonnees }" var="abonnee">
	<tr>
		<td><c:out value="${abonnee.nom}"/></td>
		<td><c:out value="${abonnee.prenom}"/></td>
		<td><c:out value="${abonnee.payement}"/></td>
	</tr>
	</c:forEach>
</table>
</html>