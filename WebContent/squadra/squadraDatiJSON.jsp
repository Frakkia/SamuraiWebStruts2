<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.atg.com/taglibs/json" prefix="json" %>

<json:array name="squadre" var="squadra" items="${elenco}">
	<json:object>
		<json:property name="id" value="${squadra.id}"/>
		<json:property name="nome" value="${squadra.nome}"/>
		<json:property name="torneo" value="${squadra.torneo.nome}"/>
	</json:object>
</json:array>