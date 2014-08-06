<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Cuvos - personenlijst</title>
<link href="includes/cuvos.css" rel="stylesheet" type="text/css">
</head>

<body>
<table width="85%" border="1" align="center" cellpadding="0"
	cellspacing="0">
<tr>
	<td>
	<table width="100%" border="0" align="center" cellpadding="4"
		cellspacing="0" bordercolor="#CCCCCC">
        <tr bgcolor="#c00000">
			<td width="90%" height="60" valign="middle">
			<h1 align="center">Personenlijst</h1>
			</td>
	        
		</tr>
		<tr>
			<td colspan="2">
			
		<p align="center">Hieronder staat de lijst met alle personen in de database.</p>
		<table border="1" align="center" cellpadding="8" cellspacing="0">
			<tr>
				<th>Voornaam</th>
				<th>Persoon Id</th>
			</tr>
			<c:forEach items="${personen}" var="persoon">
				<tr>
					<td align="center"><c:out 
					value="${persoon.voornaam}" />
					<div></div>
					</td>
					<td align="center">
					<c:out value="${persoon.persoonID}" />
						<div></div>
						</td>
					</tr>
				</c:forEach>
	<td colspan="2" align="center" nowrap="nowrap"><a href="voegpersoontoe.htm">Voeg een persoon toe.</a></td>
			</table>
			</td>
		</tr>
	</table>
	</td>
</tr>
</table>

</body>
</html>
