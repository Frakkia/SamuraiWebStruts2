<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form inserimento Squadre</title>
</head>
<body>
<s:text name="package.messaggio"/>
<s:text name="application.title"/>
<s:fielderror></s:fielderror>
<s:form action="%{actionDaInvocare}">
	<s:hidden name="squadra.id" label="ID"></s:hidden>
	<s:textfield name="squadra.nome" key="squadra.nome"></s:textfield>
	<s:select list="map" key="squadra.torneo" name="id_torneo" headerKey="-1" headerValue="%{getText('squadra.torneo')}"></s:select>
	<s:submit label="Invia"></s:submit>
</s:form>
</body>
</html>