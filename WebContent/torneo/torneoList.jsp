<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Tornei</title>
</head>
<body>
<s:if test="">
	<s:text name="torneo.inserito"/>
</s:if>
<table border="1">
	<thead>
		<tr><th>id</th><th>nome</th><th>Anno Edizione</th><th>Modifica</th><th>Elimina</th></tr>
	</thead>
	<s:iterator value="elenco"  var="t">
		<tr><td>${t.id}</td><td>${t.nome}</td><td>${t.annoEdizione}</td>
		<td><a href="torneoReadAction.action?id=${t.id}"><img src="../img/modifica.png" width="20px"/></a></td>
		<td><a href="torneoDeleteAction.action?id=${t.id}"><img src="../img/elimina.png" width="20px"/></a></td></tr>
	</s:iterator>
</table>
</body>
</html>