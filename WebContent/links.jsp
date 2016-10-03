<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Homepage</title>
</head>
<body>

<ul>
	<li><a href="torneo/torneoSearchAction.action">Elenco tornei</a>
	<li><a href="torneo/torneoReadAction.action?request_locale=it">Inserisci un torneo</a>
	<li><s:url action="torneo/torneoReadAction" var="linkTorneoReadActionES">
		<s:param name="request_locale">es</s:param>
		</s:url>
	<a href="${linkTorneoReadActionES}">creas un nuevo torneos</a></li>
	<li><a href="squadra/squadraSearchAction.action">Elenco squadre</a></li>
	<li><a href="squadra/squadraReadAction.action">Inserisci una squadra</a></li>
	<li><a href="societa/societaSearchAction.action">Elenco società</a></li>
	<li><a href="societa/societaReadAction.action">Inserisci una società</a></li>
</ul>


</body>
</html>