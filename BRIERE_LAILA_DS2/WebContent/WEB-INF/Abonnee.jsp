
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page Abonnee</title>
</head>
<body>
<h1>Paiment de Facture en ligne</h1>
<h3>Mr/Mme : <c:out value="${abonnee.nom} ${abonnee.prenom } "/></h3>
<h3>Numero : <c:out value="${abonnee.id }"/></h3>
<h3>Montant : <c:out value="${abonnee.montant }"/></h3>
<form method="post" action="Servlet" >
	<fieldset>
		<legend> Payement</legend>
		
		<label for="numCart"> Numero de Carte : </label>
		<input type="text" id="numCart" name="numCart" size="20" maxlength="20" /> 
		<br/>
		
		<label for="dateExpir"> Date d'Expiration :</label>
		<input type="text" id="dateExpir" name="dateExpir" size="20" maxlength="20" /> 
		<br/>
		
		<label for="chiffres"> trois derniers ciffres  :</label>
		<input type="text" id="chiffres" name="chiffres"  size="20" maxlength="20" /> 
		<br/>
		
		
		
		<input type="submit" value="Valider" class="boutton" name="action"> 
		<input type="reset" value="Effacer" class="boutton"> <br/>
		<span style="color: red;"><c:out value="${MessageErreur }"/></span>
		
	
	</fieldset>

</form>


</body>
</html>