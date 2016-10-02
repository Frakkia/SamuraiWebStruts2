<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento Utente</title>
</head>
<body>
<s:fielderror></s:fielderror>
<s:form action="utenteAction">
	<s:textfield name="utente.id" label="ID"></s:textfield>
	<s:textfield name="utente.nome" label="Nome"></s:textfield>
	<s:textfield name="utente.cognome" label="Cognome"></s:textfield>
	<s:textfield name="utente.profilo" label="Profilo"></s:textfield>
	<s:submit label="Invia"></s:submit>
</s:form>
</body>
</html>