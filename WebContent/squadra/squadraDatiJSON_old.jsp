<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

[

<s:iterator value="elenco"  var="item">

	{
		'id':${item.id},
 		'nome':'${item.nome}',
 		'torneo':'${item.torneo.nome}'
	},
</s:iterator>
]
