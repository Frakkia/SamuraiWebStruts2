<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Elenco Squadre</title>
</head>
<body>

<!-- FORM DI SELEZIONE TORNEI -->

	<s:form action="squadraSearchJSONAction">
		<s:select list="map" key="squadra.torneo" name="id_torneo" headerKey="-1" headerValue="%{getText('squadra.torneo.tutti')}"></s:select>
		<s:submit label="Filtra"/>	
	</s:form>
	
<!-- TABELLA SQUADRE -->

	<table border="1">
		<thead>
			<tr><th>id</th><th>nome</th><th>Torneo</th><th>Modifica</th><th>Elimina</th></tr>
		</thead>
		<s:iterator value="elenco"  var="el">
			<tr><td>${el.id}</td><td>${el.nome}</td><td>${el.torneo.nome}</td>
			<td><a href="squadraReadAction.action?id=${el.id}"><img src="../img/modifica.png" width="20px"/></a></td>
			<td><a href="squadraDeleteAction.action?id=${el.id}"><img src="../img/elimina.png" width="20px"/></a></td></tr>
		</s:iterator>

	</table>
</body>
</html>