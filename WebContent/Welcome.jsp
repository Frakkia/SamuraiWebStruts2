<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina di Benvenuto</title>
</head>
<body>
Benvenuto <s:property value="utente.nome"/>
<s:property value="utente.cognome"/>
<s:property value="utente.profilo" /><br>
<a href="torneoListAction.action">Elenco Tornei</a><br>
<a href="torneoForm.jsp">Inserisci Torneo</a>
</body>
</html>