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

<table border="1">
	<thead>
		<tr><th>id</th><th>nome</th><th>Squadra</th><th>Modifica</th><th>Elimina</th></tr>
	</thead>
	<s:iterator value="elenco"  var="item">
		<tr><td>${item.id}</td><td>${item.nome}</td><td>${item.squadra.nome}</td>
		<td><a href="societaReadAction.action?id=${item.id}"><img src="../img/modifica.png" width="20px"/></a></td>
		<td><a href="societaDeleteAction.action?id=${item.id}"><img src="../img/elimina.png" width="20px"/></a></td></tr>
	</s:iterator>
	<s:form action="societaSearchAction">
		<s:select list="map" key="package.scegli.squadra" name="id_squadra" headerKey="-1" headerValue="%{getText('societa.squadra.tutti')}"></s:select>
	<s:submit label="Filtra"/>
	</s:form>
</table>
</body>
</html>