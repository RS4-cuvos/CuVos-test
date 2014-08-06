<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Cuvos - voeg een persoon toe</title>
<link href="includes/cuvos.css" rel="stylesheet" type="text/css">
</head>


<body>
<form method="post">
<table width="85%" border="1" align="center" cellpadding="0"
  cellspacing="0">
  <tr>
    <td>
    <table width="100%" border="0" align="center" cellpadding="4"
      cellspacing="0" bordercolor="#CCCCCC">
      <tr bgcolor="#c00000" valign="middle">
        <td width="90%" valign="middle">
        <h1 align="center">Voeg een persoon toe</h1>
        </td>
      </tr>
      <tr>
        <td colspan="2">
        <center><spring:bind path="command.*">
         

        <div align="center">
        <p>Geef de voornaam en een persoonID op:</p>
	<p>(Als de PersoonID al voorkomt in de database, wordt die overschreven)</p>
        <p>Voornaam: <spring:bind path="command.voornaam">
          <input name='<c:out value="${status.expression}"/>' type="text" size="6"
            maxlength="100">
        </spring:bind>PersoonID: <spring:bind path="command.persoonID">
          <input name='<c:out value="${status.expression}"/>' type="text" size="8"
            maxlength="3">
        </spring:bind><input type="submit" name="Submit"
          value="Voeg Toe"></p>
        </div>
        </form>
        </td>
      </tr>
      <tr>
        <td colspan="2" bgcolor="#c00000"><h1 align="center">aan de database.</h1></td>
      </tr>
    </table>
    </td>
  </tr>
</spring:bind>
</table>
</body>